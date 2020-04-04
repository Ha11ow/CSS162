import java.awt.Color;

/**
 * This class extends ingredient and is a parent to all vegtables
 * 
 * 
 * @author (Ben Khabazan) 
 * @version (31117)
 */

public class Vegetable extends Ingredient {
    private Color vegtableColor;

    /**
     * @param vegType Takes in a string parameter 
     * representing the vegetable.
     * 
     * @param vegCost Takes in parameter type of class Money
     * representing the cost of the vegetable.
     * 
     * @param vegCalorie Takes in an int parameter
     * representing the calorie count of the vegetable.
     */
    public Vegetable(String vegType, Money vegCost, int vegCalorie) {
        super(vegType, vegCost, vegCalorie);
    }

    
    /**
     * Will check to see if the two vegtable classes are the same
     * @param Vegtable other
     * @return boolean equals
     * @override
     */
    public boolean equals(Vegetable other) {
        try {
            if (other == null || !(other.getClass().equals(Vegetable.class))) {
                throw new IllegalArgumentException("Invalid vegetable to compare to.");
            }
            else {
                if (other.vegtableColor.equals(this.vegtableColor) &&
                super.equals(other)){
                    return true;
                }
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * sets the values in the super with the value of vegtable color
     */
    public Vegetable(String vegType, Money vegCost, int vegCalorie, Color color) {
        super(vegType, vegCost, vegCalorie);
        this.vegtableColor = color;
    }

    /**
     * @return the color of the vegtable
     */
    public Color getColor() {
        return this.vegtableColor;
    }

    /**
     * sets the color above
     * @param Color newColor
     */
    public void setColor(Color newColor) {
        try {
            this.vegtableColor = newColor;
        }
        catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Will returnt the string format of the color
     * will have predefined names for the colors
     * @param Color c
     * @return String color name
     */
    public static String getColorName(Color c) throws Exception{
        if (Color.RED.equals(c)){
            return "Red";
        }
        else if (Color.YELLOW.equals(c)){
            return "Yellow";
        }
        else if (Color.GREEN.equals(c)){
            return "Green";
        }
        else if (Color.BLACK.equals(c)){
            return "Black";
        }
        else if (Color.ORANGE.equals(c)){
            return "Orange";
        }
        else {
            throw new Exception("Not a valid color");
        }
    }

    @Override
    /**
     * Will retunr string foramt of vegtable class
     * @return String toString
     */
    public String toString() {
        String retVal = "";
        try{
            retVal = super.toString() + "\nVegetable color: " + getColorName(this.vegtableColor);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return retVal;
    }

}