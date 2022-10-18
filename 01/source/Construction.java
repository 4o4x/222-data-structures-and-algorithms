package sburak.city;

public abstract class Construction{
    
    /**
    * Construction
    *
    * @author Suleyman Burak YASAR
    * @version 1.0.0
    * @since  2022-03-06
    */
    
    protected int lenght;
    protected int height;
    protected int startPosition;

    /**
    * Constructs a construction 
    */

    public Construction(){
        lenght = 0;
        height = 0;
        startPosition = -1;
    }

    /**
    * Constructs a construction with the specified lenght and height
    * @param l lenght of construction
    * @param h height of construction
    * @throws RuntimeException if lenght or height is not positive
    */

    public Construction(int l,int h){
        
        if(l <= 0 || h <= 0) throw new RuntimeException("Lenght and height has to be positive"); //Exception

        else{
            lenght = l;
            height = h;
            startPosition = -1;
        }

    }

    /**
    * Returns lenght of construction
    * @return lenght of construction
    */

    public int getLenght(){
        return lenght;
    }

    /**
    * Returns Height of construction
    * @return Height of construction
    */

    public int getHeight(){
        return height;
    }

    /**
    * Returns start position of construction
    * @return start position of construction
    */

    public int getStartPosition(){
        return startPosition;
    }

    public void setStartPosition(int index){
        startPosition = index;
    }

    /**
    * focusing a construciton
    */

    abstract public void focus();
    
}