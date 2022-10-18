package sburak.city;

public class Market extends Bulding{

    /**
    * Market
    *
    * @author Suleyman Burak YASAR
    * @version 1.0.0
    * @since  2022-03-06
    */
    
    private int hourOpen;
    private int minuteOpen;
    
    private int hourClose;
    private int minuteClose;


    /**
    * Constructs a market 
    */
    
    public Market(){
        super();
        hourOpen = 0;
        minuteOpen = 0;
        hourClose = 0;
        minuteClose = 0;
    }

    /**
    * Constructs a market with the specified lenght and height
    * @param l lenght of construction
    * @param h height of construction
    */

    public Market(int l,int h){
        super(l,h);
        hourOpen = 0;
        minuteOpen = 0;
        hourClose = 0;
        minuteClose = 0;
    }

    /**
    * Returns hour of opening time of the market
    * @return hour of opening time of the market
    */

    public int getHourOpen(){
        return hourOpen;
    }

    /**
    * Returns minute of opening time of the market
    * @return minute of opening time of the market
    */

    public int getMinuteOpen(){
        return minuteOpen;
    }

    /**
    * Returns hour of close time of the market
    * @return hour of close time of the market
    */

    public int getHourClose(){
        return hourClose;
    }

    /**
    * Returns minute of close time of the market
    * @return minute of close time of the market
    */

    public int getMinuteClose(){
        return minuteClose;
    }

    /**
    * sets hour of opening time of the market
    * @param openHour hour of opening time
    * @throws RuntimeException if hour is not valid
    */
       
    public void setHourOpen(int openHour){
        
        if(openHour <0 || openHour >= 24 ) throw new RuntimeException("Invalid Hour"); //Exception
        
        else
            hourOpen = openHour;
    }

    /**
    * sets minute of opening time of the market
    * @param openMinute minute of opening time
    * @throws RuntimeException if minute is not valid
    */

    public void setMinuteOpen(int openMinute){
        
        if(openMinute <0 || openMinute >= 60 ) throw new RuntimeException("Invalid Munite"); //Exception
        
        else
            minuteOpen = openMinute;
    }

    /**
    * sets hour of closing time of the market
    * @param closeHour hour of closing time
    * @throws RuntimeException if hour is not valid
    */

    public void setHourClose(int closeHour){
        
        if(closeHour <0 || closeHour >= 24 ) throw new RuntimeException("Invalid Hour"); //Exception
        
        else
            hourClose = closeHour;
    }

    /**
    * sets minute of closing time of the market
    * @param closeMinute minute of closing time
    * @throws RuntimeException if minute is not valid
    */

    public void setMinuteClose(int closeMinute){
        
        if(closeMinute <0 || closeMinute >= 60 ) throw new RuntimeException("Invalid Munite"); //Exception
        
        else
            minuteClose = closeMinute;
    }

    /**
    * Returns information of the market
    * @return information of the market
    */

    public String toString(){
        return "Market" + "\nOwner:" + getOwner() + "\nOpening Time:" + getHourOpen() + "." + getMinuteOpen() + "\nClosing Time:" + getHourClose() + "." + getMinuteClose() +"\nLenght:" + getLenght() + "\nHeight:" + getHeight(); 
    }

    /**
    * focusing Market
    */

    public void focus(){
        System.out.println(hourClose + "." + minuteClose);
    }
}