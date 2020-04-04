import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
/**
 * Write a description of class Moon here.
 * 
 * @author (Ben Khabazan) 
 * @version (2917)
 */
public class Moon extends Shape
{
    private int height;
    private int width;
    private double PI = 3.14159;
    public Moon(int a, int b, int c, int d){
        super(a,b); //pass the x and y cordinates back to parent(shape)
        if(c < 100){ //to show the shape of the moon, it needs to be bigger
            this.width = c + 100; 
        }
        else {
            this.width = c;  
        }
        if (d < 100){ //same for this one
            this.height = d + 100;
        }
        else{
            this.height = d;
        }
    }
    
    /**
     * get area returns the area of the shape Moon
     * since there are 2 half circles that cut each other off so i reduced one from another
     * @return double area
     */
    public double getArea(){
        double innerOval =  ((PI * ((width-15) / 2) * (height / 2))/2);;
        double outerOval = ((PI * (width / 2) * (height / 2))/2);
        return outerOval - innerOval;
    }

    /**
     * draws the image of the moon
     */
    public void draw(Graphics g){
        g.drawArc(getX(),getY(),width,height,90,180); //an ark from top to bottom
        g.drawArc(getX() + 15,getY(),width - 15,height,90,180); //an ark from top to bottom that is sharper
    }
}
