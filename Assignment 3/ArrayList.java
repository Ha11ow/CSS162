
/**
 * This is a copy of the arrayList but instead of being a generic class, it only takes in objects
 * 
 * @author (Ben Khabazan) 
 */
public class ArrayList
{
    private Object[] list;
    public ArrayList(){
        list = new Object[0]; //starting with zero cause its resizeable 
    }

    /**
     * The insert method will be able to insert an element at any correct index
     * Will not be able to add at higher than 1 index
     * @param other      The element that will be inserted
     * @param index         The index for the element inserted
     */
    public void insert(Object other, int index){
        try{
            if (index == list.length){
                Object[] temp = list;
                list = new Object[temp.length + 1];
                for (int i = 0; i < temp.length; i++){
                    list[i] = temp[i];
                }
                list[index] = other;
            }
            else if (index < list.length && index >= 0){
                Object[] temp = list;
                list = new Object[temp.length + 1];
                for (int i = 0; i < index; i ++){
                    list[i] = temp[i];
                }
                list[index] = other;
                for (int i = index; i < temp.length; i ++){
                    list[i+1] = temp[i];
                }
            }
            else {
            	Object[] temp = list;
            	list = new Object[index + 1];
            	for (int i = 0; i < temp.length; i++) {
            		list[i] = temp[i];
            	}
            	for (int i = temp.length; i < index; i++) {
            		list[i] = "null";
            	}
            	list[index] = other;
            	
            	/*
                throw new IndexOutOfBoundsException("The Index Can Only Be Bigger than the size by 1");
                */
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * This class will remove and return an element at the given index
     * There is a boundary check for the index
     * @param index		The index that the element will be removed from
     * @return retVal	The element at the given index
     */
    public Object remove(int index){
        Object retVal = null;
        try{
            if (index < list.length && index >= 0){
                Object[] temp = list;
                list = new Object[temp.length - 1];
                for (int i = 0; i < index; i ++){
                    list[i] = temp[i];
                }
                retVal = temp[index] ;
                for (int i = index; i < list.length; i ++){
                    list[i] = temp[i + 1];
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
     * Will return the size of the list
     * @return list.length		returns the length of the list
     */
    public int size(){
        return list.length;
    }

    /**
     * Overriding the toString to print out through out the array
     * @return retVal		is the combined string for all the elements
     */
    public String toString(){
        String retVal = "";
        for (int i = 0; i < list.length; i++){
            retVal += i+1 + ") " + list[i].toString() + "\n";
        }
        return retVal;    
    	
    }

    /**
     * A boolean indicator to see if the list is empty 
     */
    public boolean isEmpty(){
        if (list.length == 0){
            return true;
        }
        return false;
    }
    
    /**
     * indexOf method will the index to the entered element if it exists in the list
     * @return index    	The index of the given element
     * @param other			The element that will be searched through the list
     */
    public int indexOf(Object other){
        for (int i = 0; i < list.length; i++){
            if (other == list[i]){
                return i-1;
            }
        }
        return - 1;
    }
    
    /**
     * get Method will find and element attached to the given index and return in
     * @param index		The index given to find the element
     * @return Object	The object that will be returned 
     */
    public Object get(int index){
        Object retVal = null;
        try{
            if (index < list.length && index >= 0){
                retVal = list[index];
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
     * Overriding the equals method to match each list to another
     * @param other			The parameter can be any object
     * @return boolean		Depending on if the object is equal to the list (true if they are equal)
     */
    public boolean equals(Object other){
        if (other instanceof ArrayList){
            if (((ArrayList)other).size() == this.list.length){
                for (int i = 0; i < list.length; i++){
                    if (this.list[i] != ((ArrayList)other).get(i)){
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
