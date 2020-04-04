
/**
 * instance of circle object, will be used for pizza
 * 
 * @author (Ben Khabazan) 
 * @version (31117)
 */

public class Circle extends Shape {
    private static final int radius = 16; 
    private double area = 0;
    private static final String typeShape = "Circle";

    /**
     * no arguemnt constrictor
     */
    public Circle() {
        super(radius, typeShape);
        calculateArea();
    }

    public static void main(String[] Args){
        Circle myCircle = new Circle();
        System.out.println(myCircle.getArea());
    }
    
    /**
     * copy constructor
     * @param Cicle other
     */
    public Circle(Circle other) {
        super(other.radius, other.typeShape);
        calculateArea();
    }

    /**
     * calculates the area
     */
    public void calculateArea() {
        this.area = Math.PI * super.getX() * super.getX();
    }

    /**
     * this sets the area 
     * @param newA
     */
    public void setArea(double newA) {
        try {
            if (newA < 0) {
                throw new IllegalArgumentException("Cannot set the new area to be less than 0.");
            }
            else {
                this.area = newA;
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @return Returns the area of the circle.
     */
    public double getArea() {
        return this.area;
    }

    @Override 
    /**
     * @return Returns a clone of the current circle.
     */
    public Shape clone() {
        return new Circle(this);
    }
}