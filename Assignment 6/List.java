
/**
 * This class works like an array list. However, it uses Link list to store the data
 * 
 * @author (Ben Khabazan)
 */
public class List extends LinkedListException
{
    private Node head = null; //starts the head with the null for link
    
    /*
     * The insert takes in two parameters, the object that will be inserted and the index that it will be stored in
     * @param Object next (the given object)
     * @param int index (the index that will be stored)
     */
    
    public void insert(Object next, int index) {
        try {
            if (index < 0 || index > size()) { //inverients
                throw new LinkedListException(); //throw an exception
            }
            else if (head == null || index == 0) { //will check to see if the first
                Node start = new Node (next);
                start.next = head;
                head = start;
            }
            else if (index <= size()) { //equal to add one to the end using insert
                Node temp = head;
                Node after;
                for (int count = 0; count < (index -1); count++){//goes to the needed linked
                    temp = temp.next;
                }
                after = temp.next; //sets everything of that index and equal and after to variable after
                temp.next = new Node(next);//changes the next node
                temp.next.next = after; //sets the node after node to after
            }
        }
        catch (Exception LinkedListException) {
            System.out.println("Given index is out of bounds."); //will print this for errors
        }
    }

    /*
     * Append only adds to the end of the list unless the list is empty, then it will make the first element the given object
     * @param Object data (the data that will be going to the end)
     * 
     */
    public void append(Object data){
        if (head == null){ //if empty then add to the first
            Node start = new Node (data);
            start.next = head;
            head = start;
        }
        else{
            Node temp = head;
            Node after;
            for (int count = 0; count < (size() - 1); count++){
                temp = temp.next;
            }
            after = temp.next;
            temp.next = new Node(data);
            temp.next.next = after;
        }
    }

    /*
     * Checks the size for the list
     * @return counter which is the size
     */
    
    public int size(){
        int counter = 0;
        Node temp = head;
        while (temp != null){
            counter++;
            temp = temp.next;
        }
        return counter;
    }

    /*
     * deletes the given index in the parameter, but does not return anything
     * @param int index (the index that will be removed)
     * has try catch for wrong input for the index
     */
    public void delete(int index){
        try{
            if (index == size()-1 && size() >= 2){ //if the last element and size is bigger or equal to 2
                Node temp = head;
                Node after;
                for (int i = 0; i < size() - 2; i++){//finds 1 element b4 the target
                    temp = temp.next;
                }
                after = temp.next.next;
                temp.next = after;
            }
            else if(index == 0 && size() == 1){//if the index is 0 and size is 1
                head = null; //then just make the head 0
                }
            else if(index == 0){ //if looking at the head
                head = head.next; //then link the head to the next node
                }
            else if (index > 0 && index < size() - 1){//normal inveriants
                Node temp = head;
                Node after;
                for (int i = 0; i < (size() - 2) - index; i++){
                    temp = temp.next;
                }
                after = temp.next.next;
                temp.next = after;
            }
            else {
                throw new LinkedListException();
            }
        }catch(Exception LinkedListException){
            System.out.println("Index Must be valid");
        }
    }
    
    /*
     * removes the given index and returns the object from that method
     * this is the same as above but returns object lol, just look at the ones above
     * @param int index (removed index)
     * @return retVal (returns the object from that node)
     */
    public Object remove(int index) {
        Object retVal = null;
        try{
            if (index == size()-1 && size() >= 2){
                Node temp = head;
                Node after;
                for (int i = 0; i < size() - 2; i++){
                    temp = temp.next;
                }
                retVal = temp.next.data;
                after = temp.next.next;
                temp.next = after;
            }
            else if(index == 0 && size() == 1){
                retVal = head.data;
                head = null;
                }
            else if(index == 0){
                retVal = head.data;
                head = head.next;
                }
            else if (index > 0 && index < size() - 1){
                Node temp = head;
                Node after;
                for (int i = 0; i < (size() - 2) - index; i++){
                    temp = temp.next;
                }
                retVal = temp.next.data;
                after = temp.next.next;
                temp.next = after;
            }
            else {
                throw new LinkedListException();
            }
        }catch(Exception LinkedListException){
            System.out.println("Index Must be valid");
        }
        return retVal;
    }

    /**
     * will return the value for the index given
     * @param int index
     * @return Object retVal
     */
    public Object get(int index){
        Object retVal = null;
        try{
            if(index >= 0 && index < size()){
                Node temp = head;
                for (int i = 0; i < (size() - 2) - index; i++){
                    temp = temp.next;
                }
                retVal = new Appointment(temp.data);
                return retVal;
            }
            else {
                throw new LinkedListException();
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return retVal;
    }
    
    /**
     * Will return -1 if not found
     */
    public int indexOf(Object otherData){
        Node temp = head;
        int index = -1;
        for (int i = 0; i < size(); i++){
            if(otherData == temp.data){
                index = i;
            }
            temp = temp.next;
        }
        return index;
    }

    /*
     * checks to see if the list is empty
     * @return boolean
     */
    public boolean isEmpty() { 
        return (head == null);//if the head is null then turns true
    }

    /*
     * prints out all the stored Nodes
     * @return String retStreing (the value that is stored from going throught the Nodes
     */
    public String toString(){
        String retString = "";
        Node temp = head;
        while (temp != null){ //till it reaches the tail
            retString += (temp);
            temp = temp.next;
        }
        return retString;
    }

    /*
     * this is the Node class created inside of the List Class
     */
    public class Node
    {
        private Object data; //data that is stored
        private Node next; //next Node that will be linked

        public Node(Node other){
            this.data = other.data;
            this.next = other.next;
        }

        public Node(Object data){
            this.data = data;
        }

        public String toString(){
            return this.data + " ";
        }
    }
}

