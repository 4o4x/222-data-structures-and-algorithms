import java.io.*;

class main{
    
    public static void main(String[] argv){
        
        System.out.println("String: \"araba\"  Big String \"marabamarabamaraba\" Index: 2");

        int x = searchSub("araba","marabamarabamaraba",2);
        System.out.println("Result: " + x + "\n");
        
        System.out.println("String: \"araba\"  Big String \"gaeg\" Index: 1");

        x = searchSub("araba","gaeg",1);
        System.out.println("Result: " + x + "\n");

        System.out.println("String: \"araba\"  Big String \"araba\" Index: 2");

        x = searchSub("araba","araba",2);
        System.out.println("Result: " + x + "\n");

        System.out.println("String: \"araba\"  Big String \"arabamarabakaraba\" Index: 3");

        x = searchSub("araba","arabamarabakaraba",3);
        System.out.println("Result: " + x + "\n");

        System.out.println("String: \"araba\"  Big String \"arabamarabakaraba\" Index: 1");

        x = searchSub("araba","arabamarabakaraba",1);
        System.out.println("Result: " + x + "\n");

        System.out.println("String: \"araba\"  Big String \"arabamarabakaraba\" Index: 1");

        x = searchSub("araba"," ",1);
        System.out.println("Result: " + x + "\n");
    }

    /** Recursive Search a given string in another given bigger string. The
        function should return the index of the ith occurrence of the query string 
        @param small given string to search
        @param big given string to search in
        @param index ith occurrence of the query string
        @param n position
        @return return the index of the ith occurrence of the query string and return -1
                when the query string doesn’t occur in the big string or the number of occurences is less
                than i.
    */

    private static int searchSub(String small,String big,int index,int n){
        
        if(big.length()<small.length()){        
            return -1;
        }

        else if( small.equals( big.substring(0,small.length()) ) && index-- == 1){
            return n;
        }

        else
            return searchSub(small,big.substring(1),index,n+1);
    }

    /** Wrapper recursive Search a given string in another given bigger string. The
        function should return the index of the ith occurrence of the query string 
        @param small given string to search
        @param big given string to search in
        @param index ith occurrence of the query string
        @return return the index of the ith occurrence of the query string and return -1
                when the query string doesn’t occur in the big string or the number of occurences is less
                than i.
    */

    public static int searchSub(String small,String big,int index){
        return searchSub(small,big,index,0);
    }
}