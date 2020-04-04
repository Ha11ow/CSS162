/**
 * This class is an instance of a fraction that will inserted and have methods to reduce it
 * 
 * @author (Ben Khabazan) 
 */
public class Fraction
{
    private int numerator; //Instance of the numerator
    private int denominator; //instance of the denominator

    public Fraction() //this is a empty constructor in case of wanting to create a new instance of Fraction
    {
    }
	
	/**
	 * This overloaded constructor will initialize the numerator and denominator
	 * @param numerator	is the numerator for the fraction
	 * @param denominator is the denominator for the fraction
	 */
    public Fraction(int numerator, int denominator){
        setNumerator(numerator);
        setDenominator(denominator);
        reducer();
    }

    /**
     * reducer basically finds the greatest common denominator and reduces the fraction
     * small value is set to the lowest input for denominator or numerator
     */
    public void reducer(){
        int smallValue; 
        
        //Boundary check if denominator is 0
        if (getDenominator() == 0){
            throw new RuntimeException("denominator cannot be 0");
        }
        
        //checking to see if both are negative numbers to cancel out
        if (getNumerator() < 0 && getDenominator() < 0){
            setNumerator(getNumerator() * -1);
            setDenominator(getDenominator() * -1);
        }
        
        //to set smallValue, need to find to see which is smaller
        if (getNumerator() <= getDenominator()){
            smallValue = getNumerator();
        }
        else {
            smallValue = getDenominator();
        }
        
        //in here I will use the small value and go down until the lowest common denominator whish is 2
        for (int i = smallValue; i >= 2; i--){
        	
        	//here will see if i can completely reduce the fraction down and if accepted replace the two
            if (getNumerator() % i == 0 && getDenominator() % i == 0){
                setNumerator(getNumerator() / i);
                setDenominator(getDenominator() / i);
            }
        }
    }
    
    /**
     * @param numerator inserted numerator will replace the class level numerator
     */
    public void setNumerator(int numerator){
        this.numerator = numerator;
    }

    /**
     * @param denominator inserted denominator will replace the class level denominator
     */
    public void setDenominator(int denominator){
        if (denominator != 0){
            this.denominator = denominator;
        }
        else {
            System.out.println("0 cannot be set to denominator");
        }
    }

    /**
     * will return the value for numerator
     * @return numerator
     */
    public int getNumerator(){
        return this.numerator;
    }

    /**
     * will return the value for denominator
     * @return denominator
     */
    public int getDenominator(){
        return this.denominator;
    }
    
    /**
     * overriding the equals method to equal another fraction
     * @param other another fraction inserted
     */
    public boolean equals(Fraction other){
        if (this.getNumerator() == other.getNumerator() 
        && this.getDenominator() == other.getDenominator()){
            return true;
        }
        return false;
    }

    /**
     * overriding the toString to write a fraction 
     */
    public String toString(){
        return getNumerator() + "/" + getDenominator();
    }
}