import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
/**
 * Write a description of class PokeBall here.
 * 
 * @author (Ben Khabazan) 
 * @version (2917)
 */
public class PokeBall extends Shape
{
    private int radius; //radius of the pokeball
    private double PI = 3.14159;
    public PokeBall(int a, int b, int c){
        super(a,b); //pass the x and y cordinates to parent class (shape)
        this.radius = c;  //set the radius
    }

    /**
     * A method that returns the area of the shape
     * @return Area
     */
    public double getArea(){
        return PI * radius * radius;
    }
    
    /**
     * A method that draws the pokeball
     * @Param Graphics g
     */
    public void draw(Graphics g){
        g.setColor(Color.RED); //sets collor RED for the top
        g.fillArc(getX(),getY(),radius,radius,180,-180); //draw an arc for the top
        g.setColor(Color.WHITE); //sets the collor for the bottom
        g.fillArc(getX(),getY(),radius,radius,-180,180); //draws the bottom arc
        g.fillOval(getX()+ radius/3,getY()+radius/3,radius/3,radius/3); //draws and fills a circle in the middle 
        g.setColor(Color.BLACK); //sets the color black
        g.drawOval(getX()+ radius/3,getY()+radius/3,radius/3,radius/3); //draws a circle to identfity the inside
        g.fillOval(getX()+ 95*radius/224,getY()+ 95*radius/224 ,radius/6,radius/6); //draws the last circle and fills it
    }
}
