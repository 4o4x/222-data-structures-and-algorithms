import java.io.*;
import java.util.*;

class main{
    public static void main(String[] args){
        
        int number;
        Random rand = new Random();

        //Declaration Test
        HashtableBST<Integer,String> table = new HashtableBST();
        
        System.out.println("-----------Put test-----------\n"); 

        System.out.println("\nAdd Key:1 Value: honda"); 
        table.put(new Integer(1),"honda");
        System.out.println(table); 

        System.out.println("\nAdd Key:10 Value: acura"); 
        table.put(new Integer(10),"acura"); 
        System.out.println(table); 

        System.out.println("\nAdd Key:22 Value: lexus"); 
        table.put(new Integer(22),"lexus");
        System.out.println(table); 


        System.out.println("\nAdd Key:33 Value: mazda"); 
        table.put(new Integer(33),"mazda");
        System.out.println(table); 


        System.out.println("\nAdd Key:44 Value: subaru"); 
        table.put(new Integer(44),"subaru");
        System.out.println(table); 


        System.out.println("\nAdd Key:55 Value: mitsubishi"); 
        table.put(new Integer(55),"mitsubishi");
        System.out.println(table);  


        System.out.println("\nAdd Key:66 Value: nissan");  
        table.put(new Integer(66),"nissan");
        System.out.println(table); 


        System.out.println("\nAdd Key:77 Value: toyota"); 
        table.put(new Integer(77),"toyota");
        System.out.println(table); 


        System.out.println("\nAdd Key:88 Value: suzuki"); 
        table.put(new Integer(88),"suzuki");
        System.out.println(table);   
        

        System.out.println("\n-----------Get test-----------\n"); 
        

        System.out.println(table); 
        
        System.out.println( "Get 0: " + table.get(new Integer(0)));
        System.out.println( "Get 11: " + table.get(new Integer(11)));
        System.out.println( "Get 33: " + table.get(new Integer(33)));
        System.out.println( "Get 8: " + table.get(new Integer(8)));
        System.out.println( "Get 7: " + table.get(new Integer(7)));
        System.out.println( "Get 77: " + table.get(new Integer(77)));


        System.out.println("\n-----------Remove test-----------\n");

        System.out.println(table);

        System.out.println("\nRemove 55"); 
        table.remove(55);
        System.out.println(table);

        System.out.println("\nRemove 1"); 
        table.remove(1);
        System.out.println(table);

        System.out.println("\nRemove 88"); 
        table.remove(88);
        System.out.println(table);

        


        

        
        
        //System.out.println(table); 


        

        HashtableBST<Integer,String> table100 = new HashtableBST();
        HashtableBST<Integer,String> table1000 = new HashtableBST();
        HashtableBST<Integer,String> table10000 = new HashtableBST();

        
        

        long startTime;
        long endTime;


        startTime = System.nanoTime();

        for(int i = 0; i<100;i++){
            
            number = rand.nextInt(2147483640);
            table100.put(new Integer(number),"test");
        }

        endTime = System.nanoTime();

        System.out.println("Insert 100   random element in hash table take: " + (endTime-startTime) + " nanoTime");
        

        startTime = System.nanoTime();

        for(int i = 0; i<1000;i++){
            
            number = rand.nextInt(2147483640);
            table1000.put(new Integer(number),"test");
        }

        endTime = System.nanoTime();

        System.out.println("Insert 1000  random element in hash table take: " + (endTime-startTime) + " nanoTime");


        startTime = System.nanoTime();

        for(int i = 0; i<10000;i++){
            
            number = rand.nextInt(2147483640);
            table10000.put(new Integer(number),"test");
        }

        endTime = System.nanoTime();

        System.out.println("Insert 10000 random element in hash table take: " + (endTime-startTime) + " nanoTime");
        

        System.out.println("\n------------------------------");
        
        startTime = System.nanoTime();
        table100.put(new Integer(2147483646),"test");

        endTime = System.nanoTime();
        System.out.println("Insert a random element in hash table which have 100   element take: " + (endTime-startTime) + " nanoTime");

        
        

        startTime = System.nanoTime();
        table1000.put(new Integer(2147483646),"test");

        endTime = System.nanoTime();
        System.out.println("Insert a random element in hash table which have 1000  element take: " + (endTime-startTime) + " nanoTime");

        

        
        startTime = System.nanoTime();
        table10000.put(new Integer(2147483646),"test");

        endTime = System.nanoTime();
        System.out.println("Insert a random element in hash table which have 10000 element take: " + (endTime-startTime) + " nanoTime");




        System.out.println("\n------------------------------");



        startTime = System.nanoTime();
        table100.get(new Integer(2147483646));

        endTime = System.nanoTime();
        System.out.println("accessing existing items at hash table which have 100   element take: " + (endTime-startTime) + " nanoTime");

        
        

        startTime = System.nanoTime();
        table1000.get(new Integer(2147483646));

        endTime = System.nanoTime();
        System.out.println("accessing existing items at hash table which have 1000  element take: " + (endTime-startTime) + " nanoTime");

        

        
        startTime = System.nanoTime();
        table10000.get(new Integer(2147483646));

        endTime = System.nanoTime();
        System.out.println("accessing existing items at hash table which have 10000 element take: " + (endTime-startTime) + " nanoTime");



        System.out.println("\n------------------------------");



        startTime = System.nanoTime();
        table100.remove(new Integer(2147483646));

        endTime = System.nanoTime();
        System.out.println("remove items at hash table which have 100   element take: " + (endTime-startTime) + " nanoTime");

        
        

        startTime = System.nanoTime();
        table1000.remove(new Integer(2147483646));

        endTime = System.nanoTime();
        System.out.println("remove items at hash table which have 1000  element take: " + (endTime-startTime) + " nanoTime");

        

        
        startTime = System.nanoTime();
        table10000.remove(new Integer(2147483646));

        endTime = System.nanoTime();
        System.out.println("remove items at hash table which have 10000 element take: " + (endTime-startTime) + " nanoTime");
        



        System.out.println("\n------------------------------");



        startTime = System.nanoTime();
        table100.get(new Integer(2147483646));

        endTime = System.nanoTime();
        System.out.println("accessing non existing items at hash table which have 100   element take: " + (endTime-startTime) + " nanoTime");

        
        

        startTime = System.nanoTime();
        table1000.get(new Integer(2147483646));

        endTime = System.nanoTime();
        System.out.println("accessing non existing items at hash table which have 1000  element take: " + (endTime-startTime) + " nanoTime");

        

        
        startTime = System.nanoTime();
        table10000.get(new Integer(2147483646));

        endTime = System.nanoTime();
        System.out.println("accessing non existing items at hash table which have 10000 element take: " + (endTime-startTime) + " nanoTime");

        



        
    }
}