import java.util.*;
import java.io.*;

/**
 * This is the fraction class, it will create fractions from the given inputs
 * 
 * @author (Ben Khabazan) 
 * @version (31117)
 */

public class Fraction implements Cloneable, Comparable {
    private int numerator; 
    private int denominator; 

    /**
     * The no arguement constructor
     */
    public Fraction(){

    }

    /**
     * this will take in two ints and set the fraction according to those
     * @pram int numerator and denominator
     */
    public Fraction(int numerator, int denominator) {
        setFraction(numerator, denominator);
    }

    /**
     * This will reduce the fraction to the lowest form possible
     * @param int numerator and denominator
     */
    public void reduceFraction(int numerator, int denominator) {
        try {
            if (denominator == 0) {
                throw new IllegalArgumentException("wrong fraction");
            }
            else {
                int smallValue;
                int temp = 1;
                if (numerator <= denominator){
                    smallValue = numerator;
                }
                else {
                    smallValue = denominator;
                }

                for (int i = 1; i <= smallValue; i++) {
                    if ((numerator % i == 0) && (denominator % i == 0)) {
                        temp = i;
                    }
                }
                numerator = numerator / temp;
                denominator = denominator / temp;
                if (numerator == 0) { //sets to 0 for both if the value is 0
                    setNumerator(0);
                    setDenominator(0); 
                }
                else {
                    setNumerator(numerator);
                    setDenominator(denominator);
                }
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * checks to see if the given object is a fraction and compare the two
     * @param Object other
     * @return boolean
     */
    public boolean equals(Object other){

        boolean temp = false;
        if (other instanceof Fraction){
            Fraction otherFrac = (Fraction) other;
            if (this.getNumerator() == otherFrac.getNumerator() 
            && this.getDenominator() == otherFrac.getDenominator()){
                temp = true;
            }
            else {
                temp = false;
            }
        }
        return temp;

    }

    /**
     * sets the numerator if meets inverients 
     * @param n
     */
    public void setNumerator(int n) {
        try {
            if (n < 0) {
                throw new IllegalArgumentException("Numerator cannot be negative."); // Cannot have negative pizzas.
            }
            else {
                this.numerator = n;
            }
        }
        catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * sets the new fraction if it doesnt have a denominator of 0
     * @param int n and d
     */
    public void setFraction (int n, int d){
        try {
            if( d != 0 ) {
                this.numerator = n; //this sets them
                this.denominator = d; //this sets them
            }
            else if (numerator == 0) {
                setDenominator(0); //this just changes the denominator
                setNumerator(n);
            }
        }
        catch (Exception e) {
            System.out.println("Cannot have a denominatorinator of 0.");
        }
    }

    /**
     * sets the denominator if meets invarients 
     * @param int d
     */
    public void setDenominator(int d) {
        try {
            if(d != 0){
                this.denominator = d;
            } else if(numerator == 0){
                this.denominator = 0;
            }
            else {
                throw new IllegalArgumentException("Cannot randomly set denominator to 0.");
            }
        }   
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    /**
     * returns a toString
     */
    public String toString(){
        return getNumerator() + "/" + getDenominator() + " ";
    }

    /**
     * this will return the numerator
     * @return int numerator
     */
    public int getNumerator(){
        return this.numerator;
    }

    /**
     * this will return denominator 
     * @return int denominator
     */
    public int getDenominator(){
        return this.denominator;
    }

    @Override
    /**
     * this clones the fraction using the clone interface
     * @return Object
     */
    public Object clone() {
        Fraction newFraction = null;
        try {
            newFraction = (Fraction) super.clone();
        }
        catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
        return newFraction;
    }

    /**
     * @param f Takes in a parameter type of class Fraction.
     * 
     * Multiplies both fraction's denominator together. 
     * 
     * Both numerator's are multiplied by the other Fraction's
     * denominator accordingly.
     * 
     * The reduce method is then called to give final product
     * of the fraction.
     */
    public void subtract(Fraction f) {
        try {
            if (f == null || !(f.getClass().equals(Fraction.class)) || f.denominator == 0) {
                throw new IllegalArgumentException("Invalid fraction to subtract from.");
            }
            else {
                Fraction other = (Fraction) f;
                int tempDenom = this.denominator * other.denominator;
                int tempNum1 = this.numerator * other.denominator;
                int tempNum2 = other.numerator * this.denominator;
                int newNum = tempNum1 - tempNum2;
                reduceFraction(newNum, tempDenom);
            }
        }
        catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param other Takes in a parameter object.
     * 
     * Divides the current numerator and denominator into a 
     * variable called thisFraction.
     * 
     * Does the same with the fraction being passed through the parameter.
     * 
     * With both values, they are compared to and a value is
     * returned based on the comparison.
     */
    public int compareTo(Object other) {
        int returnValue = 0;
        try {
            if (other == null || !(other.getClass().equals(Fraction.class))) {
                throw new IllegalArgumentException("Not a fraction to compare to.");
            }
            else {
                Fraction newFraction = (Fraction) other;
                double otherFraction = (double) newFraction.getNumerator() / newFraction.getDenominator();
                double thisFraction = (double) this.numerator / this.denominator;
                if (thisFraction < otherFraction) {
                    returnValue = -1;
                }
                else if (thisFraction > otherFraction) {
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
}