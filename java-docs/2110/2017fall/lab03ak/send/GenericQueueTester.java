
/**
 * This class is a test class designed for CSCI 2110- Data Structures and
 * Algorithms Laboratory No. 3 Exercise 4
 * 
 */

public class GenericQueueTester {

    public static void main(String[] args) {
        // create a queue
        GenericQueue<Integer> q = new GenericQueue<>();
        // add some elements into this queue
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        // print the current size
        System.out.println("The current quque length is:" + q.size());
        // if this queue is empty
        System.out.println("If this queue is empty now? " + q.isEmpty());
        // remove one element
        System.out.println("This element has been removed from this queue:" + q.dequeue());

        System.out.println("Now, the queue is:" + q);
        // check the peek functions
        System.out.println("This first element is:" + q.peek());
        q.clear();
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(7);
        q.enqueue(8);
        System.out.println("Number 3 element is:" + q.positionOf(3));
        q.remove(4);
        System.out.println("Now, the queue is:" + q);
        System.out.println("The Frist element is:" + q.first());
        System.out.println("Try to get the next element:" + q.next());
        System.out.println("Try to get the next element:" + q.next());
        System.out.println("Try to get the next element:" + q.next());
        System.out.println("Try to get the next element:" + q.next());
        System.out.println("Try to get the next element:" + q.next());
        System.out.println("Try to get the next element:" + q.next());
        System.out.println("Try to get the next element:" + q.next());

    }

}
