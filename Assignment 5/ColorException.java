
/**
 * Write a description of class PermanentHire here.
 * 
 * @author (Ben Khabazan) 
 * @version (020717)
 */
public class ColorException extends RuntimeException
{
   
    /**
     * Constructor for objects of class ColorException
     * @overload ColorException()
     */
    public ColorException()
    {
        super ("An error occurred in Color");
    }

    /**
     * @overload ColorException
     */
    public ColorException(String message){
        super(message);
    }

    /**
     * 
     */
    public static void main(String[] args){
        throw new ColorException("A test in main");
    }
}
