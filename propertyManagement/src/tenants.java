
import java.util.Scanner;

/*
 *  
    Tenants approach the agent and are added to a waiting list.
    The following details of the first 10 candidates are kept:
        idNum
        sal per month
        rating (nth Fibinacci number's factorial, where n is the remainder 
        of dividing) ** what am I dividing with?

objectives: 
        a. create an appropriate data structure to store candidate tenats that 
           are in the wait list **done**
        b. if a house is vacant, who are the candidates who qualify? list them
           in decending order of priority
 */

/**
 * @author anonza
 * Date : 27 March 2024
 */
public class tenants {
    
    public static class tenant_data{
        
        int idNum,monthlySalary,rating;
        
    }

    public tenants() {
    }
    
    private static tenant_data mytenants [][] = new tenant_data[10][3];
    static Scanner input = new Scanner(System.in);
    
    // populate the tenants table 
    public static void populateTenants(){
        
        for (int row = 0; row < mytenants.length; row++) {
            
            System.out.print("Enter data for tenant number "+ (row+1)+":");
            
            //prompt for data input
            System.out.print("\nTenant id number: " );
            mytenants[row][0] = new tenant_data();
            mytenants[row][0].idNum = input.nextInt();
            System.out.print("Tenants monthly salary: " );
            mytenants[row][1] = new tenant_data();
            mytenants[row][1].monthlySalary = input.nextInt();
            System.out.print("Tenants rating: " );
            mytenants[row][2] = new tenant_data();
            mytenants[row][2].rating = input.nextInt(); //Todo: Edit but first figure out the division issue
            System.out.println("\n================================\n");
        }
        generateTable(); // display the recorded data in a table
        input.close();
    }
    
    // find the nth Fibonacci number (usage: pass into the factorial funtion as a parameter)
    private static int fibNumber(int n){
        
        if(n == 0) return 0;
        else if (n == 1 || n== 2) return 1;
        else return fibNumber(n - 1) + fibNumber(n - 2);
    }
    
    //calculate nth Fibonacci numbers factorial **done : need to figure out what is n
    private static int fibFactorial(int fibNumber){
        if (fibNumber <= 1) return 1;
        else return fibNumber * fibFactorial(fibNumber - 1);
    }
    
    // displays the tables data
    public static void generateTable() {
        System.out.println("| ID Number | Monthly Salary | Rating |");
        System.out.println("|-----------|----------------|--------|");

        for (int row = 0; row < mytenants.length; row++) {
            if (mytenants[row][0] != null && mytenants[row][1] != null && mytenants[row][2] != null) {
                System.out.printf("| %-10d| %-15d| %-7d|\n", mytenants[row][0].idNum, mytenants[row][1].monthlySalary, mytenants[row][2].rating);
            }
        }
    }
    
    // show candidates who qualify? question: what are the metrics for qualifying?
    //show data in decending order using the rating
    public static void sortData(){
        
        //algo used: insertion sort
        
       int n = mytenants.length;
        for (int i = 1; i < n; ++i) {
            tenant_data[] key = mytenants[i];
            int j = i - 1;

            while (j >= 0 && mytenants[j][2].rating < key[2].rating) {
                mytenants[j + 1] = mytenants[j];
                j = j - 1;
            }
            mytenants[j + 1] = key;
        }
        generateTable();
    }
}
