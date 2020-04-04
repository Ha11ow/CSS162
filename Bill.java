
/**
 * This is the bill class which represents a bill, 
 * it has an amount that is due, a due date,
 *  Originator to find out who its due to and a paid date
 * 
 * @author (Ben Khabazan) 
 */
public class Bill
{
    private Money amount;
    private Date dueDate;
    private Date paidDate;
    private String originator;
    private boolean isPaid; //if true, its paid
    private boolean isLate = true; //if true then its paid late
    
    /**
     * A constructor for the Bill class to set the
     * amount required, a due date, and an originator
     * 
     * @param amount The amount that required to be paid 
     * @param dueDate the date that the money is due
     * @param originator the originator the money is set to be paid to
     * @overload this is one of the constructors for the Bill class
     */
    public Bill(Money amount, Date dueDate, String originator){	
        setAmount(amount);
        setDueDate(dueDate);
        setOriginator(originator);
    }

    /**
     * This is a deep copy constructor for the Bill class
     * @param toCopy the other bill inserted to copy
     * @overload this is one of the constructors for the Bill class
     * 
     */
    public Bill(Bill toCopy){
        if (toCopy.paidDate != null){
            this.amount = toCopy.amount;
            this.dueDate = toCopy.dueDate;
            this.paidDate = toCopy.paidDate;
            this.originator = toCopy.originator;
        }
        else {
            this.amount = toCopy.amount;
            this.dueDate = toCopy.dueDate;
            this.originator = toCopy.originator;
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
     * @return dueDate that hold the value for the due date
     */
    public Date getDueDate(){
        return new Date(this.dueDate);
    }

    /**
     * @return originator that hold the value for the originator
     */
    public String getOriginator(){
        return this.originator;
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
    public boolean setPaid(Date otherDate){
    	if(otherDate.getYear() <= dueDate.getYear()) {
    		if(otherDate.getMonth() <= dueDate.getMonth()) {
    			if(otherDate.getDay() < dueDate.getDay()) {
    		        this.paidDate = new Date(otherDate);
    				isLate = false;
    				isPaid = true;
    				return true;
    			}
    		}
    	}        
        isLate = true;
        isPaid = true;
    	return false;
    }

    /**
     * This sets a new due date for the class
     * @param otherDate the imported date that will be set as the due date
     */
    public boolean setDueDate(Date otherDate){
    	if(isPaid) {
    		return false;
    	}
        this.dueDate = new Date(otherDate);
        return true;
    }

    /**
     * This sets a new amount for the bill, using a copy constructor
     * @param amount
     */
    public boolean setAmount(Money amount){
    	if(isPaid) {
    		return false;
    	}
        this.amount = new Money(amount);
        return true;
    }

    /**
     * returns the originator, no copy constructor needed
     * @param String originator
     */
    public void setOriginator(String originator){
        this.originator = originator;
    }

    /**
     * Checking to see if this bill will copy another imported bill
     * @param toCompare another bill provided to see of they are equal
     * @return Boolean if true they are equal
     * @override
     */
    public boolean equals(Bill toCompare){
        if (this.amount.equals(toCompare.amount) && this.dueDate.equals(toCompare.dueDate) && this.originator == toCompare.originator ){
            return true;
        }
        return false;
    }

    /**
     * Based on the paid date, it will check to see if the bill is paid on time or not, 
     * and will return a string based on that value
     * @override
     */
    public String toString(){
        if (isPaid() == true){
        	if(isLate) {
        		return "The amount due is: " + getAmount() + "\n" + 
        				"Due date is: " + getDueDate()  + "\n" +  
        				"To: " + getOriginator() + ". " + "\n" + 
        				"Paid late" + "\n";
        	}
        	else {
        		return "The amount due is: " + getAmount() + "\n" + 
        				"Due date is: " + getDueDate()  + "\n" +  
        				"To: " + getOriginator() + ". " + "\n" + 
        	            "it's paid on: " + this.paidDate + "\n" + 
        	            "Paid on time" + "\n";
        	}
        }
        else {
            return "The amount due is: " + getAmount() + "\n" + 
            "Due date is: " + getDueDate()  + "\n" +  
            "To: " + getOriginator() + ". " + "\n" + 
            "Not paid yet\n";
        }

    }
}
