/*
 *  Incomplete Driver for ArrayList(ObjectList), Stack and Queue
 * 
 * 
 */

public class ArrayBasedDataStructuresDriver {

	public static void main(String[] args) {
		stackTests();
		queueTests();
		arrayListTests();
	}

	private static void arrayListTests() {
		System.out.println("\n\nArrayList Testing\n\n");
		//todo: make more tests here
		//testing for ArrayList
		ArrayList list = new ArrayList();
        ArrayList otherList = new ArrayList();
        ArrayList testList = new ArrayList();
        

        int a = 1;
        int b = 2;
        int c = 3;

        System.out.println("Is it empty " + list.isEmpty());
        list.insert(a,0);
        list.insert(b,0);
        list.insert(c, 2);

        otherList.insert(a,0);
        otherList.insert(b,0);
        otherList.insert(c,2);
        
        testList.insert(a, 1);
        testList.insert(b, 3);
        testList.insert(c, 5);
        
        System.out.println("list 1 = " + "\n" + list.toString());
        System.out.println("list 2 = " + "\n" + otherList.toString());
        System.out.println("list 2 = " + "\n" + testList.toString());
        

        System.out.println("are the two lists equal " 
            + list.equals(otherList));

        otherList.insert(b,2);

        System.out.println("list 1 = " + "\n" + list.toString());
        System.out.println("list 2 = " + "\n" + otherList.toString());
        
        System.out.println("are the two lists equal " 
            + list.equals(otherList));

        otherList.remove(2);
        otherList.remove(2);
        otherList.insert(a,2);
        

        System.out.println("list 1 = " + "\n" + list.toString());
        System.out.println("list 2 = " + "\n" + otherList.toString());

        System.out.println("are the two lists equal " 
            + list.equals(otherList));

        System.out.println(list);
        System.out.println("index of a " + list.indexOf(a));
        System.out.println("get element of index 2 " + list.get(1));
        System.out.println("Is it empty " + list.isEmpty());
        System.out.println("index of 1 " + list.indexOf(1));
        System.out.println("the size " + list.size());
        System.out.println("removed " + list.remove(0));
        System.out.println("removed " + list.remove(0));

        System.out.println(list);

        System.out.println("removed " + list.remove(0));

        System.out.println("|||||||||||||||Faulty|||||||||||||||");
        String ab = "error";

        System.out.println(list.toString());

        list.insert(ab,3);
        list.insert(a, 2);
        System.out.println(list.toString());
        System.out.println(list.indexOf(ab));
        list.insert(ab, -1);
        System.out.println(list.get(0));
        
        
		}
		
	

	private static void queueTests() {

        //bellow is tests for Queue
        Queue myQueue = new Queue();
        Queue otherQueue = new Queue();
        
        int a = 1;
        int b = 2;
        int c = 3;

        System.out.println("Is it empty " + myQueue.isEmpty());
        myQueue.enqueue(a);
        myQueue.enqueue(b);
        myQueue.enqueue(c);

        otherQueue.enqueue(a);
        otherQueue.enqueue(b);
        otherQueue.enqueue(c);

        System.out.println("are the two lists equal " 
            + myQueue.equals(otherQueue));

        otherQueue.enqueue(b);

        System.out.println("are the two lists equal " 
            + myQueue.equals(otherQueue));

        otherQueue.dequeue();
        otherQueue.dequeue();
        otherQueue.enqueue(a);

        System.out.println("are the two lists equal " 
            + myQueue.equals(otherQueue));

        System.out.println(myQueue);

        System.out.println("Is it empty " + myQueue.isEmpty());

        System.out.println("the size " + myQueue.size());
        System.out.println("dequeued " + myQueue.dequeue());
        System.out.println("dequeued " + myQueue.dequeue());

        System.out.println(myQueue);

        System.out.println("dequeued " + myQueue.dequeue());
        
	}

	private static void stackTests() {
		 //bellow is tests for stack
        Stack myStack = new Stack();
        Stack otherStack = new Stack();

        int a = 1;
        int b = 2;
        int c = 3;

        System.out.println("Is it empty " + myStack.isEmpty());
        myStack.push(a);
        myStack.push(b);
        myStack.push(c);

        otherStack.push(a);
        otherStack.push(b);
        otherStack.push(c);

        System.out.println();
        
        System.out.println("are the two lists equal " 
            + myStack.equals(otherStack));

        otherStack.push(b);

        System.out.println("are the two lists equal " 
            + myStack.equals(otherStack));

        otherStack.pop();
        otherStack.pop();
        otherStack.push(a);

        System.out.println("are the two lists equal " 
            + myStack.equals(otherStack));

        System.out.println(myStack);

        System.out.println("Is it empty " + myStack.isEmpty());

        System.out.println("the size " + myStack.size());
        System.out.println("popd " + myStack.pop());
        System.out.println("popd " + myStack.pop());

        System.out.println(myStack);

        System.out.println("popd " + myStack.pop());	
	        
	       
	}
}


