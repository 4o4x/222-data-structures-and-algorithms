import java.io.*;
import java.util.*;

class main{
    public static void main(String[] argv){
        
        ArrayList<int[]> list= new ArrayList<int[]>();


        int[] arr1 = {5,12,5,5,10,7,10};
        
        System.out.println("\nArray 1:  " + Arrays.toString(arr1) + " -- Target Sum = 17" + "\n\nSub Arrays");
        
        list = findSubArrays(arr1,17);

        for(int i =0;i<list.size();i++){
            System.out.println(Arrays.toString( list.get(i) ) );
        }

        int[] arr2 = {0,1};
        
        System.out.println("\nArray 2:  " + Arrays.toString(arr2) + " -- Target Sum = 1" + "\n\nSub Arrays");
        
        list = findSubArrays(arr2,1);

        for(int i =0;i<list.size();i++){
            System.out.println(Arrays.toString( list.get(i) ) );
        }

        int[] arr3 = {8,7,9};
        
        System.out.println("\nArray 3:  " + Arrays.toString(arr3) + " -- Target Sum = 100" + "\n\nSub Arrays");
        
        list = findSubArrays(arr3,100);

        for(int i =0;i<list.size();i++){
            System.out.println(Arrays.toString( list.get(i) ) );
        }

        int[] arr4 = {5};
        
        System.out.println("\nArray 4:  " + Arrays.toString(arr4) + " -- Target Sum = 5" + "\n\nSub Arrays");
        
        list = findSubArrays(arr4,5);

        for(int i =0;i<list.size();i++){
            System.out.println(Arrays.toString( list.get(i) ) );
        }

        int[] arr5 = {25,25,25,25,25};
        
        System.out.println("\nArray 5:  " + Arrays.toString(arr5) + " -- Target Sum = 25" + "\n\nSub Arrays");
        
        list = findSubArrays(arr5,25);

        for(int i =0;i<list.size();i++){
            System.out.println(Arrays.toString( list.get(i) ) );
        }
        
        
                
        //System.out.println("x: "+ numOfItemArrBetween(array,1,5));

    }

   /** finds sub array in unsorted integer array with start index
        @param array The unsorted integer array being searched
        @param sub sub array
        @param target given integer value is equal to subarray that the sum of its items
        @param index start index
        @param sum sum of subarray items
        @return if it finds subarray that the sum of is equal to the target returns it,
        other wise returns null
    */

    public static int[] sumCheck(int[] array,int[] sub,int target,int index,int sum){
        
        if(index == array.length){
            return null;
        }

        else{
            
            sum +=array[index];
            
            int[] temp = Arrays.copyOf(sub,sub.length+1);
            
            temp[sub.length] = array[index];

            

            if(sum == target) return temp;

            else if(sum > target) return null;

            else return sumCheck(array,temp,target,index+1,sum);
        }
    }

    /** finds sub array and adds ArrayList of subarray
        @param array The unsorted integer array being searched
        @param subs ArrayList of subarrays
        @param target given integer value is equal to subarray that the sum of its items
        @param n start element to search
        @return returns ArrayList of subarray
    */

    public static ArrayList<int[]> findSubArrays(int[] array,ArrayList<int[]> subs,int target,int n){
        
        if(n == array.length){
            return subs;
        }

        else{

            int[] tempSub = new int[0];
            tempSub = sumCheck(array,tempSub,target,n,0);
            
            if(tempSub !=null){ 
                subs.add(tempSub);
            }

            return findSubArrays(array,subs,target,n+1);

        }
    }

    /** takes unsorted integer and finds contiguous subarray/s that the sum of its/theirs items is equal to a given integer value
        @param array The unsorted integer array being searched
        @param target given integer value is equal to subarray that the sum of its items
        @return returns ArrayList of subarray
    */

    public static ArrayList<int[]> findSubArrays(int[] array,int target){
        
        ArrayList<int[]> subs= new ArrayList<int[]>();

        return findSubArrays(array,subs,target,0);
    }
}