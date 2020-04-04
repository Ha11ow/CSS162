/**
 * This is the Mozzerella class
 * 
 * @author (Ben Khabazan) 
 * @version (31117)
 */

public class Mozzarella extends Cheese {
    private final static int mozzCalorie = 310;
    private final static String description = "Mozzarella cheese";  
    private final static Money mozzMoney = new Money (1, 50);

    /**
     * A constructor that uses its super class's
     * constructor to set the properties.
     */
    public Mozzarella() {
        super(description, mozzMoney, mozzCalorie);
    }
    
    public static void main(String [] args) {
        Mozzarella newMozzerella = new Mozzarella();		
        System.out.println(newMozzerella);
    }
}