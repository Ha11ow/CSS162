import java.util.*;
import java.awt.*;
     
/**
 * This is the pizza class, it will create the instance of the virtual pizza that will be 
 * then tested by the pizzaManager class
 * 
 * @author (Ben Khabazan) 
 * @version (31117)
 */
public class Pizza implements PizzaComparable {
    //private Ingredient myIngredient;
    private ArrayList<Ingredient> myList = new ArrayList<Ingredient>();
    private int theCalorie = 0;
    private Money theCost = new Money(0, 0);
    private Shape theShape;
    private Fraction theFraction = new Fraction (1, 1);

    /**
     * This pizza class randomly creates a new pizza with different ingredients
     */
    public Pizza() {
        if(Math.random() > 0.50) {
            addIngredient(new Alfredo());
        }
        else {
            addIngredient(new Marinara());
        }

        // Next randomly assign cheese.
        if(Math.random() > 0.50) {
            addIngredient(new Mozzarella());
        }
        else {
            addIngredient(new Goat());
        }

        // Next randomly assign meat
        if(Math.random() > 0.60) {
            addIngredient(new Sausage());
        }
        else {
            addIngredient(new Pepperoni());
        }

        // Next randomly assign vegetable
        // Assigns a color as well.
        double veggieColor = Math.random();
        if(veggieColor < 0.15) {
            addIngredient(new Pepper(Color.RED));
        }
        else if (veggieColor > 0.15 && veggieColor < 0.25) {
            addIngredient(new Pepper(Color.YELLOW));
        }
        else if (veggieColor > 0.25 && veggieColor < 0.35) {
            addIngredient(new Pepper(Color.GREEN));
        }
        else if (veggieColor > 0.35 && veggieColor < 0.45) {
            addIngredient(new Pepper(Color.ORANGE));
        }
        else if (veggieColor > 0.45 && veggieColor < 0.60) {
            addIngredient(new Olive(Color.BLACK));
        }
        else {
            addIngredient(new Olive(Color.GREEN));
        }

        // Generate a random shape for the pizza.
        if (Math.random() < 0.5) {
            Circle newCircle = new Circle();
            this.theShape = newCircle;
        }
        else {
            Square newSquare = new Square();
            this.theShape = newSquare;
        }
    }

    @Override 
    /**
     * compares the objects to one anob if they are the same instances
     * @pram object ob
     * @return int
     */
    public int compareTo(Object ob) {
        try {
            if (ob == null || !(ob.getClass().equals(Pizza.class))) {
                throw new IllegalArgumentException("No given pizza to compare to.");
            }
            else {
                Pizza newPizza = (Pizza) ob;
                return this.theCost.compareTo(newPizza.theCost);
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    @Override
    /**
     * Takes in an object and checks to see if it can be compared then
     * then it will compare the sizes (areas) and return which is bigger
     * @param (object ob)
     * @return (int) if bigger it will be positive
     */
    public int compareToBySize (Object ob) {
        try {
            if(ob == null || !(ob.getClass().equals(Pizza.class))) {
                throw new IllegalArgumentException("Given parameter is not a fraction to be compared by size.");
            }
            else {
                Pizza newPizza = (Pizza) ob;
                if (this.getRemainingArea() < newPizza.getRemainingArea()) {
                    return -1;
                }
                else if (this.getRemainingArea() > newPizza.getRemainingArea()) {
                    return 1;
                }
                else {
                    return 0;
                }
            }
        }
        catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return -5;
    }
    
      @Override
    /**
     * Prints what ever is in the pizza
     * @return String toString
     */
    public String toString() {
        String retVal = "";
        String formattedArea = String.format("%.02f", getRemainingArea());

        for (int count = 0; count < myList.size(); count++) { //gets all the values 
            Ingredient temp = (Ingredient) myList.get(count);
            retVal += temp.getDescription();
        }
 
        return "Pizza has a price: " + getCost().toString() + " and calories: " + this.theCalorie + ", Fraction remaining: " +
        this.theFraction + " and area left: " + formattedArea + " and shape: " + theShape.getShapeType() + 
        "\nList of toppings: " + retVal;
    }

    @Override
    /**
     * compares the two objects by calories of the two pizza
     *  @param Object ob   
     *  @return int
     */
    public int compareToByCalories (Object ob) {
        int returnValue = 0;
        try {
            if(ob == null || !(ob.getClass().equals(Pizza.class))) {
                throw new IllegalArgumentException("Invalid pizza passed through");
            }
            else {
                Pizza newPizza = (Pizza) ob;
                if(this.theCalorie < newPizza.getCalories()) {
                    returnValue = -1;
                }
                else if (this.theCalorie > newPizza.getCalories()) {
                    returnValue = 1;
                }
                else {
                    returnValue = 0;
                }
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return returnValue;
    }

    /**
     * will return the fraction
     * @return theFraction
     */
    public Fraction getFraction() {
        return this.theFraction;
    }

    /**
     * will get the total calories
     * @return theCalorie
     */
    public int getCalories() {
        return this.theCalorie;
    }

    /**
     * This is a helper method to add the cost of the money with the given ingredient
     * @param Ingredient other
     */
    private void addCost(Ingredient other) {
        this.theCost.add(other.getCost());
    }

    /**
     * returns the totol cost of the remaining fraction of the pizza
     * @return Money
     */
    public Money getCost() {        
        try{
            double Numerator = (double) theFraction.getNumerator();
            double denomLeft = (double) theFraction.getDenominator();
            double totalFrac = Numerator / denomLeft;
            double totalMoney = theCost.getMoney();
            double newMoney = totalMoney * totalFrac;
            String [] splitMoney = String.valueOf(newMoney).split("\\.");
            String dollar = splitMoney [0];
            String cents = splitMoney [1] + "0000";
            cents = cents.substring(0, 2);
            return new Money(Integer.parseInt(dollar), Integer.parseInt(cents));
        }
        catch (Exception e) {

        }
        return this.theCost;
    }

    /**
     * Sets the shape currently set to the shape given
     * @param Shape other
     */
    public void setShape(Shape other) {
        this.theShape = (Shape) other.clone();
    }

    /**
     * adds given to the list of ingreditents
     * @param ingredient other
     */
    public void addIngredient(Ingredient other) {
        try {
            if (other == null || !(other instanceof Ingredient)) {
                throw new PizzaException("Invalid ingredient to add to the pizza.");
            }
            else {   
                myList.add(other);            
                this.theCalorie += other.getCalories();
                addCost(other);
            }
        }
        catch (PizzaException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * Subtracts the remaining pizza from the ammount ate by the user
     * @param Fraction other
     */
    public void eatSomePizza(Fraction other) {
        try {
            if (other == null || !(other.getClass().equals(Fraction.class))) {
                throw new PizzaException("Invalid fraction being subtracted to the pizza.");
            }            
            Fraction eaten = (Fraction) other; //changes the fraction and points to other
            theFraction.subtract(eaten); //eats the pizza

            if(theFraction.getNumerator() < 0) {
                throw new PizzaException("Cannot eat negative slices of pizza!");
            }           
            else if (theFraction.getNumerator() == 0) { //if there is non left
                this.theCost = new Money(0, 0);
                theShape.setArea(0.0);
                throw new PizzaException("All the pizzas have been eaten.");
            }
        }
        catch (PizzaException e) {
            System.out.println(e.getMessage());
        }   
    }

  

    /**
     * sets the fraction that is defined to the fraction given
     * @param Fraction other
     */
    public void setRemaining(Fraction other) {
        try {
            if (other == null || !(other.getClass().equals(Fraction.class))) {
                throw new PizzaException("A fraction was not given.");
            }
            else {
                Fraction newFrac = (Fraction) other;
                theFraction.setFraction(newFrac.getNumerator(), newFrac.getDenominator());
            }
        }
        catch (PizzaException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * gets the remaining area of the pizza after or before it was ate
     * @return double remaining area
     */
    public double getRemainingArea() {
        double Numerator = (double) theFraction.getNumerator();
        double Denominator = (double) theFraction.getDenominator();
        double finalValue = Numerator / Denominator; 
        return theShape.getArea() * finalValue;
    }

    /**
     * A main method for testing. 
     * 
     * This main method might seem short
     * however all the add methods are tested in
     * the Pizza constructor.
     */
    public static void main (String [] args) {
        Pizza myPizza1 = new Pizza();
        Pizza myPizza2 = new Pizza();
        Pizza myPizza3 = new Pizza();

        System.out.println(myPizza1);
        System.out.println(myPizza2);
        System.out.println(myPizza3);

        System.out.println(myPizza1.compareTo(myPizza1));
        System.out.println(myPizza2.compareTo(myPizza3));
        System.out.println(myPizza1.compareToByCalories(myPizza2));
        System.out.println(myPizza2.compareToByCalories(myPizza3));
        System.out.println(myPizza1.compareToBySize(myPizza3));

        System.out.println("\n------Eating pizza1------");
        Fraction eat = new Fraction(1, 4);
        myPizza1.eatSomePizza(eat);
        System.out.println(myPizza1);

        myPizza1.eatSomePizza(eat);
        System.out.println(myPizza1);

        myPizza1.eatSomePizza(eat);
        System.out.println(myPizza1);

        myPizza1.eatSomePizza(eat);
        System.out.println(myPizza1);

        System.out.println("Pizza1 :\n" + myPizza1);
        System.out.println("Pizza2 :\n" + myPizza2);
        System.out.println("Pizza3 :\n" + myPizza3);
    }
}