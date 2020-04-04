
/**
 * Write a description of class PermanentHire here.
 * 
 * @author (Ben Khabazan) 
 * @version (020717)
 */
public class Consultant extends HourlyWorker
{
    // instance variables - replace the example below with your own
    public static final double CONSULTANT_WAGE = 3;
    private  double hourlyWage;
    public Consultant(String name, int social){ 
        super(name, social); 
        hourlyWage = CONSULTANT_WAGE;
    }

    public Consultant(String name, int social, double hourlyPay) {
        super(name, social);
        if( hourlyPay > 3) { 
            this.hourlyWage = hourlyPay; 
        }
    }

    public double calculateWeeklyPay() {
        return hourlyWage * 15 + 50;
    }

}
