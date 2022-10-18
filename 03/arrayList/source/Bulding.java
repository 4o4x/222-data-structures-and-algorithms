package sburak.city;

public abstract class Bulding extends Construction{
    
    /**
    * Bulding
    *
    * @author Suleyman Burak YASAR
    * @version 1.0.0
    * @since  2022-03-06
    */
    
    protected String owner;

    /**
    * Constructs a bulding 
    */

    public Bulding(){
        super();
        owner = "free";
    }

    /**
    * Constructs a bulding with the specified lenght and height
    * @param l lenght of construction
    * @param h height of construction
    */
    
    public Bulding(int l, int h){
        super(l,h);
        owner = "free";
    }

    /**
    * Returns owner of the house
    * @return owner of the house
    */
    
    public String getOwner(){
        return owner;
    }

    /**
    * sets owner of the house
    * @param ow owner of the house
    */

    public void setOwner(String ow){
        owner = ow;
    }


    /**
    * focusing a bulding
    */

    abstract public void focus();
    
}