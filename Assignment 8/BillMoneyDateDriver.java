public class BillMoneyDateDriver
{
    public static void main(String[] args)
    {
        //Construct some money
        Money money1 = new Money(10);
        Money money2 = new Money(money1);
        money1.setMoney(30,50);
        //TODO: do more functional exercises with the money class
	    
	    
        System.out.println("Money objects output:");
        System.out.println(money1);
        System.out.println(money2);
	
	
        /**
         * create new bill using new instances, bill is paid late
         */
        Money amount = new Money(20);
        System.out.println(amount);
        Date dueDate = new Date(-4, 30, 2016);
        Date paidDate = new Date(1,29,2017);
        System.out.println(dueDate);
        Bill bill1 = new Bill(amount, dueDate, "The phone company");
        bill1.setPaid(paidDate);
       
        /**
         * create new bill, bill is paid on time
         */
        Bill bill2 = new Bill(bill1);
        bill2.setDueDate(new Date(5, 30, 2016));
        amount.setMoney(31, 99);
        dueDate.setDay(29);
        Date paidDate2 = new Date(5,29,2016);
        bill2.setPaid(paidDate2);
        
        
        /**
         * bill not paid
         */
        Bill bill3 = new Bill(bill1);
        bill3.setDueDate(new Date(9, 10, 2014));
        amount.setMoney(31, 99);
        dueDate.setDay(50);
        
        
       
        
        /**
         * bill random creation
         */
        Bill bill4 = new Bill(amount, dueDate, "The record company");
        bill4.setPaid(paidDate2);
        Bill bill5 = new Bill(amount, dueDate, "The record company");
         System.out.println(bill4.equals(bill5));
        
        System.out.println("Bill objects output:");
        System.out.println(bill1);
        System.out.println(bill2);
        System.out.println(bill3);
        System.out.println(bill4);
    }
}
