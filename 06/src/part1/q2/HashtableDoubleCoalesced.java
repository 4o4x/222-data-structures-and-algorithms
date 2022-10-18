import java.util.*;

class HashtableDoubleCoalesced < K, V > implements KWHashMap< K , V> {

    /**Table*/
    private Entry < K,V >[] table;

    /**Capacity */
    private int capacity = 11;

    /**Prime Number */

    private int prime = 7;

    /**Number of Keys */
    private int numOfKeys;

    private static double loadFactor = 0.75;


    /** key-value pair for hash table */

    class Entry < K,V > {

        /**Key */
        private K key;

        /**Value */
        private V value;

        /**Index */
        private int id;

        /**Next*/
        protected Entry<K,V> next;

        /**Construct a new key-value pair
            @param tKey the key
            @param tValue the value
        */

        public Entry(K tKey,V tValue){
            key = tKey;
            value = tValue;
            next = null;
            id = -1;
        }

        /**returns the key
            @return the key
        */

        public K getKey(){
            return key;
        }

        /**returns the key
            @return the value
        */

        public V getValue(){
            return value;
        }

        /** sets the vaule
            @param val new value
            @return returns old value
             */

        public V setKey(V val){
            V oldV = val;
            value = val;
            return oldV;
        }

        public Entry<K,V> setNext(Entry<K,V> node){
            Entry<K,V> oldNext = this.next;
            this.next = node;
            return oldNext;
        }

        public int getIndex(){
            return id;
        }

        public int setIndex(int i){
            int oldId = id;
            id = i;
            return oldId;
        }

        public String toString(){
            return key.toString()  + "/" + value.toString();
        }



    }


    /** Default Constructor */

    HashtableDoubleCoalesced(){
        table = new Entry[capacity];
        numOfKeys = 0;
    }

    /** returns the value associated with the key 
        @param key the key to search
        @return  if found returns the value associated with the key other wise returns null */

    public V get(Object key){
        
        int index = hashFunction((K)key,0);
        
        if(table[index] == null) return null;

        Entry<K,V> temp = table[index];

        while(temp != null){
            if(temp.getKey().equals(key)) return temp.getValue();
            temp = temp.next;
        }

        return null;

    }

    /**puts the key/value pair in table
    @param key the key to put in
    @param value the value to put in
    @return returns null
    */

    public V put(K key, V value){

        

        if((double)numOfKeys >= threshold()) {
            rehash();
            
        }

        numOfKeys++;
        

        int index = hashFunction(key,0);

        if(table[index] == null){
            table[index] = new Entry(key,value);
            table[index].setIndex(index);
            return null;
        }

        Entry<K,V> temp = table[index];

        while(temp.next != null){
            temp = temp.next;
        }
        
        
        for(int i = 1;;i++){
             
            index = hashFunction(key,i);
            
            if(table[index] == null){
                table[index] = new Entry(key,value);
                table[index].setIndex(index);
                temp.next = table[index];
                return null;
            }
        }
        
       
    }

    /** remove key/vaule pair from table
    @param key the key to be removed
    @return returns he old value associated with this key if found; otherwise, null
     */

    public V remove(Object key){
        
        int index = hashFunction((K)key,0);
        
        if(table[index] == null) return null;

        

        if(table[index].getKey().equals((K)key)) return firstRemove(key,index);

        Entry <K,V> head = table[index];
        

        while(head.next != null){
            
            if(head.next.getKey().equals((K)key)){
                
                Entry<K,V> temp;
                index = head.next.getIndex();
                head = head.next;
                V old = table[index].getValue();
                int tempIndex;
                
                while(table[index].next!=null){
                    
                    tempIndex = index;
                    temp = table[index];
                    table[index] = temp.next;
                    tempIndex = table[index].getIndex();
                    table[index].setIndex(index);
                    index = tempIndex;
                }

                table[index] = null;
                numOfKeys--;
                return old;

            }

            if(head.next.next == null && head.next.getKey().equals((K)key)){
                index = head.next.getIndex();
                table[index] = null;
                V old = head.next.getValue();
                head.next = null;

                numOfKeys--;
                return old;
            }

            head = head.next;
        }

        return null;
    }


    private V firstRemove(Object Key,int index){
    
        Entry<K,V> temp;
        V old = table[index].getValue();
        int tempIndex;
        
        while(table[index].next!=null){
            
            tempIndex = index;
            temp = table[index];
            table[index] = temp.next;
            tempIndex = table[index].getIndex();
            table[index].setIndex(index);
            index = tempIndex;
        }

        table[index] = null;
        numOfKeys--;
        return old;
    }

    /**returns number of entries
    @return returns number of entries */

    public int size(){
        return numOfKeys;
    }
    /**Checks if table is empty 
    @return returns true if table is empyt: other wise false*/

    public boolean isEmpty(){
        if(size()==0) return true;
        else return false;
        
    }

    /**returns string format of hash table
    @return  returns string format of hash table*/

    public String toString(){
        String s = "";
        for(int i=0;i<capacity;i++){
            s = s + i + " -- ";

            if(table[i] == null)
                s = s + "null -- null\n";
            else {
                s = s +  table[i].toString();

                if(table[i].next == null){
                    s = s + " -- null\n";
                }

                else s = s + " -- " + table[i].next.getIndex() + "\n"; 
            }
        }

        return s;
    }

    private int hashFunction(K key,int probe){
        return (hash1(key)+( probe*hash2(key) )) % capacity;
 
    }

    private int hash1(K key){
        int h = key.hashCode() % capacity;
        if(h<0) h += capacity;

        return h; 
    }

    private int hash2(K key){
        int h = (key.hashCode() % prime);

        if(h<0) h += prime;

        return prime - h;
    }


    private void rehash(){
        numOfKeys = 0;
        
        Entry < K,V >[] oldTable = table;

        
        capacity = findPrime(capacity * 2 + 1);


        table = new Entry[capacity];

        prime = findPrime((int)(capacity*0.8));

        for(int i=0;i<oldTable.length;i++){
            if(oldTable[i] != null) put(oldTable[i].getKey(),oldTable[i].getValue()); 
        }        
    }

    private double threshold(){
        return capacity*loadFactor;
    }

    

    private int findPrime(int number){
        
        boolean flag = true;        

        for(int i = number; i>0 ; i--){
            flag = true;

            for(int j = 2;j<i;j++){
                
                if(i%j == 0){
                    flag = false;
                    continue;
                }
                
            }

            if(flag == true){
                return i;
            }
        }

        return 0;
    }

    


    

}

