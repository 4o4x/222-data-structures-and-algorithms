import java.io.*;
import java.util.*;

class main{
    public static void main(String[] args){
        
        int number;
        Random rand = new Random();

        Integer [] test1 = new Integer[10];
        Integer [] test2 = new Integer[10];

        for(int i = 0; i<10;i++){
            number = rand.nextInt(50);
            test1[i] = new Integer(number);
            test2[i] = new Integer(number);
        }

        System.out.println("Sort Test\n---------");

        System.out.println("Unsorted Array:" + Arrays.toString(test2));

        QuickSort(test1);
        MergeSort(test2);

        System.out.println("QuickSort:" + Arrays.toString(test1));
        System.out.println("MergeSort:" + Arrays.toString(test2));




        

        Integer [] quick100 = new Integer[100];
        Integer [] quick1000 = new Integer[1000];
        Integer [] quick10000 = new Integer[10000];

        Integer [] merge100 = new Integer[100];
        Integer [] merge1000 = new Integer[1000];
        Integer [] merge10000 = new Integer[10000];



        
 
        for(int i = 0; i<100;i++){
            number = rand.nextInt(2147483647);
            quick100[i] = new Integer(number);
            merge100[i] = new Integer(number);
        }

        for(int i = 0; i<1000;i++){
            number = rand.nextInt(2147483647);
            quick1000[i] = new Integer(number);
            merge1000[i] = new Integer(number);
        }

        for(int i = 0; i<10000;i++){
            number = rand.nextInt(2147483647);
            quick10000[i] = new Integer(number);
            merge10000[i] = new Integer(number);
        }


        long startTime , endTime ; 



        System.nanoTime();


        

        
        
        String[] arr = {"ab","bc","ad","bb"};

        QuickSort(arr);

        System.out.println(Arrays.toString(arr));
        
    }


    public static <T extends Comparable<T>> void QuickSort(T[] arr){
        QuickSort(arr,0,arr.length-1);
    }

    private static <T extends Comparable<T>> void QuickSort(T[] arr,int first,int last){

        int par;

        if(last>first){
            par = Partition(arr,first,last);
            QuickSort(arr,first,par-1);
            QuickSort(arr,par+1,last);
        }
            

    }

    private static <T extends Comparable<T>> int Partition(T[] arr,int first,int last){
        
        T temp;
        T pivot = arr[last];
        int par = first -1;

        for(int j = first ; j<=last-1; j++){
            
            //if item is smaller than pivot
            if(arr[j].compareTo(pivot)<0){

                par++;

                //swap items
                temp = arr[par];
                arr[par] = arr[j];
                arr[j] = temp;
                
            }


        }

        /** put pilot where it belongs */
        par++;
        temp = arr[par];
        arr[par] = arr[last];
        arr[par] = temp;

        return par;

    }

    public static <T extends Comparable<T>> void MergeSort(T[]arr){
        
        if(arr.length>1){
            int halfSize = arr.length/2;
            T[] left = (T[]) new Comparable[halfSize];
            T[] right =(T[]) new Comparable[arr.length-halfSize];

            
            
            for(int i = 0;i<halfSize;i++){
                left[i] = arr[i];
            }

            for(int i = halfSize;i<arr.length;i++){
                right[i-halfSize] = arr[i];
            }

            MergeSort(left);
            MergeSort(right);

            Merge(left,right,arr);
        }
    }

    private static <T extends Comparable<T>> void Merge(T[] left, T[] right,T[] out){
        
        int indexLeft = 0; 
        int indexRight = 0;
        int indexOut = 0;

        while(indexLeft < left.length && indexRight < right.length){
            
            /* Find smaller than put it in output  */
            if(left[indexLeft].compareTo(right[indexRight]) < 0){
                out[indexOut] = left[indexLeft];
                indexOut++;
                indexLeft++;
            }

            else{
                out[indexOut] = right[indexRight];
                indexOut++;
                indexRight++;
            }

        }

        while(indexLeft<left.length){
            
            out[indexOut] = left[indexLeft];
            indexOut++;
            indexLeft++;

        }

        while(indexRight<right.length){
            
            out[indexOut] = right[indexRight];
            indexOut++;
            indexRight++;

        }

    }


}