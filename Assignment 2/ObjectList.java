/**
 * This is a class that acts as a queue and will store fractions
 * 
 * @author (Ben Khabazan) 
 */
public class ObjectList
{
    private int numElements = 0;
    private Object[] fractionHolder = new Object[1];    
    
    
    /**
     * Will add one fraction to the list of fractions we have
     * @param nextFraction the next fraction to be added to the queue 
     */
    public void add(Object nextFraction) { 
    	
    	//checks to see if the number of elements is equal to length
        if (numElements == fractionHolder.length){ 
        	
        	//temporarily array that will store the items
            Object[] temp = this.fractionHolder;
            
            //create a new array with one up size
            this.fractionHolder = new Object[temp.length+1];
            
            //refill the array
            for (int i = 0; i < temp.length; i++) {
                fractionHolder[i] = temp[i];
            }
        }
        
        //add the fraction to the array and up the number of elements filled
        fractionHolder[numElements] = nextFraction; 
        numElements ++;

    }

    /**
     * Will return a fraction based on the entered index
     * @param index the index that will return the fraction
     * @return returning the element in the list as an object
     */
    public Object getFraction(int index){
        return fractionHolder[index];
    }

    /**
     * Will return the fractionCounter based on the entered index
     * @param index the index that will return the fractionCounter
     * @return will return the fractionCounter
     */
    public FractionCounter getFractionCounter(int index){
        return (FractionCounter) fractionHolder[index];
    }

    /**
     * will return the length of array
     * @return an integer for the length of array
     */
    public int length(){ //returns the number of elements already stored
        return this.numElements;
    }

    /**
     * will return the toString so that it shows a number and the fraction and how many times it is repeated
     */
    public String toString() {
        String returnString = "";
        for (int i = 0; i < this.numElements; i++){
            returnString += i+1 + ") " + fractionHolder[i] + "\n";
        }
        return returnString;
    }

}
