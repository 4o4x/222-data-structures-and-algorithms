import java.io.*;
import java.util.ArrayList;

class main{
    public static void main(String[] argv){
        int[] array = new int[6];

        array[0] = 5;
        array[1] = 12;
        array[2] = 5;
        array[3] = 10;
        array[4] = 7;
        array[5] = 10;

        ArrayList<ArrayList<int>> list= new ArrayList<ArrayList<int>>();

        list = findSubArrays(array,17);

        for(int i =0;i<list.size();i++){
            for(int j = 0; j<list.get(i).size();j++){
                System.out.print(list.get(i).get(j));
            }
            
            System.out.println();
        }
        

        //System.out.println("x: "+ numOfItemArrBetween(array,1,5));

    }

   

    public static boolean sumCheck(int[] array,ArrayList<int> sub,int target,int index,int sum){
        
        if(index == array.length()){
            return false;
        }

        else{
            
            sum +=array[index];
            sub.add(array[index]);           
            if(sum == target) return true;

            else if(sum > target) return false;

            else return sumCheck(array,target,index+1,sum);
        }
    }

    public static ArrayList<ArrayList<int> > findSubArrays(int[] array,ArrayList<ArrayList<int> > subs,int target,int n){
        if(n == array.length()){
            return subs;
        }

        else{

            ArrayList <int> tempSub = new ArrayList <int>();
            boolean result = sumCheck(array,tempSub,target,n,0);
            if(result){ 
                subs.add(tempSub);
            }

            return findSubArrays(array,subs,target,n+1);

        }
    }

    public static ArrayList<ArrayList<int> > findSubArrays(int[] array,int target){
        
        ArrayList<ArrayList<int> > subs = new ArrayList<ArrayList<int>>();

        return findSubArrays(array,subs,target,0);
    }
}