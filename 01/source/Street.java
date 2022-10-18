package sburak.city;

public class Street{
    /**
    * Street
    *
    * @author Suleyman Burak YASAR
    * @version 1.0.0
    * @since  2022-03-05
    */
    
    private Construction[][] stAr;
    private int lenght;
    private int maxHeight=20; // It will help when display the skyline silhouette of the street
    
    /**
    * Constructs two empty street side 
    */
    public Street(){
    }

    /**
    * Constructors two empty street side with the specified lenght
    * @param len the lenght of the street
    */
    public Street(int len){
        
        if(len<0) throw new RuntimeException("Street lenght has to be positive"); //Exception

        stAr = new Construction[2][len];
        lenght = len;
        
    }

    /**
    * Adds the specified building to the specified location on the selected street side.
    * @param obj bulding to be added
    * @param side street side which the specified building is to be added
    * @param position position at which the specified building is to be added
    * @throws RuntimeException if position out of street or if there is no space to add bulding at the specified position or if side is invalid
    */

    public void add(Construction obj,int side,int position){ 
        
        if(side !=1 && side !=0) throw new RuntimeException("Invalid Side (can be 0 or 1)");//Exception

        if(position <0 || position >= size()) throw new RuntimeException("Invalid Position(out of street)");//Exception
        
        /*Checks if there is enough space to add bulding*/
        for(int i = 0; i<obj.getLenght(); i++){
            if( stAr[side][position+i] != null) throw new RuntimeException("Invalid Position,There is no space to add a building");//Exception
        }

        
        
        obj.setStartPosition(position); // Set bulding start position

        //Adds bulding to street
        for(int i = 0; i<obj.getLenght(); i++){
            stAr[side][position+i] = obj;
        }

        
        //updates maxHeight if the building height is bigger than maxHeight
        if(obj.getHeight()>maxHeight) maxHeight = 10+obj.getHeight();
    }

    /**
    * Adds the specified building to the specified location on the selected street side.
    * @param side street side which the building is to be deleted
    * @param position the position of the bulding to be deleted
    * @throws RuntimeException if position out of street or if there is no bulding to delete at the specified position or if side is invalid
    */

    public void delete(int side,int position){
        
        if(side !=1 && side !=0) throw new RuntimeException("Invalid Side (can be 0 or 1)");//Exception
        
        if(position <0 || position >= size()) throw new RuntimeException("Invalid Position(out of street)");//Exception

        if(stAr[side][position] == null) throw new RuntimeException("Invalid Position,There is no bulding to delete it");//Exception

        
        int start = stAr[side][position].getStartPosition(); // starting position of the building to be deleted
        int bldLen = stAr[side][position].getLenght(); // lenght of the building to be deleted
        
        //deletes the bulding from the street
        for(int i = 0; i<bldLen; i++){
            stAr[side][start+i] = null;
        }

    }

    public void deneme(int side){
        for(int i = 0;i<size();i++){
            if(stAr[side][i] == null) System.out.printf("-");
            else System.out.printf("*");
        }
    }

    /**
    * Display the skyline silhouette of the street
    */
    
    public void view(){
        
        
        
        //prints "\n" maxHeight times for display and cursor movement
        for(int k=0;k<maxHeight;k++){ 
            System.out.printf("\n");  
        }
        
        System.out.printf("\033[%d;1H",maxHeight); // moves the cursor to the bottom left corner where drawing will begin
        
        int i = 0;
        
        while(i<size()){ // Draws buldings at Side0 
            
            if(stAr[1][i] == null){ // If there is no bulding at position moves cursor to foward
                System.out.printf("\033[1C");
                i++;
                continue;
            }
        
            //If there is
            
            for(int k = 0; k<stAr[1][i].getHeight();k++){ // Draws the left wall of the building by moving the cursor up
                System.out.printf("*\033[1D\033[1A");
            }

            for(int k = 0; k<stAr[1][i].getLenght();k++){ // Draws roof of the building
                System.out.printf("*");
            }
            
            for(int k = 0; k<stAr[1][i].getHeight();k++){ // Draws the right wall of the building by moving the cursor down 
                System.out.printf("\033[1D\033[1B*");
            }
            
            // At the end of this the cursor will be at the position where it will be ready for the next drawing
            
            i = i+stAr[1][i].getLenght();  
        }


        System.out.printf("\033[%d;1H",maxHeight);// moves the cursor to the bottom left corner where drawing will begin
        
        i=0;
        
        while(i<size()){ // Draws buldings at Side0 
            
            if(stAr[0][i] == null){
                System.out.printf("\033[1C"); // If there is no bulding at position moves cursor to foward
                i++;
                continue;
            }
            
            for(int k = 0; k<stAr[0][i].getHeight();k++){ // Draws the left wall of the building by moving the cursor up
                System.out.printf("*\033[1D\033[1A");
            }

            for(int k = 0; k<stAr[0][i].getLenght();k++){ // Draws roof of the building
                System.out.printf("*");
            }

            for(int k = 0; k<stAr[0][i].getHeight();k++){ // Draws the right wall of the building by moving the cursor down 
                System.out.printf("\033[1D\033[1B*");
            }

            // At the end of this the cursor will be at the position where it will be ready for the next drawing
            
            i = i+stAr[0][i].getLenght();
        }

        System.out.printf("\033[%d;1H",maxHeight); // moves the cursor to the bottom left corner where clearing will begin
        i=0;

        int cursor=0; // Holds column position of cursor
        
        while(i<size()){ // Clears inside of drawn buldings which is at side 0
            
            if(stAr[0][i] == null){ // If there is no bulding at position moves cursor to foward
                System.out.printf("\033[1C");
                cursor++;
                i++;
                continue;
            }
            
            // If there is
            System.out.printf("\033[1C"); //for skip buildings wall
            cursor++;

            for(int k = 0; k < stAr[0][i].getLenght()-1;k++){ 
                
                for(int j = 0; j < stAr[0][i].getHeight();j++){ // moves the cursor from bottom to top to clear where it has passed
                    System.out.printf(" \033[1D\033[1A");
                }
                
                System.out.printf("\033[%d;%dH",maxHeight,cursor+1); // moves the cursor to its new location from which it will start clearing
                cursor++;
            }
            System.out.printf("\033[1C"); // for skip buildings wall
            
            i = i+stAr[0][i].getLenght();
        }


        System.out.printf("\033[%d;1H",maxHeight); // moves the cursor to the bottom left corner where clearing will begin
        i=0;
        cursor=0;

        while(i<size()){ // Clears inside of drawn buldings which is at side 1

            
            
            if(stAr[1][i] == null){ // If there is no bulding at position moves cursor to foward
                System.out.printf("\033[1C"); 
                cursor++;
                i++;
                continue;
            }
            
            // If there is
            System.out.printf("\033[1C"); // for skip buildings wall
            cursor++;

            for(int k = 0; k < stAr[1][i].getLenght()-1;k++){ 
                
                for(int j = 0; j < stAr[1][i].getHeight();j++){ // moves the cursor from bottom to top to clear where it has passed
                    System.out.printf(" \033[1D\033[1A");
                }
                
                System.out.printf("\033[%d;%dH",maxHeight,cursor+1); // moves the cursor to its new location from which it will start clearing
                cursor++;
            }
            System.out.printf("\033[1C");// for skip buildings wall
            
            
            i = i+stAr[1][i].getLenght();
        }

        System.out.printf("\n\n");
    }

    /**
    * Returns the lenght of street
    * @return the lenght of street 
    */

    public int size(){
        return lenght;
    }

    /**
    * Returns the total remaining length of lands on the street side
    * @param side street side
    * @throws RuntimeException if side is invalid
    * @return the total remaining length of lands on the street side 
    */    

    public int lenghtOfFreeLand(int side){
        
        if(side !=1 && side !=0) throw new RuntimeException("Invalid Side (can be 0 or 1)"); //Exception

        int sum = 0;

        for(int i=0; i<size();i++){
            if(stAr[side][i] == null) sum++;
        }

        return sum;

    }

    /**
    * Returns the total remaining length of lands on the street
    * @return the total remaining length of lands on the street
    */    

    public int totalRemainingLengthOfLands(){
        
        return lenghtOfFreeLand(0) + lenghtOfFreeLand(1);
        
    }
    
    /**
    * Displays the list of buildings on the street.
    */

    public void listOfStreet(){
        
        int total,i;


        total = 0;
        i=0;

        while(i<size()){
        
            if(stAr[0][i] instanceof Playground){
                total ++;
                i = i+stAr[0][i].getLenght();
            }

            else i++;
        }
        
        i = 0;

        while(i<size()){
        
            if(stAr[1][i] instanceof Playground){
                total ++;
                i = i+stAr[1][i].getLenght();
            }

            else i++;
        }

        System.out.println("Number of Playground:"+ total);
        total = 0;
        i=0;

        while(i<size()){
        
            if(stAr[0][i] instanceof House){
                total ++;
                i = i+stAr[0][i].getLenght();
            }

            else i++;
        }
        
        i = 0;

        while(i<size()){
        
            if(stAr[1][i] instanceof House){
                total ++;
                i = i+stAr[1][i].getLenght();
            }

            else i++;
        }

        System.out.println("Number of House:"+ total);
        total = 0;
        i=0;

        while(i<size()){
        
            if(stAr[0][i] instanceof Office){
                total ++;
                i = i+stAr[0][i].getLenght();
            }

            else i++;
        }
        
        i = 0;

        while(i<size()){
        
            if(stAr[1][i] instanceof Office){
                total ++;
                i = i+stAr[1][i].getLenght();
            }

            else i++;
        }

        System.out.println("Number of Office:"+ total);
        total = 0;
        i=0;

        while(i<size()){
        
            if(stAr[0][i] instanceof Market){
                total ++;
                i = i+stAr[0][i].getLenght();
            }

            else i++;
        }
        
        i = 0;

        while(i<size()){
        
            if(stAr[1][i] instanceof Market){
                total ++;
                i = i+stAr[1][i].getLenght();
            }

            else i++;
        }

        System.out.println("Number of Market:"+ total);


        
    } 

    /**
    * Returns ratio of length of playgrounds in the street
    * @return ratio of length of playgrounds in the street
    */

    public double ratioOfPlayground(){
        return  ((double)totalLenghtOfPlayground() / (double)(2*size()))*100; // Calculates ratio
        
    }

    /**
    * Returns the total length of street occupied by the markets, houses or offices
    * @return the total length of street occupied by the markets, houses or offices
    */

    public int occupiedByBuldings(){
        return 2*size()-( totalRemainingLengthOfLands() + totalLenghtOfPlayground() );
    }

    /**
    * Returns the total length of Playgrounds
    * @return the total length of Playgrounds
    */

    public int totalLenghtOfPlayground(){
        int total=0;
        int i=0;

        while(i<size()){
        
            if(stAr[0][i] instanceof Playground){
                total += stAr[0][i].getLenght();
                i = i+stAr[0][i].getLenght();
            }

            else i++;
        }
        
        i = 0;

        while(i<size()){
        
            if(stAr[1][i] instanceof Playground){
                total += stAr[1][i].getLenght();
                i = i+stAr[1][i].getLenght();
            }

            else i++;
        }

        return total;
    }

    /**
    * Returns the total number of Playgrounds
    * @return the total number of Playgrounds
    */

    public int totalNumberOfPlayground(){
        int total=0;
        int i=0;

        while(i<size()){
        
            if(stAr[0][i] instanceof Playground){
                total++;
                i = i+stAr[0][i].getLenght();
            }

            else i++;
        }

        i = 0;

        while(i<size()){
        
            if(stAr[1][i] instanceof Playground){
                total++; 
                i = i+stAr[1][i].getLenght();
            }

            else i++;
        }

        return total;
    }

    


}

    



