/**
 * This class is the parent to all cheese ingredients and its
 * extended from ingredient class
 * 
 * @author (Ben Khabazan) 
 * @version (31117)
 */

public class Cheese extends Ingredient {  
    /**
     * This constructor will take in 3 parametes which will each set 
     * the instnace varibales in the parent class of cheese
     * @param String description
     * @param Money totalCost
     * @param int totalCal
     */
    public Cheese (String description, Money totalCost, int totalCal) {
        super(description, totalCost, totalCal);
    }
}