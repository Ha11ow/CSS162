import java.util.Scanner;
  
/**
 * This is the pizza manager (driver for the vending machine)
 * Will have user interface and test everything
 * 
 * @author (Ben Khabazan) 
 * @version (31117)
 */

public class PizzaManager {
    /*
     *  TODO: Data definitions here.  
     */
    ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
    Fraction pizzaFraction = new Fraction();

    /** 
     * The console interface is defined in the start method 
     * You can exit or extend the code below to accomplish all of 
     * the outcomes defined in the homework document
     */
    public void start() throws PizzaException {
        char selection='q';

        Scanner foo = new Scanner(System.in);

        while(true) {
            displayInstructions();

            selection = foo.next().charAt(0); 
            switch(selection) {
                case 'A':    
                case 'a':    System.out.println("Adding a random pizza to the ArrayList<Pizza>.");
                //todo:     
                addRandomPizza();
                displayAllPizzas();
                break;

                case 'H':    
                case 'h':    System.out.println("Adding one hundred random pizzas to the ArrayList<Pizza>.");
                //todo:
                for(int i = 0; i < 100; i++) {
                    addRandomPizza();
                }
                displayAllPizzas();
                break;  

                case 'E':    
                case 'e':    System.out.println("Eating a fraction of a pizza. How much? (a/b)");
                //todo:pizza eating code here
                Scanner Inputs = new Scanner(System.in);
                // Takes the fraction as a string.
                String InputFrac = Inputs.next();
                // Split the fraction and store them into values.
                String [] splitFraction = String.valueOf(InputFrac).split("/");
                int fractionNumerator = Integer.valueOf(splitFraction[0]);
                int fractionDenominator = Integer.valueOf(splitFraction[1]);

                System.out.println("Which index would you like the pizza to be eaten?");
                int userIndex = Inputs.nextInt();
                eatSomePizza(new Fraction(fractionNumerator, fractionDenominator), userIndex);
                displayAllPizzas();
                break;    

                case 'P':    
                case 'p':     System.out.println("Sorting pizzas by (P)rice");
                //todo:
                sortByPrice();
                displayAllPizzas();
                break;    
                case 'S':    
                case 's':     System.out.println("Sorting pizzas by (S)ize");
                //todo:
                sortBySize();
                displayAllPizzas();
                break;          
                case 'C':    
                case 'c':      System.out.println("Sorting pizzas by (C)alories");
                //todo
                sortByCalories();
                displayAllPizzas();
                break;
                case 'B':
                case 'b':    System.out.println("(B)inary search over pizzas by calories(int).  Sorting first.  What calorie count are you looking for?");
                //todo:
                Scanner Inputs2 = new Scanner(System.in);
                int newCalorie = Inputs2.nextInt();
                int resultIndex = binarySearchByCalories(newCalorie);
                if (newCalorie < 0) {
                    System.out.println("Invalid calories to look for pizza.");
                }
                else {
                    System.out.println("Pizza with calorie " + newCalorie + "\n" + pizzas.get(resultIndex));
                }
                displayAllPizzas();
                break;
                case 'Q':
                case 'q':    System.out.println("(Q)uitting!" );
                //todo:
                System.exit(0);
                break;
                default:    System.out.println("Unrecognized input - try again");
            }
        }

    }

    /**
     * creates and adds a new pizza
     */
    private void addRandomPizza() {
        pizzas.add(new Pizza());
    }

    /**
     * basic display of all the pizzas
     * 
     */
    private void displayAllPizzas() {
        for (int i = 0; i < pizzas.size(); i++) {
            int counter = i + 1;
            if (pizzas.get(i) == null) {
                System.out.println("There is currently no pizza.");
                break;
            }
            else {
                System.out.println(counter + ") " + pizzas.get(i));
            }
        }
    }

    /**
     * This method will sort the array of pizzas by the calories
     * 
     */
    private void sortByCalories() {
        //todo:
        for (int i = 0; i < pizzas.size() - 1; i++) {
            for (int counter = i + 1; counter < pizzas.size(); counter++) {
                if (pizzas.get(i).getCalories() > pizzas.get(counter).getCalories()) {
                    pizzas.swap(i, counter);
                }
            }
        }
    }

    /**
     * This method will sort the array by the price of all the pizza
     * 
     */
    private void sortByPrice() {  
        //todo:
        for (int i = 0; i < pizzas.size() - 1; i++) {
            for (int counter = i + 1; counter < pizzas.size(); counter++) {
                Pizza newPizza1 = pizzas.get(i);
                Pizza newPizza2 = pizzas.get(counter);
                if (newPizza1.getCost().compareTo(newPizza2.getCost()) > -1) {
                    pizzas.swap(i, counter);
                }
            }
        }
    }

    /**
     * This method will sort the array by the size of all the pizzas
     * 
     */
    private void sortBySize() {
        //todo:
        for (int i = 0; i < pizzas.size() - 1; i++) {
            for (int counter = i + 1; counter < pizzas.size(); counter++) {
                Pizza newPizza1 = pizzas.get(i);
                Pizza newPizza2 = pizzas.get(counter);
                if (newPizza1.compareToBySize(newPizza2) > -1) {
                    pizzas.swap(i, counter);
                }
            }
        }
    }

    /**
     *This will eat some of the pizza
     *it will reduce from the pizza
     *@param Fraction 
     *@int index
     */
    private void eatSomePizza(Fraction other, int index) throws PizzaException {
        //todo:
        try {
            if(other == null || !(other instanceof Fraction)) {
                throw new PizzaException("Invalid fraction to eat from.");
            }
            pizzas.get(index).eatSomePizza(other);
            if(pizzas.get(index).getFraction().getNumerator() == 0) {
                pizzas.remove(index);
            }
        }
        catch (PizzaException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * This method will do a complete binary search over the list of pizzas and search for
     * the imported calorie
     * if there are no matching pizzas it will return -1
     * @param int other
     */
    private int binarySearchByCalories(int other) {
        //todo:
        // Sorts the calories contained in the array first. 
        sortByCalories();
        int low = 0;
        int high = pizzas.size()-1;
        int mid = 0;
        while(low <= high){
            mid = (low + high)/2;
            if(pizzas.get(mid).getCalories() == other){
                return mid;
            }
            //If the 
            else if(pizzas.get(mid).getCalories() < other){
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return -1;
    }

    /**
     * No need to edit functions below this line, unless extending the menu or
     * changing the instructions
     */
    private static final String instructions = "-----------------------\nWelcome to PizzaManager\n-----------------------\n(A)dd a random pizza\nAdd a (H)undred random pizzas\n(E)at a fraction of a pizza\nSort pizzas by (P)rice\nSort pizzas by (S)ize\nSort pizzas by (C)alories\n(B)inary Search pizzas by calories\n(Q)uit\n";
    private void displayInstructions() {
        System.out.println(instructions);    
    }

    /*
     * Notice the one-line main function.
     * Starts the switch statement and the program
     * will run.
     */
    public static void main(String[] args) throws PizzaException {
        new PizzaManager().start();
    }
}
