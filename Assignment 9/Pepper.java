import java.awt.Color;
/**
 * This is the Pepper class
 * 
 * @author (Ben Khabazan) 
 * @version (31117)
 */

public class Pepper extends Vegetable {
    private final static int pepperCalorie = 20;
    private final static Money pepMoney = new Money (1, 50);
    private final static String description = " Pepper";  
    
    /**
     * Constructor to set the color as well as all the predefined to super
     */
    public Pepper(Color color) {
        super(description, pepMoney, pepperCalorie, color);
    }

    public static void main(String [] args) {
       Pepper newPep = new Pepper(Color.RED);
        System.out.println(newPep);
    }
}