import java.text.*;

/**
 * This is the ingredient class that will is the parent to all the ingredients 
 * that will be used in pizza
 * 
 * @author (Ben Khabazan) 
 * @version (31117)
 */

public class Ingredient implements Comparable {
    private String description = "";
    private Money totalCost;
    private int calorie;

    /**
     * This constructor will take in the description of the ingredient, and the cost and the calorues
     * it will set the instance values to those given if they pass the inverient
     * @param String description
     * @pram Moeny totalCost
     * @pram int calorie
     */
    public Ingredient (String description, Money totalCost, int calorie) {
        try {
            if(description == null || totalCost == null || calorie < 0) { //checks to see if makes sense
                throw new PizzaException("Invalid parameters.");
            }
            else {
                this.description = description;
                this.totalCost = new Money(totalCost);
                this.calorie = calorie;
            }
        }
        catch (PizzaException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * No arg constructor
     */
    public Ingredient() {

    }

    /**
     * this will comapre the two objects based on cost only
     */
    public int compareTo(Object other) {
        return totalCost.compareTo(other);
    }

    /**
     * return the cost of money
     * checked privacy leaked
     * @return Money totalCost
     */
    public Money getCost() {
        return new Money (totalCost);
    }

    /**
     * checks to see if two ingredients are equal to one another
     * @param Ingredient other
     * @override
     */

    public boolean equals(Ingredient other) {
        try {
            if (other == null || !(other.getClass().equals(Ingredient.class))) {
                throw new IllegalArgumentException("Invalid parameter passed through for equals.");
            }
            else {
                if (this.description.equals(other.description) &&
                this.totalCost.equals(other.totalCost) &&
                this.calorie == other.calorie) {
                    return true;
                }
            }
        }
        catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * will set the cost of money to the passed in parameter
     * @param Money m   
     */
    public void setCost(Money m) {
        try {
            if (m == null || !(m.getClass().equals(Money.class))) {
                throw new IllegalArgumentException("The money param passed through is invalid.");
            }
            else { //if the money is not null
                this.totalCost = new Money (m);
            }
        }
        catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void ingredientTest(){
        Ingredient test = new Ingredient("WhatEver",new Money(30), 30);
        System.out.println(test);
        Ingredient test2 = new Ingredient("WhereEver",new Money(20), 30);
        System.out.println(test.compareTo(test2));

        System.out.println(test.getCalories());
        System.out.println(test.getDescription());
        System.out.println(test.getCost());
        test.setCalories(1);
        test.setDescription("DFDDDF");
        test.setCost(new Money(77));
        System.out.println(test);
    }

    /**
     * sets the calories to the passed in paramter
     * @param int Other
     */
    public void setCalories(int other) {
        try {
            if (other < 0) {
                throw new IllegalArgumentException("Calorie count cannot be negative.");
            }
            else {
                this.calorie = other;
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * sets the description above
     * @param String d
     */
    public void setDescription(String d){
        this.description.equals(d);
    }
    
    /**
     * this returns the string description
     * @return String description
     */
    public String getDescription(){
        return this.description + "\n";
    }

    @Override
    /**
     * will print all the stored values in here as string format
     * @return String tostring
     */
    public String toString() {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        String formattedCost = String.format("%.02f", totalCost.getMoney());
        return "Description: " + this.description + "\n" + "Cost: " + "$" + formattedCost + "\n" +
        "Calorie count: " + this.calorie;
    }

    /**
     * will return the number of calories
     * @return calorie
     */
    public int getCalories() {
        return this.calorie;
    }
}