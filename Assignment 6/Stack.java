/**
 * an instance of stack with its main on the bottom of the class, 
 * it works like stack but using linklist
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stack extends List{
    /**
     * Since it does not make any sense to have the delete, its overriden to crash
     */
    public void delete(int index){
        try{
            throw new LinkedListException();//throws an exception to stop using
        }
        catch (Exception LinkedListException){
            System.out.println("Not valid method");
        }
    }

    /**
     * Since using the indexOf Does not make any sense, automatically throws -1
     */
    public int indexOf(Object otherData) {
        return -1; //returns -1 cause there are no indexes
    }

    /*
     * the insert just calls enqueue
     * (reason for that is I talked Dr.Lin about this and he said we can return -1)
     */
    /**
     * Since it does not make any sense to have the delete, its overriden to crash
     */
    public void append(Object data){
        try{
            throw new LinkedListException("Not Valid Mehotd");//cannot be used so throwing an exception
        }
        catch (Exception LinkedListException){
            System.out.println("Not valid method");
        }
    }

    /**
     * No matter what Index is inserted, the push works the same way
     */
    public void insert(Object data, int index){
        push(data);
    }

    /*
     * the push stores the data in order for the stack class specifically
     * it inserts it to the first index everytime for reasons of the toString
     */
    /**
     * this accepts nulls
     */
    public void push(Object data){
        super.insert(data, 0);
    }

    /**
     * No matter what Index is inserted, the pop works the same way
     */
    public Object remove(int index){
        return pop(); //calls the pop method
    }

    /**
     * pops (First in Last out) in the order
     * its 0 because the last is the head
     */
    public Object pop(){
        return super.remove(0);        
    }

    public static void main(String[] Args){
        Stack myStack = new Stack();
        myStack.push("Hello");
        myStack.push("Melon");
        myStack.push("Pen");
        myStack.push("Lemon");
        System.out.println(myStack.toString());

        System.out.println();
        myStack.pop();
        System.out.println(myStack.toString());

        myStack.push(null); // Exception is thrown
        System.out.println(myStack.toString());

        System.out.println();
        myStack.pop();
        myStack.pop();
        myStack.pop();
        System.out.println(myStack.toString());

        System.out.println();
        myStack.pop(); // Should throw an error since theres no more objects.
        System.out.println();

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.toString()); // 1 2 3
        myStack.pop();

        System.out.println();
        System.out.println(myStack.toString()); // 2 3
        Object nullItem = null;
        System.out.println();

        myStack.push(nullItem);
        System.out.println(myStack.toString()); // Exception is thrown
        System.out.println();

        // Testing invalid methods
        myStack.delete(0);
        myStack.append("YUH");
        System.out.println(myStack.indexOf(0));
        System.out.println(myStack.toString());
    }
}