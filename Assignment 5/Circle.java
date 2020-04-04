import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
/**
 * Write a description of class Circle here.
 * 
 * @author (Ben Khabazan) 
 * @version (020717)
 */
public class Circle extends Shape 
{
    private final double PI = 3.141592; 
    private int radius; //radius of the circle
    public Circle(int a, int b, int c){
        super(a,b);
        radius = c;
    }

    /**
     * get the radius of the circle
     */
    public int getRadius(){
        return this.radius;
    }

    /**
     * sets the radius of the circle
     */
    public void setRadius(int radius){
        if(radius > 0){

            this.radius = radius;
        }
    }

    /**
     * returns the area of the circle
     */
    public double getArea(){
        return PI * radius * radius;
    }

    /**
     * draws the circle
     */
    public void draw(Graphics g){
        g.drawOval(getX(),getY(),radius * 2,radius * 2);
    }
}
