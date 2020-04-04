import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
class Square extends Shape  {

    private int sideLength;

    public Square(int a, int b, int c){
        super(a,b);
        sideLength = c;
    }
    //getSide:  Add this getter method
    public int getSideLength(){
        return this.sideLength;
    }
    //setSide:  Add this setter method
    public void setSideLength(int a){
        this.sideLength = a;
    }

    /**
     * returns the area of the object
     * Side times Side for square
     */
    public double getArea() {
        return sideLength * sideLength; 
    }

    /**
     * draws the shape of the square with given values
     */
    public void draw(Graphics g) {
        g.drawRect( getX(), getY(), sideLength, sideLength);
    }
}
