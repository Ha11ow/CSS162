import java.util.*;
/**
 * this class is an instance of an arraylist which you can add any objects
 * into until you run out of memory
 * 
 * @author (Behnam Khabazan) 
 * @version (12017)
 */

public class ArrayList <T1>

{
    /*
     * this is the original array where we store the objects
     */
    private T1[] arrayList = (T1[]) new Object [0];
    private int counter = 0; //number of elements stored in an array at any time

    /**
     * the insert method will:
     *      1- take in an element and an index number
     *      2- check to see if the index is bigger or equal
     *      3- if it is equal, it will get one size bigger.if less then replace,
     *          if bigger fail. 
     *      4- it will add the element to the index given
     *      5- if given an index used, it will work like a real array list and replace 
     *          that index with new one
     *  @param Obeject element
     *  @param int index
     */ 
    public void insert(T1 element, int index){
        try {
            if(index == counter){ //if it is equal, then it will add one to the size, and add the given object
                T1[] temp = this.arrayList;
                this.arrayList = (T1[]) new Object[temp.length + 1];
                for (int i = 0; i < temp.length; i++){
                    arrayList[i] = temp[i];
                }
                arrayList[index] = element;
                counter++;
            }
            else if (index < counter){// if it is smaller it will just replace the item without adding to counter
                arrayList[index] = element;
            }
            else {//if the index is not correct, it will crash (due to null pointers afterwards
                throw new Exception("Index Number does not match, please add by 1");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void add(T1 element){
        T1[] temp = this.arrayList;
        this.arrayList = (T1[]) new Object[temp.length + 1];
        for (int i = 0; i < temp.length; i++){
            arrayList[i] = temp[i];
        }
        arrayList[counter++] = element;
    }

    /**
     * the remove methods will return the given index, and remove it from the list
     * @param int index
     * @return Object (at that index)
     */
    public T1 remove(int index){
        T1 retVal = null; //for error handling and initilizing
        try {
            if(index < this.arrayList.length && index >= 0){ //if the index exists in the.
                retVal = arrayList[index]; //save the value of the index for returning
                //so What I do next is confusing af. 
                // I divide the array into 2, one starts before the index, and one starts after the index
                // this way, no matter what the index is, I can store everything correctly
                T1[] temp1 = (T1[]) new Object[index]; //this temperrory array holds the value of everything before
                T1[] temp2 = (T1[]) new Object[this.arrayList.length - (index + 1)]; //this holds everything after
                for(int i = 0; i < index; i++){ //I copy values from before index over to temp 1
                    temp1[i] = arrayList[i];
                }
                for(int i = 0; i < this.arrayList.length - (index + 1); i++){ // I copy everything after to temp 2
                    temp2[i] = arrayList[i + index + 1];
                }
                arrayList = (T1[]) new Object[counter]; //then I resize my array to the size of the counter
                for(int i = 0; i < index; i++){ //i copy everything back from 0 to index
                    arrayList[i] = temp1[i];
                }
                for(int i = 0; i < this.arrayList.length - 1 - (index); i++){ //then i copy everything but replace the index
                    arrayList[i + index] = temp2[i];
                }
                counter--; //reduce counter size beacuse the values are decreasing
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

    /*
     * this basically returns the size of array
     * @return int of size
     */
    public int size(){
        return this.counter;
    }

    /*
     * if the array is emthy this boolean method will return true
     * else it will return false
     * @beelean isEmpty 
     */
    public boolean isEmpty(){
        if (this.counter == 0){
            return true;
        }
        return false;
    }

    /*
     * this method will take in an object, and look through the array 
     *      and return its index
     * else, it will return -1
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
     * @param Object other
     * @return boolean
     * The equals method will take in an object, and cast it to the correct type
     * then it will see if the size and values inside are equal to the current list
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
     * @param int index
     * @return object at that point
     * this getter will return the element for the index given if index is given correctly
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
    
    public void swap(int index1, int index2){
        T1 temp = arrayList[index1];
        arrayList[index1] = arrayList[index2];
        arrayList[index2] = temp;
    }

    /**
     * @return String value
     * the two string will return all the values with a number in front of them
     */
    @Override
    public String toString() {
        String returnString = ""; //declaring a string that holds all values
        for (int i = 0; i < counter; i++){
            returnString += i+1 + ") " + arrayList[i] + "\n"; //adding to the string
        }
        return returnString;
    }

    public static void main(String[] args) {
        //todo: make more tests here
        ArrayList<String> a = new ArrayList<String>();

        a.insert("B", 0);
        a.insert("a",0);
        a.insert("t",1);
        a.insert("D",2);
        a.insert("4",3);

        System.out.println(a.toString());

        ArrayList<Integer> b = new ArrayList<Integer>();
        b.insert(1, 0);
        b.insert(2,0);
        b.insert(3,1);
        b.insert(4,2);
        b.insert(5,3);

        ArrayList<Integer> c = new ArrayList<Integer>();
        c.insert(1, 0);
        c.insert(2,0);
        c.insert(3,1);
        c.insert(4,2);
        c.insert(5,3);

        System.out.println(b.equals(c));
        System.out.println(b.equals(a));

        System.out.println(a.indexOf("D"));
        while(a.isEmpty() == false) {
            System.out.println(a.remove(0));
        }

        System.out.println(a.size());
        System.out.println(a.toString());

    }
}

