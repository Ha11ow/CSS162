import java.util.*;
/**
 * This is a driver for the FindFile class
 * 
 * @author (Ben Khabazan)
 */
public class Driver
{
    public static void main(String[] Args){
    	FindFile newFile = null;

        /*
         * I only have 4 files with that name spread through the folders
         */
        try {
            newFile = new FindFile(4);
            newFile.directorySearch("FoundIt.txt", "C:\\Users\\Behnam\\Desktop\\FindMeFiles");

        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        System.out.println(newFile.getCount());
        System.out.println(Arrays.deepToString(newFile.getFiles()));

        
        System.out.println("++++++++++++++++++++++++++++++++");
        
        
        
        /*
         * should cap out at 3
         */
        try {
            newFile = new FindFile(3);
            newFile.directorySearch("FoundIt.txt", "C:\\Users\\Behnam\\Desktop\\FindMeFiles");
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        System.out.println(newFile.getCount());
        System.out.println(Arrays.deepToString(newFile.getFiles()));
        
        
        System.out.println("++++++++++++++++++++++++++++++++");
        
        
        
        /*
         * setting it over the limit
         */
        try {
            newFile = new FindFile(5);
            newFile.directorySearch("FoundIt.txt", "C:\\Users\\Behnam\\Desktop\\FindMeFiles");

        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        System.out.println(newFile.getCount());
        System.out.println(Arrays.deepToString(newFile.getFiles()));
      


        System.out.println("++++++++++++++++++++++++++++++++");
    
    
	    /*
	     * Shouldn't find anything
	     */
	    try {
	        newFile = new FindFile(4);
	        newFile.directorySearch("WrongFile.txt", "C:\\Users\\Behnam\\Desktop\\FindMeFiles");
	
	    }
	    catch (IllegalArgumentException e){
	        System.out.println(e.getMessage());
	    }
	    System.out.println(newFile.getCount());
	    System.out.println(Arrays.deepToString(newFile.getFiles()));
	    
	    
	    System.out.println("++++++++++++++++++++++++++++++++");
	    
	    
	    /*
	     * Wrong directory
	     */
	    try {
	        newFile = new FindFile(4);
	        newFile.directorySearch("foundIt.txt", "Q:\\");
	
	    }
	    catch (IllegalArgumentException e){
	        System.out.println(e.getMessage());
	    }
	    System.out.println(newFile.getCount());
	    System.out.println(Arrays.deepToString(newFile.getFiles()));
	    
	    System.out.println("++++++++++++++++++++++++++++++++");
	    
	    
	    /*
	     * Zero input for max files
	     */
	    try {
	        newFile = new FindFile(0);
	        newFile.directorySearch("foundIt.txt", "C:\\Users\\Behnam\\Desktop\\FindMeFiles");
	
	    }
	    catch (IllegalArgumentException e){
	        System.out.println(e.getMessage());
	    }
	    System.out.println(newFile.getCount());
	    System.out.println(Arrays.deepToString(newFile.getFiles()));
	    
    } 
}
