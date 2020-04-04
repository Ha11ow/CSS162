import java.io.*;
/**
 * Write a description of class Money here.
 * 
 * @author (Ben Khabazan) 
 * @version (2/2/17)
 */
public class Money implements Comparable<Object>, Cloneable, Serializable
{
    /* 
     * initilizing the values in case the user has incorrect inputs 
     */
    private int cent = 0;
    private int dollar = 0;

    /**
     * Constructor for setting dollars only
     * calls the setDollar method to set dollars using the parameter
     * @param integer dollar
     * @overload Money
     */
    public Money(int dollar){
        setDollar(dollar);
    }

    /**
     * constuctor for setting both dollars and cents
     * calls the setDollar method to store the dollars
     * calls the setCent method to store the methods
     * @param integer dollars
     * @param integer cents
     * @overload Money
     */
    public Money(int dollar, int cent) {
        setDollar(dollar);
        setCent(cent);
    }  

    /**
     * copy constuctor for copying the cents and dollars for the Money class
     * @param Object Money
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

    @Override
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
     * compares moeny, by dollars then cents
     * @return int   (if - then less, if + then its more)
     */
    @Override
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
     * To set the cents in the class you can use the setCent method
     * @param integer cent
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
     * set dollars seperatly using setDollar
     * @param integer dollar
     */

    public void setDollar(int dollar){
        try {
            if (dollar >= 0){
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
     * getCent return the value of the cents in the Money class
     * @return integer cent
     */
    public int getCent(){
        return this.cent;
    }

    /**
     * getDollar returns the value of the dollars in the Money class
     * @return integer cent
     */
    public int getDollar(){
        return this.dollar;
    }

    /**
     * getMoney returns a double value of the dollars and cents combined
     * @return double totalMoney
     */
    public double getMoney(){
        double totalMoney = this.dollar + (0.01 * this.cent);
        return totalMoney;
    }

    /**
     * to setMoney, we get two integers in order the dollar and the cent
     * then we pass them to the correct parameters to give values
     * @param integer dollar
     * @param integer cent
     */
    public void setMoney(int dollar, int cent){
        setDollar(dollar);
        setCent(cent);
    }

    /**
     * adds dollars to the predefined dollars
     * @param integer dollar
     */
    public void add(int dollar){
        add(dollar,0);
    }

    /**
     * adds dollars and cents to the predefined dollars and cents
     * @param integer dollar
     * @param integer cent
     */
    public void add(int dollar, int cent){
        try {
            if (dollar > 0 || cent > 0){
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
     * adds the money given from another money class
     * @param Object Money other
     */
    public void add(Money other){
        Money another = new Money(other);
        add(another.getDollar(), another.getCent());
    }

    /**
     * overriding the equals method to comapare an object with another with this money class
     * @param Object other
     * @return boolean 
     * @override equals
     */
    public boolean equals(Object other){
        if (getMoney() == ((Money)(other)).getMoney()){
            return true;
        }
        return false;
    }

    /**
     * overriding the toString to return a specific form of Money and not the reference number
     * @override toString
     */
    public String toString(){
        return ("$" + (this.dollar) + "." + this.cent);
    }
}