/**
 * This is an instance of money that will be used in real life
 * the money gets used just as dollars would in US
 * there will be cents and dollars
 * 
 * @author (Ben Khabazan) 
 */
public class Money
{
    /* 
     * Initializing the values in case the user has incorrect inputs 
     */
    private int cent = 0;
    private int dollar = 0;

    /**
     * This constructor will set the dollar amount only, and will default cents to 0
     * @param dollar inserted integer for dollar amount
     * @overload Money
     */
    public Money(int dollar){
        setDollar(dollar);
    }

    /**
     * This constructor will set the dollar amount and the cents 
     * @param dollars inserted integer for dollar amount
     * @param centsinserted integer for cents
     * @overload Money
     */
    public Money(int dollar, int cent) {
        setDollar(dollar);
        setCent(cent);
    }  

    /**
     * a deep copy constructor created to copy another money
     * @param Money another money object that will set the values
     * @overload Money
     */
    public Money(Money other){
        this.cent = other.getCent();
        this.dollar = other.getDollar();
    }

    /**
     * this method will set the cents value 
     * @param cent inserted integer for cents
     */
    public void setCent(int cent){
        if (cent >= 0 && cent <= 99){
            this.cent = cent;
        }
        else if(cent > 99){
            this.cent = (int)((cent * 0.01) % 1);
            this.dollar = (int)(cent / 100);
        }
        else {
            System.out.println("cents cannot be negative, value is set to 0");
        }
    }

    /**
     * this method will set the dollar value
     * @param dollar inserted integer for dollar amount
     */
    
    public void setDollar(int dollar){
        if (dollar < 0){
            System.out.println("dollar cannot be negative, value is set to 0");
        }
        else {
            this.dollar = dollar;
        }
    }

    /**
     * returns the value of cents
     * @return cent
     */
    public int getCent(){
        return this.cent;
    }
    /**
     * returns the value of dollars 
     * @return cent
     */
    public int getDollar(){
        return this.dollar;
    }
    /**
     * returns a double value of the dollars and cents combined
     * @return total
     */
    public double getMoney(){
        double total = this.dollar + (0.01 * this.cent);
        return total;
    }
    /**
     * will sets the values just as the constructor would
     * @param dollar inserted integer for dollar amount
     * @param cent inserted integer for cents
     */
    public void setMoney(int dollar, int cent){
        setDollar(dollar);
        setCent(cent);
    }
    /**
     * will add to the dollar amount based on the int given
     * @param dollar
     */
    public void add(int dollar){
        this.dollar += dollar;
    }
    /**
     * will add to the dollar and cents
     * @param dollar
     * @param cent
     */
    public void add(int dollar, int cent){
        this.dollar += dollar;
        setCent(this.cent+cent);
    }
    /**
     * will add to the dollar and cents from another money object
     * @param other
     */
    public void add(Money other){ 
        this.dollar += other.getDollar();
        setCent(this.cent+other.getCent());
    }
    /**
     * Will compare to money objects to see if they are equal
     * @param other
     * @return boolean returns true if they are equal
     * @override equals
     */
    public boolean equals(Object other){
        if (getMoney() == ((Money)(other)).getMoney()){
            return true;
        }
        return false;
    }
    /**
     * A toString to show the dollar amount using format
     * @override toString
     */
    public String toString(){
        return String.format("$%d.%02d", dollar, cent);
    }
}