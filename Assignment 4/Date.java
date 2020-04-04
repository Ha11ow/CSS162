
/**
 * This is the Date class, it represents an actual date given based
 *  on the inputed values
 * 
 * @author (Ben Khabazan)
 */
public class Date
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
        this.month = other.getMonth();
        this.year = other.getYear();
        this.day = other.getDay();
    }

    /**
     * To set the correct values for the day, I will set things if the users incorrectly inserts the numbers
     * if the number is bigger than 31, I set it to 31
     * if the number is smaller than 1, i set it to 1
     * @param day an integer which represents day
     */
    public void setDay(int day){
        if (day > 0 && day <= 31){
            this.day = day;
        }
        else if(day > 31){
            this.day = 31;
            System.out.println("Day cannot be over 31, automatically set to 31");
        }
        else{
            System.out.println("Day cannot be less than 1, automatically set to 1");
        }
    }

    /**
     * To set the correct values for the month, I will set things if the users incorrectly inserts the numbers
     * if the number is bigger than 12, I set it to 12
     * if the number is smaller than 1, i set it to 1
     * @param integer month
     */
    public void setMonth(int month){
        if (month > 0 && month <= 12){
            this.month = month;
        }
        else if(month > 12){
            this.month = 12;
            System.out.println("Month cannot be bigger than 12, automatically set to 12");
        }
        else{
            System.out.println("Month cannot be less than 1, automatically set to 1");
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
        if (year > 2014 && year <= 2024){
            this.year = year;
        }
        else if (year > 2024){
            this.year = 2024;
            System.out.println("Year cannot be more than 2024, automatically set to 2024");
        }
        else{
            System.out.println("Year cannot be less than 2014, automatically set to 2014");
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
     * compares another object to see if it matches this date
     * @return boolean
     * @override equals 
     */
    public boolean equals(Date otherDate){
        if (this.day == otherDate.getDay() && this.month == otherDate.getMonth() && this.year == otherDate.getYear()){
            return true;
        }
        return false;
    }

    /**
     * Using a print format to print the values
     * @override toString 
     */
    public String toString(){
        return String.format("%02d/%02d/%04d", getMonth(), getDay(), getYear());
    }
}
