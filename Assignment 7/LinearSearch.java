
/**
 * This class will search through the given list in the driver and 
 * find an intended word using recursion. 
 * THis class also extends SearchAlgorith and uses it as a base model
 * 
 * @author (Ben Khabazan)
 */
public class LinearSearch extends SearchAlgorithm
{
    /**
     * Overriding the search method in SearchAlgorithm to loop through and find the 
     * target.
     * Checks to see if the file is empty, then proceeds to reset the count if it was set before,
     * then goes in the loop covering the whole array of files,
     *  and checks to see if it can find the file.
     *  If the file is found, it will break the loop, and return -1 of the count
     * @param words
     * @param target
     * @return placement of the target
     */
    public int search(String[] words, String target) throws ItemNotFoundException
    {
        if (words != null){
            resetCount();
            for (int i = 0; i < words.length; i++){
                if(target.equals(words[i])){
                    break;
                }
                incrementCount();
            }
            if (getCount() == (words.length - 1)){
                throw new ItemNotFoundException();
            }
        }
        else{
            throw new ItemNotFoundException("empty array");
        }
        incrementCount();
        return getCount() -1;

    }

    /**
     * Overriding the recSearch method in SearchAlgorithm to recursively find the target
     * there are three if statements to start off this recursion, 
     * one to check if the array cap is reached
     * other to check to see if the word matches the selected word
     * then an else to recursively skip to the next word
     * @param words
     * @param target
     * @return placement of the target
     */
    public int recSearch(String[] words, String target) throws ItemNotFoundException
    {
    	if (getCount() == words.length - 1){
            throw new ItemNotFoundException("Not found in here");
        }
        if(target.equals(words[super.getCount()])){
            incrementCount();
            return getCount()-1;
        }
        else{ 
            incrementCount();
            recSearch(words, target);
        }
        
        return getCount()-1;
    }

}
