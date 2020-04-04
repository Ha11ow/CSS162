import java.util.*;
import java.io.*;
/**
 * This is an abstract data type of list, very similar to an array but unlimited
 * 
 * @author (Ben Khabazan) 
 * FractionsV1 for CSS 143
 */
public class FractionsV1 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner importer = new Scanner(new File("fractions.txt")); //Scans in the text file
		String line = "";
		
		ArrayList fractionHolder = new ArrayList();
		//creating a loop to last as long as the file has a next line.
		while(importer.hasNextLine()) {
			//use the String line to grab the next line
			line = importer.nextLine();
			//split at the fraction mark and hold both sides of the fraction
			String[] splitter = line.split("/"); 
			//organizing the two separated values
			int numerator = Integer.parseInt(splitter[0]);
			int denominator = Integer.parseInt(splitter[1]);
			//insert the fraction accordingly into our fraction holder
			fractionHolder.add(numerator);
			fractionHolder.add(denominator);
		}
		//now that we have added all the fractions, we need to find the lowest format of each and find how many times they are repeated
		
		int counter = 1; //this shows how many times a fraction is shown (minimum of 1)
		double numerator = 0;
		double denominator = 0;
		/* 
		 * To find if the fraction repeat, we must go through the array list with a for loop
		 * and skip 2, one for numerator and another for denominator
		 */
		for (int i = 0; i < fractionHolder.size(); i += 2) {
			numerator = (int)fractionHolder.get(i) * 1.0;
			denominator = (int)fractionHolder.get(i+1) * 1.0;
			//Find the value to a fraction by dividing numerator and denominator
			double fraction1 = numerator/denominator;
			//loop through everything after our beginning numerator and denominator to find matching ones
			for (int j = i+2; j < fractionHolder.size(); j += 2) {
				numerator = (int)fractionHolder.get(j) * 1.0;
				denominator = (int)fractionHolder.get(j+1) * 1.0;
				//find the value again from the other fractions in the fractionHolder
				double fraction2 = numerator/denominator;
				//if the two fractions match, add to the counter, and remove the upcoming fractions
				if (fraction1 == fraction2) {
					counter++;
					fractionHolder.remove(j);
					fractionHolder.remove(j);
				}
			}
			//finally before we exit the loop, print out the fraction, and how many times it has been repeated
			System.out.println(fractionHolder.get(i) + "/" 
				+ fractionHolder.get(i+1) + " has a count of  " + counter);
			//reset the counter after printing it
			counter = 1;
		}		
	}
}
