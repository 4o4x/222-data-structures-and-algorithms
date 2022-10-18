package sburak.city;

public class Playground extends Construction{
    
    /**
    * Playground
    *
    * @author Suleyman Burak YASAR
    * @version 1.0.0
    * @since  2022-03-06
    */

    /**
    * Constructs a playground
    */

    public Playground(){
        super();
    }

    /**
    * Constructs a house with the specified lenght
    * @param l lenght of construction
    */

    public Playground(int l){
        super(l,1);
    }
    
    /**
    * Returns information of the playground
    * @return information of the playground
    */

    public String toString(){
        return "Playground" + "\nLenght:" + getLenght();
    }

    /**
    * focusing playground
    */

    public void focus(){
        System.out.println(getLenght());
    }
}