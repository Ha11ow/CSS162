/**
 * This is the Olive class
 * 
 * @author (Ben Khabazan) 
 * @version (31117)
 */

import java.awt.Color;

public class Olive extends Vegetable {
    private final static int oliveCalorie = 50;
    private final static String description = "Olive";  
    private final static Money oliveMoney = new Money (3, 00);
    
    /**
     * A main method for testing.
     */
    public static void main(String [] args) {
        Olive newOlive = new Olive(Color.GREEN);
        System.out.println(newOlive.toString());
    }
    
    /**
     * Constructor for color
     */
    public Olive(Color color) {
        super(description, oliveMoney, oliveCalorie, color);
    }
}