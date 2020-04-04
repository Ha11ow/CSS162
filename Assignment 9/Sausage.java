/**
 * This is the Sausage class
 * 
 * @author (Ben Khabazan) 
 * @version (31117)
 */

public class Sausage extends Meat {
    private final static int sausageCalorie = 500;
    private final static String description = "Sausage";  
    private final static Money sausageMoney = new Money (5, 25);

    /**
     * Empty constructor to set the predefined in the super
     */
    public Sausage() {
        super(description, sausageMoney, sausageCalorie);
    }

    public static void main(String [] args) {
        Sausage newSausage = new Sausage();
        System.out.println(newSausage);
    }
}