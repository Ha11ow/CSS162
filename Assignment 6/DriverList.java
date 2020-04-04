/**
 * This class is the driver to test the List class
 * 
 * Author("Ben Khabazan")
 * Version(021617)
 */public class DriverList {
    public static void main(String[] args) {
        List empty = new List();
        List one = new List();
        List multiple = new List();

        one.append(5);
        multiple.append(10);
        multiple.append(20);
        multiple.append(30);

        /*
         * this is to cehck the sizes and the toStrings
         */
        System.out.println("Size multiple: " + multiple.size());
        System.out.println("Size One: " + one.size());
        System.out.println("Empty: "+empty);
        System.out.println("One: "+one);
        System.out.println("Multiple: "+ multiple); 

        one.delete(0);
        multiple.delete(1);
        System.out.println("One (upon delete): "+one);
        System.out.println("Multiple (upon delete): "+ multiple);
        
        /*
         * check some of the errors
         */
        System.out.println("Errors");
        multiple.delete(5);
        one.insert(600, 1);
        one.insert(600,-1);
        multiple.remove(5);
        
        System.out.println("\n");
        
        
        System.out.println("index of multiple "+ multiple.indexOf(10));
        System.out.println("index of multiple "+ multiple.indexOf(20));
        System.out.println("index of multiple "+ multiple.indexOf(30));
        
        System.out.println("\n");
        
        System.out.println("Is empty multiple "+ multiple.isEmpty());
        System.out.println("Is empty empty "+ empty.isEmpty());
        
        System.out.println("\n");
        
        multiple.insert(400, 2);
        System.out.println("One (on insert):"+one);
        System.out.println("Multiple(on insert):"+ multiple);
    }

}
