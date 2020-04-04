import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
/**
 * Write a description of class Triangle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Triangle extends Shape
{
    private int width;
    private int height;
    public Triangle(int a, int b, int c, int d){
        super(a, b);
        width = c;
        height = d;
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
    
    public void setWidth(int width){
        this.width = width;
    }
    
    public void setHeight(int height){
        this.height = height;
    }
    public double getArea(){
       return height * width * 1/2;
    }
    
    public void draw(Graphics g){
        g.drawLine(getX(), getY() + height,getX() + width, getY()+ height);
        g.drawLine(getX() + width/2, getY(),getX()  + width, getY() + height);
        g.drawLine(getX(), getY() + height, getX() + width/2 ,getY());
    }   
}
