
/**
 * A copy of the Queue class, but only takes in objects instead of being generic
 * First in, first out
 * 
 * @author (Ben Khabazan) 
 */
public class Queue
{
    private Object[] queue = new Object[0];

    /**
     * A enqueue method to insert an object to the list
     * @Parm other		The object that needs to be added to the queue
     */
    public void enqueue(Object other){
        Object[] temp = queue;
        queue = new Object[temp.length + 1];
        for (int i = 0; i < temp.length; i++){
            queue[i] = temp[i];
        }
        queue[queue.length-1] = other;
    }

    /**
     * The only way to remove items from the queue is to dequeue
     * Will remove from the first index of the array
     * @return Object		First Object inserted 
     */
    public Object dequeue(){
        Object[] temp = queue;
        this.queue = new Object[temp.length-1];
        for (int i = 0; i < this.queue.length; i++){
            queue[i]= temp[i+1];
        }
        return temp[0];
    }

     /**
     * The size method will return the size of the queue
     * @return size 	will return the size of the queue based on the array used
     */
    public int size(){
        return this.queue.length;
    }

    /**
     * A method to check to see if the queue is empty
     * @return boolean
     */
    public boolean isEmpty(){
        if (queue.length == 0){
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
        return queue[index];
    }

    /**
     * Overriding the equals method to match each queues to another object
     * @param other			The parameter can be any object
     * @return boolean		Depending on if the object is equal to the queue(true if they are equal)
     */
    public boolean equals(Object other){
        if (other instanceof Queue){
            if (((Queue)other).size() == this.queue.length){
                for (int i = 0; i < queue.length; i++){
                    if (this.queue[i] != ((Queue)other).get(i)){
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Overriding the toString to print out through out the array
     * @return retVal		is the combined string for all the elements
     */
    public String toString(){
        String retVal ="";
        for (int i = 0; i < queue.length; i++){
            retVal += i + 1 + ") " + queue[i]+ "\n";
        }
        return retVal;
    }
}
