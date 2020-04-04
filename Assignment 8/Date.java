import java.io.*;

/**
 * This is the Date class, it represents an actual date given based
 *  on the inputed values
 * 
 * @author (Ben Khabazan)
 */
public class Date implements Comparable<Object>, Cloneable, Serializable
{
	/**
     * Just in-case there are incorrect values given, and to reduce errors 
     * I preset the values and let the user know when they incorrectly 
     * inserted a value
     */
	private int day = 1;
	private int month = 1;
	private int year = 2014;

	/**
     * A constructor to set the values for the date
     * @param month intakes the month 
     * @param day intakes the day
     * @param year intakes the year
     * @override
     */
    public Date(int month, int day, int year){
        setDay(day);
        setMonth(month);
        setYear(year);
    }

    /**
     * A copy constructor created to copy the values of another date class inserted
     * @param other the date that will be copied
     * @overload Date
     */
    public Date(Date other){
        try { 
            if (other == null )
            {
                throw new Exception("The date class given is empty");
            }
            else{
                Date newDate = (Date) other.clone();
                this.setMonth(newDate.getMonth());
                this.setDay(newDate.getDay());
                this.setYear(newDate.getYear());
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * To set the correct values for the day, I will set things if the users incorrectly inserts the numbers
     * if the number is bigger than 31, I set it to 31
     * if the number is smaller than 1, i set it to 1
     * @param day an integer which represents day
     */
    public void setDay(int day){
        try {
        	if (day > 0 && day <= 31){
                this.day = day;
            }
            else if(day > 31){
                this.day = 31;
                throw new Exception("Day cannot be over 31, automatically set to 31");
            }
            else{
            	throw new Exception("Day cannot be less than 1, automatically set to 1");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * To set the correct values for the month, I will set things if the users incorrectly inserts the numbers
     * if the number is bigger than 12, I set it to 12
     * if the number is smaller than 1, i set it to 1
     * @param integer month
     */
    public void setMonth(int month){
        try {
        	if (month > 0 && month <= 12){
                this.month = month;
            }
            else if(month > 12){
                this.month = 12;
                throw new Exception("Month cannot be bigger than 12, automatically set to 12");
            }
            else{
            	throw new Exception("Month cannot be less than 1, automatically set to 1");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * To set the correct values for the day, I will set things if the users incorrectly inserts the numbers
     * I only go from the year 2001 up to 2025
     * therefore if the input is above 2025 it will be defaulted to 2025
     * and if its bellow 2001 it will be defaulted to 2001
     * @param integer year
     */
    public void setYear(int year){
        try {
        	if (year > 2014 && year <= 2024){
                this.year = year;
            }
            else if (year > 2024){
                this.year = 2024;
                throw new Exception("Year cannot be more than 2024, automatically set to 2024");
            }
            else{
            	throw new Exception("Year cannot be less than 2014, automatically set to 2014");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Returns the value for days
     * @return day an integer representing days
     */
    public int getDay(){
        return this.day;
    }

    /**
     * returns the value for months
     * @return month an integer representing months
     */
    public int getMonth(){
        return this.month;
    }

    /**
     * returns the value for years
     * @return year an integer representing years
     */
    public int getYear(){
        return this.year;
    }
    
    /**
     * This method is implemented from the clonable class
     * @return clone    (imported Date)
     * @Override
     */
    public Object clone(){
        try{
            Date clone = (Date)super.clone();
            return clone;
        }
        catch (CloneNotSupportedException e){
            return null;
        }
    }

    /**
     * compares another object to see if it matches this date
     * @param o		imported object
     * @return boolean		will be true of equal
     * @override 
     */
    public boolean equals(Object o){
        if (this.day == ((Date)(o)).getDay() && this.month == ((Date)(o)).getMonth() && this.year == ((Date)(o)).getYear()){
            return true;
        }
        return false;
    }

    /**
     * Implemented from the Compareable<T> interface
     * Compares the year, month, then the day to see if they are higher lower or equal
     * @return int (will be - if the before and + if after)
     */
    public int compareTo( Object other ){
        int returnInt = 0;
        try{
            if (!( other instanceof Date )|| other == null){
                throw new IllegalArgumentException("Inputed value is "+
                    "not a Date object or no Due date");
            }
            Date another = (Date) other;
            if(this.getYear() > another.getYear()){
                returnInt = 1;
            } else if( this.getYear()< another.getYear()){
                returnInt = -1;
            } else if (this.getYear() == another.getYear()){
                if(this.getMonth() > another.getMonth()){
                    returnInt = 1;
                } else if( this.getMonth()< another.getMonth()){
                    returnInt = -1;
                } else if (this.getMonth() == another.getMonth()){
                    if(this.getDay() > another.getDay()){
                        returnInt = 1;
                    } else if( this.getDay()< another.getDay()){
                        returnInt = -1;
                    }
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return returnInt;
    }
    
    /**
     * Using a print format to print the values
     * @override toString 
     */
    public String toString(){
        return getMonth() + "/" + getDay() + "/" + getYear();
    }
    
    public static void dateTests(){
        System.out.print("Date:");
        Date date1 = new Date(1,1,2015);
        System.out.println(date1);
        Date date2 = (Date) date1.clone();
        System.out.print("Cloned Date: ");
        System.out.println(date2);
        System.out.println("Compare clone to date:");
        System.out.println(date2.compareTo(date1));//0
        Date date3 = new Date ( 1, 2 , 2015);
        System.out.println("new Date:");
        System.out.println(date3);
        System.out.println(date1.compareTo(date3));//-1
        System.out.println(date3.compareTo(date1));//1
        Date date4 = new Date (3,1,2015);
        System.out.println(date4.compareTo(date1));//1
        System.out.println(date1.compareTo(date4));//-1
        Date date5 = new Date(1,1,2017);
        System.out.println(date5.compareTo(date1));//1
        System.out.println(date1.compareTo(date5));//-1
        System.out.println(date2.compareTo(date5));//-1
        System.out.println(date3.compareTo(date5));//-1
        System.out.println(date4.compareTo(date5));//-1
        
        
        
        
    }
}
