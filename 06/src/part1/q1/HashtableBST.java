import java.util.*;
import java.io.*;

class HashtableBST < K extends Comparable < K >, V extends Comparable < V >> implements KWHashMap< K , V> {

    /**Table*/
    private Entry < K,V >[] table;

    /**Capacity */
    private static int capacity = 5;

    /**Number of Keys */
    private int numOfKeys;

    /**put return value */

    private V addReturn;

    /**temove return value */

    private V removeReturn;

    private static final int LOAD_THRESHOLD = 1000;

    



    /** key-value pair for hash table */

    class Entry < K extends Comparable < K >, V extends Comparable < V > > implements Comparable<Entry <K,V> > {

        /**Key */
        private K key;

        /**Value */
        private V value;

        /** Reference to the left child. */
        protected Entry<K,V> left;

        /** Reference to the right child. */
        protected Entry<K,V> right;

        /**Construct a new key-value pair
            @param tKey the key
            @param tValue the value
        */

        public Entry(K tKey,V tValue){
            key = tKey;
            value = tValue;
            left = null;
            right = null;
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

        public int compareTo(Entry<K,V> other){
            int cmp = key.compareTo(other.key);
            if( cmp == 0) return 0;
            else if(cmp == -1) return -1;
            else return 1;
        }

        public String toString(){
            return value.toString();
        }

    }


    /** Default Constructor */

    HashtableBST(){
        table = new Entry[capacity];
        numOfKeys = 0;
    }

    /** returns the value associated with the key 
        @param key the key to search
        @return  if found returns the value associated with the key other wise returns null */

    public V get(Object key){
        int index = ((K)key).hashCode() % capacity;

        return find(table[index],(K)key);
    }

    private V find(Entry<K,V> root, K key) {
        
        if (root == null)
            return null;

        // Compare the key with the key field at the root.
        int compResult = key.compareTo(root.key);
        
        if (compResult == 0)
            return root.getValue();
        else if (compResult < 0)
            return find(root.left, key);
        else
            return find(root.right, key);
    }

    /**puts the key/value pair in table
    @param key the key to put in
    @param value the value to put in
    @return returns null
     */

    public V put(K key, V value){
        
        int index = key.hashCode() % capacity;

        if(numOfKeys>threshold()){
            rehash();
            numOfKeys = 0;
        }
        
        table[index] = add(table[index],key,value);

        if(addReturn == null) numOfKeys++;

        return addReturn;
    }


    private Entry<K,V> add(Entry<K,V> root,K key,V value){
        
        if (root == null) {
            // key is not in the tree insert it.
            addReturn = null;
            return new Entry < K,V > (key,value);
        }

        else if (key.compareTo(root.key) == 0) {
            // key is equal to root.key
            addReturn = root.value;
            root.value = value;
            return root;
        }
        else if (key.compareTo(root.key) < 0) {
            // key is less than root.key
            root.left = add(root.left, key ,value);
            return root;
        }
        else {
            // key is greater than root.key
            root.right = add(root.right, key ,value);
            return root;
        }

        
    }

    /** remove key/vaule pair from table
    @param key the key to be removed
    @return returns he old value associated with this key if found; otherwise, null
     */

    public V remove(Object key){
        int index = key.hashCode() % capacity;

        table[index] = delete(table[index],(K)key);

        if(removeReturn != null) numOfKeys--;

        return removeReturn;
    }

    private  Entry<K,V> delete(Entry<K,V> root,K key){

        if (root == null) {
            // key is not in the tree.
            removeReturn = null;
            return root;
        }

        // Search for key to delete.
        int compResult = key.compareTo(root.key);
        if (compResult < 0) {
            // key is smaller than root.key.
            root.left = delete(root.left, key);
            return root;
        }

        else if (compResult > 0) {
            // key is larger than root.key.
            root.right = delete(root.right, key);
            return root;
        }

        else {
            // key is at local root.
            removeReturn = root.value;
            if (root.left == null) {
                // If there is no left child, return right child
                // which can also be null.
                return root.right;
            }
            else if (root.right == null) {
                // If there is no right child, return left child.
                return root.left;
            }
            else{
                // Node being deleted has 2 children, replace the key
                // with inorder predecessor.
                if (root.left.right == null) {
                // The left child has no right child.
                // Replace the key with the key in the
                // left child.
                root.key = root.left.key;
                // Replace the left child with its left child.
                root.left = root.left.left;
                return root;
                }

                else {
                    // Search for the inorder predecessor (ip) and
                    // replace deleted nodes key with ip.
                    root.key = findLargestChild(root.left);
                    return root;
                }
            }
        }


    }


    private K findLargestChild(Entry<K,V> parent) {
        // If the right child has no right child, it is
        // the inorder predecessor.
        if (parent.right.right == null) {
            K returnValue = parent.right.key;
            parent.right = parent.right.left;
            return returnValue;
        }
        else {
            return findLargestChild(parent.right);
        }
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
            
            if(table[i] == null)
                s = s + "null\n";
                
            else{
                StringBuilder sb = new StringBuilder();
                preOrderTraverse(table[i], 1, sb);
                s += sb.toString();
            }
        }

        return s;
    }

    private void rehash(){
        
        Entry < K,V >[] oldTable = table;

        int oldCap = capacity;
        capacity = capacity * 2 + 1;

        

        table = new Entry[capacity];

        // 

        for(int i=0;i<oldCap;i++){
            if(oldTable[i] != null) put(oldTable[i].getKey(),oldTable[i].getValue());
        }        
    }


    private int threshold(){
        return (int)(capacity*LOAD_THRESHOLD);
    }

    private void preOrderTraverse(Entry<K,V> node, int depth,StringBuilder sb) {
    
        for (int i = 1; i < depth; i++) {
            sb.append("  ");
        }
        if (node == null) {
            sb.append("null\n");
        }
        else {
            sb.append(node.toString());
            sb.append("\n");
            preOrderTraverse(node.left, depth + 1, sb);
            preOrderTraverse(node.right, depth + 1, sb);
        }
  }
    

}

