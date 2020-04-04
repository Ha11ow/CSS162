
/**
 * Write a description of class PermanentHire here.
 * 
 * @author (Ben Khabazan) 
 * @version (020717)
 */
public class PermanentHire extends SalariedWorker
{
    // instance variables - replace the example below with your own
    private double bonus ;

    /**
     * Constructor for objects of class PermanentHire
     */
    public PermanentHire()
    {
        super();
    }

    /**
     * Constructor for objects of class PermanentHire
     */
    public PermanentHire(String name, int social)
    {
        super(name, social);
    }

    /**
     * Constructor for objects of class PermanentHire
     */
    public PermanentHire(String name, int social, double pay)
    {
        super(name, social, pay);
    }

    public double calculateWeeklyPay() { 
        bonus = super.calculateWeeklyPay() / 10 * 15;
        return super.calculateWeeklyPay() + bonus; 
    }

}
