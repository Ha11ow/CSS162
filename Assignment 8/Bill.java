import java.util.*;
import java.io.*;
/**
 * This is an instance of a bill
 * 
 * @author (Ben Khabazan) 
 */
public class Bill implements Comparable<Object>, Cloneable, Serializable 
{
    private Money amount;
    private Date dueDate;
    private Date paidDate;
    private String originator;
    private boolean isPaid; //if true, its paid
    private boolean isLate = true; //if true then its paid late

    /**
     *	Constructor to set the Money, Date, and the String for the Bill class
     * @param amount 		The amount required 
     * @param dueDate		The due date
     * @param originator	the originator for the class
     */
    public Bill(Money amount, Date dueDate, String originator){
        setAmount(amount);
        setDueDate(dueDate);
        setOriginator(originator);
    }

    /**
     * A deep copy of the Bill class
     * @param toCopy 	the imported bill that will be copied
     */
    public Bill(Bill toCopy){
        try{
            if (toCopy!= null ){
                if (toCopy.paidDate != null){
                    Bill newBill = (Bill) toCopy.clone();
                    this.amount =  new Money(toCopy.amount);
                    this.dueDate = new Date(toCopy.dueDate);
                    this.paidDate = new Date (toCopy.paidDate);
                    this.originator = toCopy.originator;
                }
                else {
                    this.amount = new Money(toCopy.amount);
                    this.dueDate = new Date (toCopy.dueDate);
                    this.originator = toCopy.originator;
                }
            }
            else {
                throw new Exception();
            }
        }
        catch (Exception e){
            System.out.println("Cannot enter null bill");
        }
    }
    
    /**
     * gets the amount due on the bill
     * using a copy constructor
     * @return Money
     */
    public Money getAmount(){
        return new Money(this.amount);
    }
    
    /**
     * This sets a new amount for the bill, using a copy constructor
     * @param amount
     */
    public void setAmount(Money amount){
        this.amount = new Money(amount);
    }


    /**
     * Will return the due date
     * @return Date
     */
    public Date getDueDate(){
        return new Date(this.dueDate);
    }

    
    /**
     * This sets a new due date for the class
     * @param nextDate the imported date that will be set as the due date
     */
    public void setDueDate(Date nextDate){
        this.dueDate = new Date(nextDate);
    }
    
    /**
     * will return the originator
     * @return String
     */
    public String getOriginator(){
        return this.originator;
    }


    /**
     * returns the originator, no copy constructor needed
     * @param originator
     */
    public void setOriginator(String originator){
        this.originator = originator;
    }
    
    /**
     * @return isPaid that hold the boolean if its paid true means its paid
     */
    public boolean isPaid(){
        return this.isPaid;
    }

    /**
     * using another Date class, this method will replace the paid date
     * and also set the is paid while doing so
     * @param otherDate imported date to replace with
     */
    public void setPaid(Date nextDate){
        try{
            this.paidDate = new Date(nextDate);
            isPaid = true;
        }catch (InputMismatchException e){
            System.out.println("entered paid date is not a "+
                "object of date");
            System.exit(0);
        }
    }

    /**
     * This method removes the paid date and also set is paid to false
     */
    public void setUnpaid(){
        this.paidDate = null;
        isPaid = false;
    }

    /**
     * Will create a clone of Bill
     */
    public Object clone(){
        Bill clone = new Bill((Money) this.amount.clone(),(Date) this.dueDate.clone(), this.originator);
        try{
            if(this.paidDate != null){
                clone.setPaid(this.paidDate);
            }
            else{
                throw new CloneNotSupportedException();
            }
        }
        catch (CloneNotSupportedException e){
            System.out.println("No paid date");
        }
        return clone;
    }

    /**
     * Checking to see if this bill will copy another imported bill
     * @param toCompare another bill provided to see of they are equal
     * @return Boolean if true they are equal
     */
    public boolean equals(Bill toCompare){
        if (this.amount.equals(toCompare.amount) &&
        this.dueDate.equals(toCompare.dueDate) && 
        this.originator == toCompare.originator ){
            return true;
        }
        return false;
    }

    /**
     * Will compare this Bill to another bill
     * if the bill has a higher amount set then it will return positive
     * if the bill has a lower amount will return negative
     * if equal it will return 0
     */
    public int compareTo(Object other) {
        int returnVal = 0;
        try {
            if (other == null || !(other instanceof Bill)) {
                throw new Exception();
            }
            Bill bill = (Bill) other;

            if (this.amount.compareTo(bill.amount) == 1) {
                returnVal = 1;
            }
            else if (this.amount.compareTo(bill.amount) == -1) {
                returnVal = -1;
            }
            else if (this.amount.compareTo(bill.amount) == 0) {
                returnVal = this.originator.compareTo(bill.originator);
            }

        }
        catch (Exception e) {
            System.out.println("Invalid parameter.");
        }
        return returnVal;
    }

    /**
     * Based on the paid date, it will check to see if the bill is paid on time or not, 
     * and will return a string based on that value
     */
    public String toString(){
        String late;
        if (dueDate.compareTo(paidDate) == -1){
            late = "Paid late";
        }
        else {
            late = "Paid on time";
        }
        if (isPaid() == true){
            return "The amount due is: " + getAmount() + "\n" + 
            "Due date is: " + getDueDate()  + "\n" +  
            "To: " + getOriginator() + ". " + "\n" + 
            "it's paid on: " + this.paidDate + "\n" + 
            late + "\n";
        }
        else {
            return "The amount due is: " + getAmount() + "\n" + 
            "Due date is: " + getDueDate()  + "\n" +  
            "To: " + getOriginator() + ". " + "\n" + 
            "Not paid yet\n";
        }
    }

    public static void main(String [] args) {
        Money money1 = new Money(40, 49);
        Date date1 = new Date(2, 10, 2016);
        String originator1 = "Comcast";

        Bill bill1 = new Bill(money1, date1, originator1);
        Bill bill2 = (Bill) bill1.clone();
        System.out.println("bill2:\n" + bill2 +  "bill 1:\n" +  bill1);

        Money money2 = new Money(10, 99);
        Bill bill3 = new Bill(money2, date1, "Amazon");
        Date paid1 = new Date(8, 30, 2015);
        bill3.setPaid(paid1);
        Bill bill4 = (Bill) bill3.clone();
        System.out.println("bill 3: \n" + bill3 + "bill4: \n" + bill4);

        Money money3 = new Money(30, 00);
        Date date2 = new Date(6, 15, 2018);
        Bill bill5 = new Bill(money3, date2, "FedEx");
        Date paid2 = new Date(6, 16, 2018);
        bill5.setPaid(paid2);
        Bill bill6 = (Bill) bill5.clone();
        System.out.println("bill5: \n" + bill5 + "bill 6: \n" + bill6);

        
        Money money4 = new Money(20, 16);
        Date date3 = new Date(4, 04, 2016);
        Bill bill7 = new Bill(money4, date3, "Water Company");
        Date paid3 = new Date(4, 04, 2016);
        bill7.setPaid(paid3);
        System.out.println("bill7: \n" + bill7);
        
        System.out.println();

        System.out.println(bill2.compareTo(bill1)); // 0
        System.out.println(bill3.compareTo(bill1)); // -1
        System.out.println(bill1.compareTo(bill3)); // 1
        System.out.println();

    }
}

