import java.util.ArrayList; 

/**
 * Write a description of class PermanentHire here.
 * 
 * @author (Ben Khabazan) 
 * @version (020717)
 *  
 *  * A simple driver to exercise the Employee hierarchy 
 */
public class EmployeeDriver {
    public static void main(String[] args) {
        Accountant emp1 = new Accountant( "Rick", 123456789); 
        //this next employee makes a bit more than Rick 
        Accountant emp2 = new Accountant( "Tim", 55555555,10000); 
        //and lets make an hourly worker 
        HourlyWorker emp3 = new HourlyWorker( "Jim", 11111111); 
        //then a salaried worker 
        SalariedWorker emp4 = new SalariedWorker( "Jane", 222222222, 5000); 
        HourlyWorker emp5 = new HourlyWorker( "Joe", 11111111,20);
        PermanentHire emp6 = new PermanentHire("Ben", 69696969, 100000);
        //comparing permanent to salaried worker
        SalariedWorker emp7 = new SalariedWorker( "Ben", 69696969, 100000); 
        Consultant emp8 = new Consultant("Ali", 777909711,12);
        Consultant emp9 = new Consultant("Jason", 777909711);
        ColorWithAlpha b = new ColorWithAlpha(100,100,100,150); 
        //todo: Build some PermanentHire and Consultant objects here //and add them to the ArrayList below
        //and build a set of workers, all of which are employees 
        ArrayList<Employee> myEmployees = new ArrayList<Employee>();
        myEmployees.add(emp1); 
        myEmployees.add(emp2); 
        myEmployees.add(emp3); 
        myEmployees.add(emp4); 
        myEmployees.add(emp5); 
        myEmployees.add(emp6);
        myEmployees.add(emp7);
        myEmployees.add(emp8);
        myEmployees.add(emp9);
        //cannot add this one because it is color myEmployees.add(b);
        //todo: add a sixth and seventh employee to this list that you create
        //this code doesn't need to change, even if you add 10 new employee classes and
        //add 102 new employees - this is an example of generic code that can be written
        //when inheritance hierarchies are in use 
        for( int i = 0; i < myEmployees.size(); i++) { Employee current = myEmployees.get(i);
            System.out.println( current.getName() + " makes " +
                current.calculateWeeklyPay() + " per week.");
        }
    }
}
