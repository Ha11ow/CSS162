/**
 * This class is the parent to all meats and extended from ingredient class
 * 
 * @author (Ben Khabazan) 
 * @version (31117)
 */

public class Meat extends Ingredient {
    /**
     * This constructor will take in 3 parametes which will each set 
     * the instnace varibales in the parent class of meat
     * @param String description
     * @param Money totalCost
     * @param int totalCal
     */
    public Meat(String description, Money totalCost, int totalCal) {
        super(description, totalCost, totalCal);
    }
}