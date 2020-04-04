/**
 * This is the Marinara class
 * 
 * @author (Ben Khabazan) 
 * @version (31117)
 */
public class Marinara extends Base {
    private final static int marCalorie = 231;
    private final static String description = "Marinara";  
    private final static Money marMoney = new Money (0, 50);
   
    /**
     * Sets the predefined in the super class
     */
    public Marinara() {
        super(description, marMoney, marCalorie);
    }
 
    public static void main(String [] args) {
        Marinara newMarinara = new Marinara();
        System.out.println(newMarinara);
    }
    
}