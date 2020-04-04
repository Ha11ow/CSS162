
/**
 * This is a test handling class for the List class
 * 
 * @author (Ben Khabazan) 
 * @version (021617)
 */
public class PizzaException extends Exception
{
    /*
     * the normal constructure with no parameters
     */
    public PizzaException(){
        super();
    }
    
    /*
     * constructor with a String message
     */
    public PizzaException(String message){
        super(message);
    }
}
