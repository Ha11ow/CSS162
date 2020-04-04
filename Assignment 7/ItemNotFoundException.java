
/**
 * Write a description of class ItemNotFoundException here.
 * 
 * @author (your name) 
 */
public class ItemNotFoundException extends Exception
{
    /**
     * constructor with empty parameters will give pre made message
     */
    public ItemNotFoundException(){ 
        super("Item Not Found");
    }
    
    /**
     * constructor with a String message
     * @param String message
     */
    public ItemNotFoundException(String message){
        super(message);
    }
}
