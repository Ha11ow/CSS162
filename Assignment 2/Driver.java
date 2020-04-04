import java.io.*;
import java.util.*;
/**
 * the driver scans in the new text file input and will organize it accordingly
 * 
 * @author (Ben Khabazan) 
 */
public class Driver
{
    public static void main(String[] Args) throws FileNotFoundException{
    	//need to scan the file therefore using a scanner
        Scanner scan = new Scanner (new File("fractions.txt")); 
        ObjectList list = new ObjectList(); 
        String line = ""; 
        
        //up will see if the fraction exists in our array true means it exists
        boolean up; 
        
        //will loop through while another line exists
        while (scan.hasNext()){ 
        	
        	//checks the next line
            line = scan.next();
            
            //Splitting the numbers from the line and inserting them in to the fraction class
            String[] numbers = line.split("/");
            Fraction fraction =new Fraction((int)Double.parseDouble(numbers[0]),
                    (int) Double.parseDouble(numbers[1]));
            
            //must always assume that the fraction does not exist
            up = false;
            for (int i = 0; i < list.length(); i++){
                up=list.getFractionCounter(i).compareAndIncrement(fraction);
                
                if(up == true)
                	
                	//will break to show the value exists and it wont change
                    break;
            }
            
            //if the fraction doesnt exist then add to counter, and add to list
            if(up == false){ 
                FractionCounter lol = new FractionCounter(fraction);
                list.add(lol);
            }
        }
        System.out.print(list.toString());
    }
}
