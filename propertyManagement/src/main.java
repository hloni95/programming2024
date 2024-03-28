/*
    An agent manages houses in two suburbs in Kimbeley.
    The houses are in 3 particular streets
    Each street comprises only two houses managed by this agent
    
    The following particulars of each house are recorded:
        houseNum (concated string of the firstletter of the suburb, the street
        number and house number counting from 1 in each case)
        BkValue (250 000 raised to the power -product of 5 and the street num
        multiplied by the houseNum
        A field to indicate whether a house is leased or not.
    
        a. create an appropriate data structure to store these house details 
        b. display the house details in ascending order of BkValue (use shell sort)
        c. Add a foreign key to each house details which cpatures the Tenant ID
    
    Tenants approach the agent and are added to a waiting list.
    The following details of the first 10 candidates are kept:
        idNum
        sal per month
        rating (nth Fibinacci number's factorial, where n is the remainder 
        of dividing)
        
        a. create an appropriate data structure to store candidate tenats that 
           are in the wait list
        b. if a house is vacant, who are the candidates who qualify? list them
           in decending order of priority
    
 */

/**
 * @author anonza
 * Date : 27 March 2024
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // house_details.captureData();
        tenants.populateTenants();
        tenants.sortData();
    }
    
}
