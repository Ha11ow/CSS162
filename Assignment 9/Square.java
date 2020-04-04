
/**
 * Instance of a square shape, will be used for pizza
 * 
 * @author (Ben Khabazan) 
 * @version (31117)
 */
public class Square extends Shape {
    private static final int sides = 32;
    private double area = 0;
    private static final String typeShape = "Square";
    
    /**
     * normal values for the square when no arguemnet called
     */
    public Square() {
        super(sides, typeShape);
        calculateArea();
    }
    
    public static void main(String[] Args){
        Square mySquare = new Square();
        System.out.println(mySquare.getArea());
    }
    
    /**
     * will copy the other shape when give in parameters
     * @param Square other
     */
    public Square(Square other) {
        super(other.sides, other.typeShape);
        calculateArea();
    }
    
    /**
     * will set the area of the shape to the given area
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
     * will return the area
     * @return double area
     */
    public double getArea() {
        return this.area;
    }
    
    /**
     * will calculate the area
     */
    public void calculateArea() {
        this.area = super.getX() * super.getX();
    }
    
    @Override
    /**
     * will clone the shape of the object
     */
    public Shape clone() {
        return new Square(this);
    }
}