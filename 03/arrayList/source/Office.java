package sburak.city;

public class Office extends Bulding{

    /**
    * Office
    *
    * @author Suleyman Burak YASAR
    * @version 1.0.0
    * @since  2022-03-06
    */

    private String jobType;

    /**
    * Constructs a office
    */

    public Office(){
        super();
        jobType = "jobType";
        
    }

    /**
    * Constructs a offive with the specified lenght and height
    * @param l lenght of construction
    * @param h height of construction
    */

    public Office(int l,int h){
        super(l,h);
        jobType = "jobType";
    }

    /**
    * Returns job-type of office
    * @return job-type of office
    */

    public String getJobType(){
        return jobType;
    }

    /**
    * sets job-type of office
    * @param jb job-type of office
    */

    public void setJobType(String jb){
        jobType = jb;
    }

    /**
    * Returns information of Office
    * @return information of Office
    */

    public String toString(){
        return "Office" + "\nOwner:" + getOwner() + "\nJob-Type:" + getJobType() + "\nLenght:" + getLenght() + "\nHeight:" + getHeight(); 
    }

    /**
    * focusing Office
    */

    public void focus(){
        System.out.println(getJobType());
    }
}