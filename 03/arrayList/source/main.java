import java.util.Scanner;
//import java.io.*;
import sburak.city.Construction;
import sburak.city.Bulding;
import sburak.city.House;
import sburak.city.Office;
import sburak.city.Market;
import sburak.city.Playground;
import sburak.city.Street;


class main{
    public static void main(String[] argv){
        
        System.out.println("---------House Class Test------------");

        System.out.println("---------Decleration and toString Test------------");
        
        House testHouse = new House(5,10); //Decleration
        System.out.println(testHouse);

        System.out.println("---------setters and getters Test------------");

        testHouse.setOwner("Burak Yasar");
        System.out.println("Owner:" + testHouse.getOwner()); 

        testHouse.setColor("White");
        System.out.println("Color:" + testHouse.getColor());

        testHouse.setRoom(10);
        System.out.println("Number of room:" + testHouse.getRoom());

        System.out.println("Lenght:" + testHouse.getLenght());
        System.out.println("Height:" + testHouse.getHeight());

        System.out.println("---------Exception test------------");

        try{
            House excHouse = new House(-5,4);
        }

        catch(Exception e){
            System.out.println(e);
        }

        try{
            House excHouse = new House(5,-9);
        }

        catch(Exception e){
            System.out.println(e);
        }

        try{
            House excHouse = new House(5,8);
            excHouse.setRoom(-10);
        }

        catch(Exception e){
            System.out.println(e);
        }


        System.out.println("\n\n---------Office Class Test------------");

        System.out.println("---------Decleration and toString Test------------");
        
        Office testOffice = new Office(3,5); //Decleration
        System.out.println(testOffice);

        System.out.println("---------setters and getters Test------------");

        testOffice.setOwner("S.Burak");
        System.out.println("Owner:" + testOffice.getOwner()); 

        testOffice.setJobType("Factory");
        System.out.println("Job-Type:" + testOffice.getJobType());


        System.out.println("Lenght:" + testOffice.getLenght());
        System.out.println("Height:" + testOffice.getHeight());

        System.out.println("---------Exception test------------");

        try{
            Office excOffice = new Office(-5,4);
        }

        catch(Exception e){
            System.out.println(e);
        }

        try{
            Office excOffice = new Office(10,0);
        }

        catch(Exception e){
            System.out.println(e);
        }


        System.out.println("\n\n---------Market Class Test------------");

        System.out.println("---------Decleration and toString Test------------");
        
        Market testMarket = new Market(10,8); //Decleration
        System.out.println(testMarket);

        System.out.println("---------setters and getters Test------------");

        testMarket.setOwner("Suleyman Burak");
        System.out.println("Owner:" + testMarket.getOwner()); 

        testMarket.setHourOpen(13);
        testMarket.setMinuteOpen(50);
        System.out.println("Opening Time:" + testMarket.getHourOpen() + "." + testMarket.getMinuteOpen());

        testMarket.setHourClose(22);
        testMarket.setMinuteClose(30);
        System.out.println("Closing Time:" + testMarket.getHourClose() + "." + testMarket.getMinuteClose());

        System.out.println("Lenght:" + testMarket.getLenght());
        System.out.println("Height:" + testMarket.getHeight());

        System.out.println("---------Exception test------------");

        try{
            Market excMarket = new Market(-5,4);
        }

        catch(Exception e){
            System.out.println(e);
        }

        try{
            Market excMarket = new Market(1,-30);
        }

        catch(Exception e){
            System.out.println(e);
        }
        
        try{
            Market excMarket = new Market(5,5);
            excMarket.setHourOpen(35);
        }

        catch(Exception e){
            System.out.println(e);
        }

        try{
            Market excMarket = new Market(5,5);
            excMarket.setMinuteOpen(67);
        }

        catch(Exception e){
            System.out.println(e);
        }

        try{
            Market excMarket = new Market(5,5);
            excMarket.setHourClose(24);
        }

        catch(Exception e){
            System.out.println(e);
        }

        try{
            Market excMarket = new Market(5,5);
            excMarket.setMinuteClose(-5);
        }

        catch(Exception e){
            System.out.println(e);
        }


        System.out.println("\n\n---------Playground Class Test------------");

        System.out.println("---------Decleration and toString Test------------");
        
        Playground testPlayground = new Playground(5); //Decleration
        System.out.println(testPlayground);

        System.out.println("---------getter Test------------");
 
        System.out.println("Lenght:" + testPlayground.getLenght());

        System.out.println("---------Exception test------------");

        try{
            Playground excPlayground = new Playground(-8);
        }

        catch(Exception e){
            System.out.println(e);
        }


        System.out.println("\n\n\n---------Street Class Test------------");
        System.out.println("---------Decleration and display test------------");
        
        Street testStreet = new Street(50);
        testStreet.view();

        System.out.println("\n\n---------Decleration Exception test------------");

        try{
            Street excStreet = new Street(-8);
        }

        catch(Exception e){
            System.out.println(e);
        }

        System.out.println("\n\n---------Add Test------------");
        
        System.out.println("\nAdding House");
        testStreet.add(testHouse,0,0);
        testStreet.view();
        System.out.println("\n\n-----------------------------------------");
        
        System.out.println("\nAdding Office");
        testStreet.add(testOffice,0,11);
        testStreet.view();
        System.out.println("\n\n-----------------------------------------");
        
        System.out.println("\nAdding Market");
        testStreet.add(testMarket,1,3);
        testStreet.view();
        System.out.println("\n\n-----------------------------------------");
        
        System.out.println("\nAdding Playground");
        testStreet.add(testPlayground,1,30);
        testStreet.view();
        System.out.println("\n\n-----------------------------------------");
        

        System.out.println("\n\n---------Add Exception Test------------");

        try{
            testStreet.add(testPlayground,0,0);
        }

        catch(Exception e){
            System.out.println(e);
        }

        try{
            testStreet.add(testPlayground,3,30);
        }

        catch(Exception e){
            System.out.println(e);
        }

        try{
            testStreet.add(testPlayground,0,560);
        }

        catch(Exception e){
            System.out.println(e);
        }

        
        
        System.out.println("\n\n---------Delete Test------------");
        
        System.out.println("\nDeleting House");
        testStreet.delete(0,0);
        testStreet.view();

        System.out.println("\nDeleting Playground");
        testStreet.delete(1,32);
        testStreet.view();
        
        System.out.println("\n\n---------Delete Exception Test------------");

        try{
            testStreet.delete(5,0);
        }

        catch(Exception e){
            System.out.println(e);
        }

        try{
            testStreet.delete(0,-50);
        }

        catch(Exception e){
            System.out.println(e);
        }

        try{
            testStreet.delete(0,0);
        }

        catch(Exception e){
            System.out.println(e);
        }

        System.out.println("\nAdding House");
        testStreet.add(testHouse,0,0);
        System.out.println("\nAdding Playground");
        testStreet.add(testPlayground,1,30);

        System.out.println("\n\n---------Size Test------------");
        System.out.println("Size:"+testStreet.size());

        System.out.println("\n\n---------LenghtOfFreeLand test------------");

        System.out.println("Side0:"+testStreet.lenghtOfFreeLand(0));
        System.out.println("Side1:"+testStreet.lenghtOfFreeLand(1));

        System.out.println("\n\n---------LenghtOfFreeLand Exception test------------");

        try{
            testStreet.lenghtOfFreeLand(5);
        }

        catch(Exception e){
            System.out.println(e);
        }

        
        System.out.println("\n\n---------Total Remaining Length Of Lands test------------");
        System.out.println("Total:"+testStreet.totalRemainingLengthOfLands());

        System.out.println("\n\n---------Ratio Of Playground test------------");
        System.out.println("Ratio:"+testStreet.ratioOfPlayground());

        System.out.println("\n\n---------Occupied By Buldings test------------");
        System.out.println("Result:"+testStreet.occupiedByBuldings());

        System.out.println("\n\n---------Total Lenght Of Playground test------------");
        System.out.println("Result:"+testStreet.totalLenghtOfPlayground());

        System.out.println("\n\n---------Total Number Of Playground test------------");
        System.out.println("Result:"+testStreet.totalNumberOfPlayground());

        System.out.println("\n\n\n\n\n");
        
        Scanner input = new Scanner(System.in);
        
        while(true){
            
            int lenStr;

            while(true){
                System.out.printf("\nEnter lenght of street(-1 for exit):");
                lenStr = input.nextInt();
                if(lenStr==-1) return;
                
                try{
                    Street tempStreet = new Street(lenStr);
                    break;
                }

                catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }

            Street menuStreet = new Street(100);
            while(true){

                System.out.printf("\n1.Editing Mode\n2.Viewing Mode\n0.Exit\nChoose:");
                
                int menu = input.nextInt();

                if(menu<0 || menu>2){
                    System.out.println("Invalid Selection");
                    continue;
                }

                else if(menu ==0) return;
                
                else if(menu == 1){

                    
                    
                    while(true){
                        
                        System.out.printf("\n1.Add\n2.Delete\n0.Exit\nChoose:");
                        int editMenu = input.nextInt();
                        if(editMenu<0 || editMenu>2){
                            System.out.println("Invalid Selection");
                            continue;
                        }

                        else if(editMenu == 0) break;

                        else if(editMenu == 1){
                            
                            while(true){
                        
                                System.out.printf("\n1.House\n2.Office\n3.Market\n4.Playground\n0.Exit\nChoose:");
                                int addMenu = input.nextInt();
                                if(addMenu<0 || addMenu>4){
                                    System.out.println("Invalid Selection");
                                    continue;
                                }

                                if(addMenu == 0) break;
                                
                                System.out.printf("\nLenght:");
                                int tempLenght = input.nextInt();
                                
                                int tempHeight = 0;

                                if(addMenu!=4){
                                    System.out.printf("\nHeight:");
                                    tempHeight = input.nextInt();
                                }

                                System.out.printf("\nSide(0/1):");
                                int tempSide = input.nextInt();

                                System.out.printf("\nPosition:");
                                int tempPosition = input.nextInt();
                                
                                if(addMenu == 1){
                                    
                                    try{
                                        House tempHouse = new House(tempLenght,tempHeight);
                                        menuStreet.add(tempHouse,tempSide,tempPosition);
                                        System.out.printf("\n\n--House Added--\n\n");
                                        break;
                                    }

                                    catch(Exception e){
                                        System.out.println("Error: " + e.getMessage());
                                    }

                                }

                                if(addMenu == 2){
                                    
                                    try{
                                        Office tempOffice = new Office(tempLenght,tempHeight);
                                        menuStreet.add(tempOffice,tempSide,tempPosition);
                                        System.out.printf("\n\n--Office Added--\n\n");
                                        break;
                                    }

                                    catch(Exception e){
                                        System.out.println("Error: " + e.getMessage());
                                    }

                                }

                                if(addMenu == 3){
                                    
                                    try{
                                        Market tempMarket = new Market(tempLenght,tempHeight);
                                        menuStreet.add(tempMarket,tempSide,tempPosition);
                                        System.out.printf("\n\n--Market Added--\n\n");
                                        break;
                                    }

                                    catch(Exception e){
                                        System.out.println("Error: " + e.getMessage());
                                    }

                                }

                                if(addMenu == 4){
                                    
                                    try{
                                        Playground tempPlayground = new Playground(tempLenght);
                                        menuStreet.add(tempPlayground,tempSide,tempPosition);
                                        System.out.printf("\n\n--Playground Added--\n\n");
                                        break;
                                    }

                                    catch(Exception e){
                                        System.out.println("Error: " + e.getMessage());
                                    }

                                }

                            }   
                            

                        }

                        else{
                            
                            System.out.printf("\nSide(0/1):");
                            int tempSide = input.nextInt();

                            System.out.printf("\nPosition:");
                            int tempPosition = input.nextInt();

                            try{
                                menuStreet.delete(tempSide,tempPosition);
                                System.out.println("\n\n---Deleted---\n");
                            }

                            catch(Exception e){
                                System.out.println("Error: " + e.getMessage());
                            }

                        }

                    }



                }

                    else{

                        while(true){
                            
                            System.out.printf("\n1.Total remaining length of lands on the street\n2.List of buildings on the street.\n3.The number and ratio of length of playgrounds in the street.\n4.the total length of street occupied by the markets, houses or offices\n5.Display the skyline silhouette of the street\n0.Exit\nChoose:");
                        
                            int viewMenu = input.nextInt();

                            

                            if(viewMenu<0 || viewMenu>5){
                                System.out.println("Invalid Selection");
                                continue;
                            }

                            else if(viewMenu == 0) break;

                            else if(viewMenu == 1){
                                System.out.println("--------------------------\n"+"Total remaining length of lands on the street: " + menuStreet.totalRemainingLengthOfLands());
                            }

                            else if(viewMenu == 2){
                                System.out.println("--------------------------\n"+ "List of buildings on the street") ;
                                menuStreet.listOfStreet();
                            }

                            else if(viewMenu == 3){
                                System.out.println("--------------------------\n"+ " The number of playgrounds in the street: " + menuStreet.totalNumberOfPlayground()+"\nRatio of length of playgrounds in the street: "+menuStreet.ratioOfPlayground());
                            }

                            else if(viewMenu == 4){
                                System.out.println("--------------------------\n"+ "The total length of street occupied by the markets, houses or offices: " + menuStreet.occupiedByBuldings());
                            }

                            else{
                                menuStreet.view();
                            }

                        }

                    }
            }
        }      

    }
}