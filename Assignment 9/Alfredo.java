/**
 * This is the Alfredo class
 * 
 * @author (Ben Khabazan) 
 * @version (31117)
 */

public class Alfredo extends Base {
    private final static int alfCalorie = 215;
    private final static String description = "Alfredo that is handed tossed with Parmesan cheese and butter.";  
    private final static Money alfMoney = new Money (1, 00);
    
    /**
     * Sets the predefined in the super class
     */
    public Alfredo() {
        super(description, alfMoney, alfCalorie);
    }
    
    public static void main(String [] args) {
        Alfredo newAlfredo = new Alfredo();
        System.out.println(newAlfredo);
    }
}

