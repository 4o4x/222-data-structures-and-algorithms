import java.io.*;
import java.util.*;

class main{
    public static void main(String[] argv){
        int[] array1 = {-1,1,3,5,7,9,11};

        int firstNumber = 1;
        int secondNumber = 5;
        
        System.out.println("Array: " + Arrays.toString(array1) + " --- First Number: " + firstNumber + " --- Second Number:" + secondNumber);
        System.out.println("Result: "+ numOfItemArrBetween(array1,firstNumber,secondNumber) + "\n");

        firstNumber = -2;
        secondNumber = 2;
        
        System.out.println("Array: " + Arrays.toString(array1) + " --- First Number: " + firstNumber + " --- Second Number:" + secondNumber);
        System.out.println("Result: "+ numOfItemArrBetween(array1,firstNumber,secondNumber) + "\n");

        firstNumber = -55;
        secondNumber = 125;
        
        System.out.println("Array: " + Arrays.toString(array1) + " --- First Number: " + firstNumber + " --- Second Number:" + secondNumber);
        System.out.println("Result: "+ numOfItemArrBetween(array1,firstNumber,secondNumber) + "\n");

        int[] arr2 = {0,1};  

        firstNumber = 3;
        secondNumber = 10;
        
        System.out.println("Array: " + Arrays.toString(arr2) + " --- First Number: " + firstNumber + " --- Second Number:" + secondNumber);
        System.out.println("Result: "+ numOfItemArrBetween(arr2,firstNumber,secondNumber) + "\n");

        int[] arr3 = {1};  

        firstNumber = 5;
        secondNumber = 25;
        
        System.out.println("Array: " + Arrays.toString(arr3) + " --- First Number: " + firstNumber + " --- Second Number:" + secondNumber);
        System.out.println("Result: "+ numOfItemArrBetween(arr3,firstNumber,secondNumber) + "\n");

        firstNumber = -55;
        secondNumber = -1;
        
        System.out.println("Array: " + Arrays.toString(arr3) + " --- First Number: " + firstNumber + " --- Second Number:" + secondNumber);
        System.out.println("Result: "+ numOfItemArrBetween(arr3,firstNumber,secondNumber) + "\n");
    }

    /** Recursive binary search for q2
        @param array The array being searched
        @param target The integer number being searched for
        @param first The subscript of the first element
        @param last The subscript of the last element
        @param isFirst to check if the number searched is the first number
        @return if it finds the target, it returns the half position right or left of the target depending on whether it is the first number or not.
        other wise returns the middle of the 2 numbers closest to the target
    */

    private static double binarySearch(int[] array,int target,int first,int last,boolean isFirst){
        
        if(last <= first){       

            int middle = (first+last)/2;

            if(array[middle] == target){
                if(isFirst){
                    return middle-0.50;
                }

                else return middle+0.50;
            }
            if(array[middle]>=target)
                return middle - 0.50;
            else return middle + 0.50;
        }

        else{
            int middle = (first+last)/2;
            
            if(array[middle] == target){
                if(isFirst){
                    return middle-0.50;
                }

                else return middle+0.50;
            }
                     
            else if(array[middle]<target)
                return binarySearch(array,target,middle+1,last,isFirst);
            else
                return binarySearch(array,target,first,middle-1,isFirst);
        }
            
    }

    /** a recursive algorithm to find the number of items in the array between two given integer values.
        @param array The array being searched
        @param firstNumber The first integer number 
        @param secondNumber The second integer number 
        @return return number of items in the array between two given integer values.
    */

    public static int numOfItemArrBetween(int[] array,int firstNumber,int secondNumber){
        return (int)(binarySearch(array,secondNumber,0,array.length-1,false) - binarySearch(array,firstNumber,0,array.length-1,true));
    }
}