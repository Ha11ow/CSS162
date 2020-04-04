import java.io.File;
/**
 * This class will find a file based on the given directory and the target name
 * using recursion.
 * 
 * @author (Behnam Khabazan)
 */
public class FindFile
{
    private int count;
    private String[] files; 
    private final int MAX_NUMBER_OF_FILES_TO_FIND;

    /**
     * The FindFile constructor will initialize the max number of files to find
     * @param MAX_NUMBER_OF_FILES_TO_FIND 
     */
    FindFile(int MAX_NUMBER_OF_FILES_TO_FIND){
        this.MAX_NUMBER_OF_FILES_TO_FIND = MAX_NUMBER_OF_FILES_TO_FIND;
        this.count = 0;
        files = new String[MAX_NUMBER_OF_FILES_TO_FIND];
    }

    /**
     * directorySearch method will use recursion to find the target in the directory given,
     * 		but is limited to the max number set in the constructor
     * Will check to see if any of the imported items are empty, then will proceed to creating a new file
     * 		and finding everything in there, if it is true, and the list is not empty, 
     * 		it will loop through the list, and create a file named fil, and will 
     * 		repeat the same process if fil is a directory, else it would check to see 
     * 		if it matches the target name, and if it does, it will check to see if it has
     * 		exceeded the max number set above, if not it stores the location, and ups the count
     * @param String target
     * @param String dirName
     */
    public void directorySearch(String target, String dirName) throws IllegalArgumentException {
        if (dirName != null && target !=null) {
            
            File f = new File(dirName);
            File[] list = f.listFiles();
            if (f.exists() && list != null){
                for (File fil : list)
                {
                    if (fil.isDirectory())
                    {
                        directorySearch(target, ""+fil); 
                    }
                    if (target.equalsIgnoreCase(fil.getName()))
                    {
                        if (count < MAX_NUMBER_OF_FILES_TO_FIND){
                            files[count++] = fil.getParentFile().getPath() + "\\" + fil.getName();
                        }
                        else {
                            throw new IllegalArgumentException("Number of files found has exceeded the Max Files given");
                        }   
                    }
                }
            }
            else {
                throw new IllegalArgumentException("Either file doesnt exist or there is nothing in the folder");
            }
        }
        else {
            throw new IllegalArgumentException("Target and directory name cannot be empty");
        }
        
    }
    
    /**
     * Will return the number of times the target has been found
     * @return count
     */
    public int getCount(){
        return this.count;
    }

    /**
     * Will find the directory of each target that has been found
     * @return result
     */
    public String[] getFiles(){
        if (count == MAX_NUMBER_OF_FILES_TO_FIND){
            String[] result = new String[MAX_NUMBER_OF_FILES_TO_FIND];
            for(int i = 0; i < MAX_NUMBER_OF_FILES_TO_FIND; i++){
                result[i] = files[i];
            }
            return result;
        }
        else {
            String[] result = new String[count];
            for(int i = 0; i < count; i++){
                result[i] = files[i];
            }
            return result;
        }
    }
}