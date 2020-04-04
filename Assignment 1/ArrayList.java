
/**
 * This is an abstract data type of list, very similar to an array but unlimited
 * 
 * @author (Ben Khabazan) 
 */
public class ArrayList
{
    private Object[] myList;
    public ArrayList(){
        myList = new Object[0];
    }

    /**
     * This method will take in an index with an object and store the object
     * at the given index if that index matches the size of the array
     * @param Object other      the given object that will be stored
     * @param int index         this is the index that the object will be stored
     */
    public void insert(Object other, int index){
        try{
            if (index == myList.length){
                Object[] temp = myList;
                myList = new Object[temp.length + 1];
                for (int i = 0; i < temp.length; i++){
                    myList[i] = temp[i];
                }
                myList[index] = other;
            }
            else if (index < myList.length && index >= 0){
                Object[] temp = myList;
                myList = new Object[temp.length + 1];
                for (int i = 0; i < index; i ++){
                    myList[i] = temp[i];
                }
                myList[index] = other;
                for (int i = index; i < temp.length; i ++){
                    myList[i+1] = temp[i];
                }
            }
            else {
                throw new IndexOutOfBoundsException("The Index Can Only Be Bigger than the size by 1");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void add(Object other) {
    	Object[] temp = myList;
        myList = new Object[temp.length + 1];
        for (int i = 0; i < temp.length; i++){
            myList[i] = temp[i];
        }
        myList[temp.length] = other;
    }
    

    /**
     * This Method will remove the object in the array if the given index
     * is accepted by the invarients
     * @param int index
     * @return Object      the object stored in the ADT
     */
    public Object remove(int index){
        Object retVal = null;
        try{
            if (index < myList.length && index >= 0){
                Object[] temp = myList;
                myList = new Object[temp.length - 1];
                for (int i = 0; i < index; i ++){
                    myList[i] = temp[i];
                }
                retVal = temp[index] ;
                for (int i = index; i < myList.length; i ++){
                    myList[i] = temp[i + 1];
                }

            }
            else {
                throw new IndexOutOfBoundsException("Cannot find the given index");
            }
        }catch(IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        return retVal;
    }

    /**
     * This method will return the size of the list
     * @return int      size of the list
     */
    public int size(){
        return myList.length;
    }

    /**
     * Will print the toString
     * @return String retVal
     */
    public String toString(){
        String retVal = "";
        for (int i = 0; i < myList.length; i++){
            retVal += i+1 + ") " + myList[i] + "\n";
        }
        return retVal;        
    }

    /**
     * boolean to check to see if the array is empty
     * @return boolean
     */
    public boolean isEmpty(){
        if (myList.length == 0){
            return true;
        }
        return false;
    }

    /**
     * will return the index of the object given
     * @return int      index of the object
     * @param Object other  the Object that we need the index of
     */
    public int indexOf(Object other){
        for (int i = 0; i < myList.length; i++){
            if (other == myList[i]){
                return i;
            }
        }
        return - 1;
    }

    /**
     * will get the objects index that is given
     * @param int index     index of the object needed
     * @return Object       at index
     */
    public Object get(int index){
        Object retVal = null;
        try{
            if (index < myList.length && index >= 0){
                retVal = myList[index];
            }
            else{
                throw new IndexOutOfBoundsException("Cannot find the given index");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return retVal;
    }

    /**
     * checks to see if the object passed in is equal to the List
     * @param Object other      can be any object
     * @return boolean          if true, then the are equal
     */
    public boolean equals(Object other){
        if (other instanceof ArrayList){
            if (((ArrayList)other).size() == this.myList.length){
                for (int i = 0; i < myList.length; i++){
                    if (this.myList[i] != ((ArrayList)other).get(i)){
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
    public static void main(String[] Args){
        ArrayList myList = new ArrayList();
        ArrayList otherList = new ArrayList();

        int a = 1;
        int b = 2;
        int c = 3;
        
        myList.add(a);
        myList.add(b);
        myList.add(c);
        
        System.out.println((int)myList.get(0) == 1);

        System.out.println(myList);


        System.out.println("Is it empty " + myList.isEmpty());
        myList.insert(a,0);
        myList.insert(b,0);
        myList.insert(c, 2);

        otherList.insert(a,0);
        otherList.insert(b,0);
        otherList.insert(c,2);

        System.out.println("are the two lists equal " 
            + myList.equals(otherList));

        otherList.insert(b,2);

        System.out.println("are the two lists equal " 
            + myList.equals(otherList));

        otherList.remove(2);
        otherList.remove(2);
        otherList.insert(a,2);

        System.out.println("are the two lists equal " 
            + myList.equals(otherList));

        System.out.println(myList);
        System.out.println("index of a " + myList.indexOf(a));
        System.out.println("get index of 2 " + myList.get(1));
        System.out.println("Is it empty " + myList.isEmpty());
        System.out.println("index of 1" + myList.indexOf(1));
        System.out.println("the size " + myList.size());
        System.out.println("removed " + myList.remove(0));
        System.out.println("removed " + myList.remove(0));

        System.out.println(myList);

        System.out.println("removed " + myList.remove(0));

        System.out.println("|||||||||||||||Faulty|||||||||||||||");
        String ab = "error";

        myList.insert(ab,3);
        myList.insert(a, 3);

        myList.indexOf(ab);
        myList.insert(ab, -1);
        myList.get(0);
    }
}
