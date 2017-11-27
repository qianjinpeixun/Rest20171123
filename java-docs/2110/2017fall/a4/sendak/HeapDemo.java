

/**
 * This class is design for assignment 4 Part 1 of CSCI 2110 Computer Science III.
 * 
 */
import java.util.Scanner;

public class HeapDemo {
    public static void main(String[] args) {
        Heap<Integer> myHeap = new Heap<Integer>();
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter positive integers into the heap (-1 when done): ");
        Integer num = keyboard.nextInt();
        while (num != -1) {
            myHeap.add(num);
            num = keyboard.nextInt();
        }
        System.out.println("The heap: ");
        myHeap.enumerate();

        System.out.println("The smallest is: " + myHeap.findMin());

        System.out.print("How many nodes to delete (0 to " + myHeap.size() + ")? ");
        int d = keyboard.nextInt();
        if (d < 0 || d > myHeap.size())
            System.out.println("Can't delete");
        else if (d == 0)
            myHeap.enumerate();
        for (int i = 1; i <= d; i++) {
            System.out.println("Deleting " + myHeap.deleteMax());
            myHeap.enumerate();
        }

        System.out.println("The smallest is: " + myHeap.findMin());
        System.out.println("After dequeueMin,The heap: ");
        myHeap.dequeueMin();
        myHeap.enumerate();

    }
}