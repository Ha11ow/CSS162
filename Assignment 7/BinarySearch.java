
/**
 * This class will search through the array of words using a loop and also with a 
 * recursive method in a binary matter.
 * 
 * @author (Ben Khabazan)
 */
public class BinarySearch extends SearchAlgorithm
{
    private int LowIndex; 
    private int HighIndex;
    private int MidIndex;

    /**
     * Overriding the search method to use a while loop to find the target
     * will set the low and high index to create a limitation
     * and while the limits have not reached one another, it will check to see
     * if the word in the middle of the limit compared to the target is higher lower, or equal
     * if smaller than 0, the lower index becomes one over the middle and the search continues
     * if bigger than 0, the high becomes one less than the middle and the search continues
     * of equal then break and return the middle index.
     * @param words
     * @param wordToFind
     * @return placement of the target
     */
    public int search(String[] words, String wordToFind) throws ItemNotFoundException
    {
        LowIndex = 0;
        HighIndex = words.length - 1;

        while (LowIndex <= HighIndex){
            MidIndex = (int)(HighIndex + LowIndex)/2;
            incrementCount();
            if (words[MidIndex].compareTo(wordToFind) < 0){
                LowIndex = MidIndex + 1;
            }
            else if (words[MidIndex].compareTo(wordToFind) > 0){
                HighIndex = MidIndex - 1;
            }
            else {
                return MidIndex;
            }
        }

        if (LowIndex > HighIndex){
            throw new ItemNotFoundException();
        }

        return -1;
    }

    /**
     * Overriding the recSearch method to find the target recursively
     * First we check to see if it is the first time we are going in the recursion,
     * and set the the low and high because we don't want to change them later on
     * Then we set the middle between the low and high,
     * and increment the count to show we have gone through
     * Then compare the middle word to the target, and 
     * if smaller than 0, the lower index becomes one over the middle and the recursion continues
     * if bigger than 0, the high becomes one less than the middle and the recursion continues
     * of equal then break and return the middle index.
     * @param words
     * @param wordToFind
     * @return placement of the target
     */
    public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException
    { 
        if (LowIndex > HighIndex){
            throw new ItemNotFoundException();
        }
        if (getCount() == 0){
            LowIndex = 0;
            HighIndex = words.length - 1;

        }
        MidIndex = (int)(HighIndex + LowIndex)/2;
        incrementCount();
        if (words[MidIndex].compareTo(wordToFind) < 0){
            LowIndex = MidIndex + 1;
            return recSearch(words, wordToFind);
        }
        else if (words[MidIndex].compareTo(wordToFind) > 0){
            HighIndex = MidIndex - 1;
            return recSearch(words, wordToFind);
        }
        else {
            return MidIndex;
        }

    }

}
