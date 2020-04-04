import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
/**
 * Write a description of class Rectangle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rectangle extends Shape
{
    private int width, height;
    public Rectangle(int a, int b, int c, int d){
        super(a,b);
        width = c;
        height = d;
    }
    
    public double getArea(){
        return width * height;
    }
    
    public void draw(Graphics g){
        g.drawRect(getX(),getY(),width,height);
    }
}