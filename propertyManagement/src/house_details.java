/*
 *An agent manages houses in two suburbs in Kimbeley.
    The houses are in 3 particular streets
    Each street comprises only two houses managed by this agent
    
    The following particulars of each house are recorded:
        houseNum (concated string of the firstletter of the suburb, the street
        number and house number counting from 1 in each case) **done**
        BkValue (250 000 raised to the power - the product of 5 and the streetNum
        multiplied by the houseNum **done**
        A field to indicate whether a house is leased or not.
        
    objectives:
        a. create an appropriate data structure to store these house details **getting there**
        b. display the house details in ascending order of BkValue (use shell sort)
        c. Add a foreign key to each house details which captures the Tenant ID
 */

/**
 * @author anonza
 * Date : 27 March 2024
 */
public class house_details {
    
    public house_details(){}
    
    public static class house{
        
        String houseNum;
        int bkValue;
        boolean isLeased;
        
        //primary key for tenant ID
        int tenantID;
        
    }
    
    public static house houses[][][] = new house[2][3][2];
    public static String suburbs[] = {"Hulana","Phutanang"};
    
    
    public static void captureData(){
        
        //loop for each suburb
        for (int suburb = 0; suburb < 2; suburb++) { 
            
            //loop for each street
            for (int street = 0; street < 3; street++) { 
                
                //loop for each house
                for (int house = 0; house < 2; house++) {
                    
                    // whats happening here??
                    houses[suburb][street][house] = new house();
                    
                    // assign the house number 
                    houses[suburb][street][house].houseNum =
                            suburbs[suburb].substring(0,1).concat(
                                    Integer.toOctalString(street +1)).concat(
                                            Integer.toOctalString(house +1));
                    
                    
                    //power function finally works!!! just dont use that 250 000 else go a nyewa boi
                    houses[suburb][street][house].bkValue = power(2,
                            product(street + 1,house + 1));
                   
                    
                    System.out.println(houses[suburb][street][house].houseNum);
                    System.out.println("BkValue is: R " + 
                            houses[suburb][street][house].bkValue); 
                }
                
            }
            
        }
    }
    
    
    /*                    This section calculates the Bkvalue                */
    
    //1. take the houses array indexes as a parameter values to calculate the product *done*
    public static int product(int streetNum,int houseNumber){
        
        return 5 * (streetNum * houseNumber);
    }
    
    //2. power function : recursive **I need help** //stackoverflow ke ya eng ????
    static int power (int base, int x){
        
        if (x == 0) return 1;
        else return base * power (base, x - 1);
  }
    
    /*3. calculate the bkValue :  BkValue (250 000 raised to the power - 
       the product of 5 and the streetNum multiplied by the houseNum*/
    public static int calculateBkValue(int streetNumber, int houseNumber){
        
        //Todo: pass array indexes **done: pray it works
        return power(250000,product(streetNumber,houseNumber));
    }
    
    /*                  End of section                                  */
    
    /*                    This section displays houses data               */
    public static void displayHousesData(){
        
    }
    
// end of class    
}