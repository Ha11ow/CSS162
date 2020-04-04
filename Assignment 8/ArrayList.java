import java.util.*;
/**
 * This is an instance of a generic iterable array list 
 * 
 * @author (Behnam Khabazan) 
 */

public class ArrayList <T1>  implements Iterable

{
    private T1[] arrayList = (T1[]) new Object [0];
    private int counter = 0;


    public Iterator<T1> iterator(){
        return Arrays.asList(arrayList).iterator();
    }
    
    /**
     * The insert method will be able to insert an element at any correct index
     * Will not be able to add at higher than 1 index
     * @param element      The element that will be inserted
     * @param index         The index for the element inserted
     */ 
    public void insert(T1 element, int index){
        try {
            if(index == counter){
                T1[] temp = this.arrayList;
                this.arrayList = (T1[]) new Object[temp.length + 1];
                for (int i = 0; i < temp.length; i++){
                    arrayList[i] = temp[i];
                }
                arrayList[index] = element;
                counter++;
            }
            else if (index < counter){
                arrayList[index] = element;
            }
            else {
                throw new Exception("Index Number does not match, please add by 1");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * The add method will add to the end of the array
     * @param element      The element that will be inserted
     * */
    public void add(T1 element){
        T1[] temp = this.arrayList;
        this.arrayList = (T1[]) new Object[temp.length + 1];
        for (int i = 0; i < temp.length; i++){
            arrayList[i] = temp[i];
        }
        arrayList[counter++] = element;
    }

    /**
     * This class will remove and return an element at the given index
     * There is a boundary check for the index
     * @param index		The index that the element will be removed from
     * @return retVal	The element at the given index
     */
    public T1 remove(int index){
        T1 retVal = null;
        try {
            if(index < this.arrayList.length && index >= 0){
                retVal = arrayList[index];
                
                //will divide into 2 parts, copy everything but the index, and replace again
				T1[] Before = (T1[]) new Object[index];
                T1[] After = (T1[]) new Object[this.arrayList.length - (index + 1)]; 
                for(int i = 0; i < index; i++){
                    Before[i] = arrayList[i];
                }
                for(int i = 0; i < this.arrayList.length - (index + 1); i++){ 
                    After[i] = arrayList[i + index + 1];
                }
                
                //replacing and creating a new array
                arrayList = (T1[]) new Object[counter]; 
                for(int i = 0; i < index; i++){
                    arrayList[i] = Before[i];
                }
                for(int i = 0; i < this.arrayList.length - 1 - (index); i++){
                    arrayList[i + index] = After[i];
                }
                counter--;
            }
            else {
                throw new Exception("The given index was not in the array");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return retVal;
    }

    /**
     * Will return the size of the list
     * @return this.counter		returns the length of the list
     */
    public int size(){
        return this.counter;
    }

    /**
     * A boolean indicator to see if the list is empty 
     */
    public boolean isEmpty(){
        if (this.counter == 0){
            return true;
        }
        return false;
    }

    /**
     * indexOf method will the index to the entered element if it exists in the list
     * @return index    	The index of the given element
     * @param element		The element that will be searched through the list
     */
    public int indexOf(T1 element){
        for (int i = 0; i < this.counter; i++){
            if (element.equals(this.get(i))){
                return i;
            }
        }
        return -1;
    }

    /**
     * Overriding the equals method to match each list to another
     * @param other			The parameter can be any object
     * @return boolean		Depending on if the object is equal to the list (true if they are equal)
     */
    @Override
    public boolean equals(Object other){
        int counter = 0;
        if (other instanceof ArrayList){
            if (this.size() == ((ArrayList) other).size()){
                for (int i = 0; i < this.size(); i++){
                    if (this.get(i).equals(((ArrayList)other).get(i))){
                        counter++;
                    }
                }
            }
            if (counter == this.size()){
                return true;
            }
        }
        return false;
    }

    /**
     * Will return an object at the given index
     * @param index 	The index to return the object
     * @return object 	The object that must be returned
     */
    public T1 get(int index){
        T1 retVal = null;
        try {
            if(index < this.arrayList.length && index >= 0){
                retVal = (arrayList[index]);
            }
            else {
                throw new Exception("Not the correct index");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return retVal;
    }
    
    /**
     * Will swap the two objects at the given index
     * @param index1 	The first object	
     * @param index2	The second Object
     */
    public void swap(int index1, int index2){
        T1 temp = arrayList[index1];
        arrayList[index1] = arrayList[index2];
        arrayList[index2] = temp;
    }

    /**
     * Overriding the toString to print out through out the array
     * @return retVal		is the combined string for all the elements
     */
    @Override
    public String toString() {
        String returnString = "";
        for (int i = 0; i < counter; i++){
            returnString += i+1 + ") " + arrayList[i] + "\n"; 
        }
        return returnString;
    }    
}

