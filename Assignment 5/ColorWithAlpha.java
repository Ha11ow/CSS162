
/**
 * Write a description of class PermanentHire here.
 * 
 * @author (Ben Khabazan) 
 * @version (020717)
 */
public class ColorWithAlpha extends SimpleColor
{
    // instance variables - replace the example below with your own
    private int alpha;

    /**
     * Constructor for objects of class ColorWithAlpha
     */
    public ColorWithAlpha(int alpha)
    {
        super(0,0,0);
        setAlpha(alpha);
    }

    public ColorWithAlpha(int red, int green, int blue, int alpha){
        super(red, green, blue);// this calls the constructor of the parent

        setAlpha(alpha);
    }

    public ColorWithAlpha (ColorWithAlpha object){
        this(object.getR(),object.getG(),object.getB(),object.alpha);
    }

    public void setAlpha (int alpha ){
        try {
            if (alpha >= 0 && alpha <= 255){
                this.alpha = alpha; 
            }
            else {
                throw new ColorException();
            }
        }catch (Exception ColorException){
            System.out.println("Number is wrong");
        }
    }

    public String toString(){
        return "The value of the red is: " + getR() + " The value of the green is: " 
        + getG() + " The value of the blue is: " + getB() + " The value of alpha is: " + 
        this.alpha;
    }

    public boolean equals (ColorWithAlpha other){
        return getR() == other.getR() && this.getG() == other.getG() && this.getB() == other.getB() &&
        this.alpha == other.alpha;
    }
}
