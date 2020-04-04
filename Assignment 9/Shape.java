import java.awt.*;

/* Class Shape
 *
 * By Rob Nash (with minor edits by Johnny Lin)
 * 
 * This is the superclass in a hierarchy of shapes that you have to construct
 */

//the superclass in our inheritance hierarchy
//all "common" features, functions and data should go here
//for example, all shapes in Java2D have a x,y that declares their position
//and many of the shapes exposed have a width and a height (but not all, so we didn't put width and height here)
//note that this class is mostly empty, as there is no algorithm generic enough to guess an arbitrary shape's area (future subclasses must override getArea() to provide something reasonable)
//also, the draw method is empty too, as we don't know what shape to draw here! (again, our subclasses will need to replace this method with one that actually draws things)

/**
 * Shape class
 * 
 * @author (Ben Khabazan) 
 * @version (31117)
 */
public abstract class Shape extends Object implements Cloneable, Comparable {
    private int x = 0;
    // private int y = 0;
    private double area;
    private String typeShape; // Indicates the shape of the object

    /**
     * sets the constuctor with 2 arguments
     * @int x
     * @String shape
     */
    public Shape( int x, String shape) {
        setX(x);
        setShapeType(shape);
    }

    /**
     * gets the type
     * @return String typeShape
     */
    public String getShapeType() {
        return this.typeShape;
    }

    /**
     * since not set will only return -1
     * @return -1
     */
    public double getArea(){ return -1; }

    /**
     * sets the area to a double given
     * @pram double a
     * 
     */
    public void setArea(double a) {
        this.area = a;
    }

    /**
     * sets the shapeType
     * @pram String s
     */
    public void setShapeType(String s) {
        this.typeShape = s;
    }

    /**
     * @param Takes in a parameter of type Graphics.
     * 
     * This method will assist the program in drawing
     * the shape. 
     */
    public void draw( Graphics g ){}

    /**
     * @return Returns the value of x.
     */
    public int getX() { return x; }

    /**
     * @param value Takes in a parameter of type int.
     * 
     * Sets the value of x according to the param value.
     */
    public void setX(int value) { x = value; }

    @Override 
    /**
     * Method is implemented as an abstract method
     * for the child classes to be defined.
     */
    public abstract Shape clone();

    @Override
    /**
     * checks areas to see if the shapes are the same
     * if they are then it will return 0
     * else if bigger will return 1
     * @return int
     * @param Object other
     */
    public int compareTo(Object other) {
        int returnValue = 0;
        try {
            if (other == null || !(other.getClass().equals(Shape.class))) {
                throw new IllegalArgumentException("Not a valid Shape passed through parameter.");
            }
            else {
                Shape newShape = (Shape) other;
                if (this.area < newShape.area) {
                    returnValue = -1;
                }
                else if (this.area > newShape.area) {
                    returnValue = 1;
                }
                else {
                    returnValue = 0;
                }
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\nVM will be terminated.");
            System.exit(0);
        }
        return returnValue;
    }
}
