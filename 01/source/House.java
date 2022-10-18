package sburak.city;

public class House extends Bulding{
    
    /**
    * House
    *
    * @author Suleyman Burak YASAR
    * @version 1.0.0
    * @since  2022-03-06
    */
    
    
    private int room;
    private String color;


    /**
    * Constructs a house 
    */

    public House(){
        super();
        room = 0;
        color = "Colorless";
    }

    /**
    * Constructs a house with the specified lenght and height
    * @param l lenght of construction
    * @param h height of construction
    */

    public House(int l,int h){
        super(l,h);
        room = 0;
        color = "Colorless";
    }

    /**
    * Returns number of rooms in the house
    * @return number of rooms in the house
    */

    public int getRoom(){
        return room;
    }

    /**
    * Returns color of the house
    * @return color of the house
    */

    public String getColor(){
        return color;
    }

    /**
    * sets number of rooms in the house
    * @param rm number of rooms in the house
    * @throws RuntimeException if Number of room is not positive
    */

    public void setRoom(int rm){
        if(rm <=0) throw new RuntimeException("Number of rooms has to be positive"); //Exception
        
        else
            room = rm;
    }

    /**
    * sets color of the house
    * @param clr color of the house
    */

    public void setColor(String clr){
        color = clr;
    }

    /**
    * Returns information of the house
    * @return information of the house
    */

    public String toString(){
        return "House" + "\nOwner:" + getOwner() + "\nColor:" + getColor() + "\nNumber of room:" + getRoom() + "\nLenght:" + getLenght() + "\nHeight:" + getHeight(); 
    }

    /**
    * focusing house
    */

    public void focus(){
        System.out.println(getOwner());
    }
}