
/**
 * A copy of the stack class, but only takes in objects instead of being generic
 * First in last out.
 * 
 * @author (Ben khabazan)
 */
public class Stack
{
    private Object[] stack = new Object[0];

    /**
     * A push method to insert the objects in the stack
     * @Parm other		Objects that are being pushed into the stack
     */
    public void push(Object other){
        Object[] temp = stack;
        stack = new Object[temp.length + 1];
        for (int i = 0; i < temp.length; i++){
            stack[i] = temp[i];
        }
        stack[stack.length-1] = other;
    }

    /**
     * The only way to get the objects stored in the stack out
     * Will return as last in first out
     * @return Object		The last object pushed in the stack
     */
    public Object pop(){
        Object[] temp = stack;
        this.stack = new Object[temp.length-1];
        for (int i = 0; i < this.stack.length; i++){
            stack[i]= temp[i];
        }
        return temp[temp.length -1];
    }

    /**
     * The size method will return the size of the stack
     * @return size 	will return the size of the stack based on the array used
     */
    public int size(){
        return this.stack.length;
    }

    /**
     * A method to check to see if the stack is empty
     * @return boolean
     */
    public boolean isEmpty(){
        if (stack.length == 0){
            return true;
        }
        return false;
    }

    /**
     * will get the objects index that is given
     * private because its a helper method
     * @param int index     index of the object needed
     * @return Object       at index
     */
    private Object get(int index){
        return stack[index];
    }

    /**
     * Overriding the equals method to match each stack to another object
     * @param other			The parameter can be any object
     * @return boolean		Depending on if the object is equal to the stack (true if they are equal)
     */
    public boolean equals(Object other){
        if (other instanceof Stack){
            if (((Stack)other).size() == this.stack.length){
                for (int i = 0; i < stack.length; i++){
                    if (this.stack[i] != ((Stack)other).get(i)){
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Will print the toString
     * @return String retVal
     */
    public String toString(){
        String retVal ="";
        for (int i = stack.length-1; i >= 0; i--){
            retVal += i+1 + ") " + stack[i] + "\n";
        }
        return retVal;
    }
}
