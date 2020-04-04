import java.io.*;
/**
 * This is an instance of money that will be used in real life
 * the money gets used just as dollars would in US
 * there will be cents and dollars
 * 
 * @author (Ben Khabazan) 
 */
public class Money implements Comparable<Object>, Cloneable, Serializable
{
    /* 
     * Initializing the values in case the user has incorrect inputs 
     */
	int cent = 0;
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
        if (other == null){
            this.setCent(0);
            this.setDollar(0);
        }
        else {
            Money newMoney = (Money) other.clone();
            this.setCent (newMoney.getCent());
            this.setDollar(newMoney.getDollar());
        }
    }

    /**
     * will clone the money class
     */
    public Object clone(){
        try{
            Money clone = (Money)super.clone();
            return clone;
        }
        catch (CloneNotSupportedException e){
            return null;
        }
    }

    /**
     * implemented from the compareTo interface
     * compares money, by dollars then cents
     * @return int   (if - then less, if + then its more)
     */
    public int compareTo( Object o){
        int returnInt = 0;
        try{
            if (!( o instanceof Money )|| o == null){
                throw new IllegalArgumentException("Inputed value is not a" + 
                    " valid Money object");

            }
            Money other = (Money) o;
            if (this.getDollar() > other.getDollar()){
                returnInt = 1;
            }
            else if (this.getDollar() < other.getDollar()){
                returnInt = -1;
            }
            else if (this.getDollar() == other.getDollar()){
                if (this.getCent() > other.getCent()){
                    returnInt = 1;
                }
                else if (this.getCent() < other.getCent()){
                    returnInt = -1;
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return returnInt;
    }

    /**
     * this method will set the cents value 
     * @param cent inserted integer for cents
     */
    public void setCent(int cent){
        try{
            if (cent >= 0 && cent <= 99){
                this.cent = cent;
            }
            else if(cent > 99){
                this.cent = (int)((cent * 0.01) % 1);
                this.dollar = (int)(cent / 100);    
            }
            else {
                throw new Exception();
            }
        } catch(Exception e){
            System.out.println("Wrong value for cent");
            System.exit(0);
        }
    }

    /**
     * this method will set the dollar value
     * @param dollar inserted integer for dollar amount
     */
    public void setDollar(int dollar){
        try {
            if (dollar > 0){
                this.dollar = dollar;
            }
            else {
                throw new Exception();
            }
        }catch(Exception e){
            System.out.println("Wrong value for dollar");
            System.exit(0);
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
        double totalMoney = this.dollar + (0.01 * this.cent);
        return totalMoney;
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
        add(dollar,0);
    }

    /**
     * will add to the dollar and cents
     * @param dollar
     * @param cent
     */
    public void add(int dollar, int cent){
        try {
            if (dollar < 0 || cent < 0){
                this.dollar += dollar;
                if (cent >= 0 && cent <= 99){
                    this.cent += cent;
                }
                else if(cent > 99){
                    this.cent += (int)((cent * 0.01) % 1);
                    this.dollar += (int)(cent / 100);
                }
            }
            else {
                throw new Exception("values cannot be negative");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * will add to the dollar and cents from another money object
     * @param other
     */
    public void add(Money other){
        Money another = new Money(other);
        add(another.getDollar(), another.getCent());
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
        return ("$" + (this.dollar) + "." + this.cent);
    }

    public static void main(String [] args) {
        Money money1 = new Money (45, 60);
        System.out.println(money1.getDollar());
        System.out.println(money1);
        money1.add(5, 303);   
        System.out.println(money1);

        Money money2 = (Money) money1.clone();
        System.out.println(money2); // 53.63

        Money money3 = new Money(50);
        Money money4 = (Money) money3.clone();
        System.out.println(money3); // 50.00

        Money money5 = new Money(0, 30);
        System.out.println(money5); 
        Money money6 = (Money) money5.clone(); // 0.30
        System.out.println(money6);

        System.out.println(money1.compareTo(money2)); // 0
        System.out.println(money2.compareTo(money3)); // 1
        System.out.println(money6.compareTo(money2)); // -1
        System.out.println();

        Money testMoney = new Money (10, 50);
        testMoney.add(5, 303);
        System.out.println(testMoney);
        System.out.println(testMoney.getCent());
    }
}