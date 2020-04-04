/**
 * This is the Goat class
 * 
 * @author (Ben Khabazan) 
 * @version (31117)
 */

public class Goat extends Cheese {
    private final static int goatCalorie = 300;
    private final static String description = "goat cheese.";  
    private final static Money goatMoney = new Money (2, 00);	
        
    /**
     * empty constuctor to set the predefined in the super
     */
    public Goat() {
        super(description, goatMoney, goatCalorie);
    }
    
    public static void main(String [] args) {
        Goat newGoat = new Goat();
        System.out.println(newGoat);
    }
}