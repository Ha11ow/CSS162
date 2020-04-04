/**
 * FractionCounter is a counter to see how many times a fraction is repeated
 * 
 * @author (Ben KHabazan) 
 */
public class FractionCounter
{
    private int counter = 1; //instance of counter
    private Fraction fraction; //instance of the fraction

    /**
     * The constructor will set a new fraction for the class variable
     * @param newFraction a new fraction that is inserted
     */
    public FractionCounter(Fraction newFraction){ 
        this.fraction = newFraction;
    }

    /**
     * Will take in the other fraction and compare it with the prvious to see if they are equal
     * if they are equal the counter will increment
     * @param other another fraction inserted
     */
    public boolean compareAndIncrement(Fraction other){
        if(fraction.equals(other) == true){
            counter++; //counter increases if fraction exists
            return true; //returns true because it exists
        }
        return false;
    }

    /**
     * Overriding the to string to show how many times it has been repeated
     */
    public String toString(){
        return fraction + "has a count of " + counter;
    }
}
