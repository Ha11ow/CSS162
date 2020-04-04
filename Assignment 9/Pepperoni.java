/**
 * This is the Pepperoni class
 * 
 * @author (Ben Khabazan) 
 * @version (31117)
 */


public class Pepperoni extends Meat {
    private final static int pepperoniCalorie = 285;
    private final static String description = "Pepperoni";  
    private final static Money pepperoniMoney = new Money (6, 00);
   
    /**
     * no arguement constructor that tranfers everything to parent
     */
    public Pepperoni() {
        super(description, pepperoniMoney, pepperoniCalorie);
    }
    
    /**
     * A main method for testing.
     */
    public static void main(String [] args) {
        Pepperoni newPepperoni = new Pepperoni();
        System.out.println(newPepperoni);
    }
}