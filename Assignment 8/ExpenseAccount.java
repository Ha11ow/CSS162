
/**
 * This is an overview and overridden version of the Array list class
 * 
 * @author (Ben Khabazan) 
 */
public class ExpenseAccount extends ArrayList
{
    
    /**
     * overriding insert to only get Bills into the array list that we have
     * @param element
     * @param index
     */
    public void insert(Object element, int index){
        try{
            if(element instanceof Bill){
                super.insert((Bill)element, index);
            }
            else{
                throw new Exception("The Object given must be of type Bill");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Removes the index given and returns a bill
     * @param index
     * @override
     */
    public Bill remove(int index){
        return (Bill) super.remove(index);
    }

    /**
     * returns the index of the bill
     * @param element
     * @override
     */
    public int indexOf(Bill element){
        return super.indexOf(element);
    }

    /**
     * Will get the element at the index given
     * @return Bill
     * @override
     */
    public Bill get(int index){
        return (Bill) super.get(index);
    }

    /**
     * returns the total balance
     * @return double
     * @override
     */
    public double getBalance(){
        double retVal = 0;
        for (int i = 0; i < size(); i++){
            retVal += ((Bill)get(i)).getAmount().getMoney();
        }
        return retVal;
    }

    /**
     * Returns the originators set on bills
     * @override
     */
    public String getOriginators(){
        String retVal = "";
        for (int i = 0; i < size(); i++){
            retVal += ((Bill)get(i)).getOriginator() + "\n";
        }
        return retVal;
    }

    
    public static void main(String [] args) {
        Money money1 = new Money(40, 49);
        Date date1 = new Date(2, 10, 2016);
        String originator1 = "Comcast";

        Bill bill1 = new Bill(money1, date1, originator1);
        Bill bill2 = (Bill) bill1.clone();
        //System.out.println("bill2:\n" + bill2 +  "bill 1:\n" +  bill1);

        Money money2 = new Money(10, 99);
        Bill bill3 = new Bill(money2, date1, "Amazon");
        Date paid1 = new Date(8, 30, 2015);
        bill3.setPaid(paid1);
        Bill bill4 = (Bill) bill3.clone();
        //System.out.println("bill 3: \n" + bill3 + "bill4: \n" + bill4);

        Money money3 = new Money(30, 00);
        Date date2 = new Date(6, 15, 2018);
        Bill bill5 = new Bill(money3, date2, "FedEx");
        Date paid2 = new Date(6, 16, 2018);
        bill5.setPaid(paid2);
        Bill bill6 = (Bill) bill5.clone();
       // System.out.println("bill5: \n" + bill5 + "bill 6: \n" + bill6);

        
        Money money4 = new Money(20, 16);
        Date date3 = new Date(4, 04, 2016);
        Bill bill7 = new Bill(money4, date3, "Water Company");
        Date paid3 = new Date(4, 04, 2016);
        bill7.setPaid(paid3);
        //System.out.println("bill7: \n" + bill7);
        
        
        ExpenseAccount ea1 = new ExpenseAccount();
        ea1.insert(bill1, 0);
        ea1.insert(bill2, 1);
        ea1.insert(bill3, 0);
        ea1.insert(bill4, 2);
        ea1.insert(bill5, 3);
        ea1.insert(bill6, 4);
        ea1.insert(bill7, 3);
        
        System.out.println("toString: " + ea1.toString());
        
        System.out.println("removing 8: " + ea1.remove(8));
        System.out.println("removing 0: " + ea1.remove(0));
        
        System.out.println("toString: " + ea1.toString());
        
        System.out.println("Balance: " + ea1.getBalance());
        System.out.println("Origniators: " + ea1.getOriginators());
    }
}
