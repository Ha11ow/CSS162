
/**
 * This is a Queue class made from link list.
 * 
 * @author (Ben Khabazan) 
 * @version (021617)
 */
public class Queue extends List
{
    /**
     * Since it does not make any sense to have the delete, its overriden to crash
     */
    public void delete(int index){
       try{
           throw new LinkedListException(); //throws an exception to stop using
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
    
    /**
     * Since it does not make any sense to have the delete, its overriden to crash
     */
    public void append(Object data){
        try{
           throw new LinkedListException(); //cannot be used so throwing an exception
        }
        catch (Exception LinkedListException){
            System.out.println("Not valid method");
        }
    }
    
    /*
     * the insert just calls enqueue
     * (reason for that is I talked Dr.Lin about this and he said we can return -1)
     */
    /**
     * No matter what Index is inserted, the enqueue works the same way
     */
    public void insert(Object data, int index){
        enqueue(data);
    }

    /*
     * the enqueue stores the data in order for the queue class specifically
     */
    /**
     * this accepts nulls
     */
    public void enqueue(Object data){
        super.insert(data, 0);//inserts it to the first index everytime (for tostring)
    }

    /**
     * No matter what Index is inserted, the dequeue works the same way
     */
    public Object remove(int index){
        return dequeue(); //calls the dequeue method
    }

    /*
     * this dequeues the last stored nodes, which is the first index put in
     */
    public Object dequeue(){
        return super.remove(size()-1);
    }

    public static void main(String[] Args){
        Queue myQueue = new Queue();
        
        

        myQueue.enqueue("A");
        myQueue.enqueue("B");
        myQueue.enqueue("C");
        myQueue.enqueue("D");
        myQueue.enqueue("E");
        
        
        
        System.out.println("\nErrors from methods that shouldnt work");
        myQueue.delete(1);
        myQueue.append("1");
        System.out.println(myQueue.indexOf("A"));
        System.out.println(myQueue);
        
        System.out.println("\nMethods that redirect to enqueue and dequeue");
        myQueue.insert("F",2);
        System.out.println(myQueue.remove(2));
        System.out.println(myQueue.toString());
        
        System.out.println("\nAdding to the end");
        myQueue.enqueue("G");
        
        System.out.println("\nRemoving from first");
        System.out.println(myQueue.dequeue());
        
        
        
        System.out.println("\n random tests");

        System.out.println(myQueue.toString());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.toString());
    }
}
