

import java.util.ArrayList;
import java.util.Scanner;

public class HeapDemo3 {

    public static <T extends Comparable<T>> Heap<T> merge(Heap<T> heap1, Heap<T> heap2) {
        ArrayList<T> heapList = new ArrayList<T>();
        heap1.copyTo(heapList);
        Heap<T> result = new Heap<T>();
        result.create(heapList);// copy the first heap into result
        ArrayList<T> heapList2 = new ArrayList<T>();
        heap2.copyTo(heapList2);
        while (!heapList2.isEmpty()) {
            result.add(heapList2.remove(0));// copy second heap items one bye
                                            // one into result
        }
        return result;

    }

    public static void main(String[] args) {
        Heap<Integer> myHeap = new Heap<Integer>();
        Heap<Integer> myHeap2 = new Heap<Integer>();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please create two heaps for testing");
        System.out.print("Enter positive integers into the heap (-1 when done): ");
        Integer num = keyboard.nextInt();
        while (num != -1) {
            myHeap.add(num);
            num = keyboard.nextInt();
        }

        System.out.print("Enter positive integers into the heap (-1 when done): ");
        num = keyboard.nextInt();
        while (num != -1) {
            myHeap2.add(num);
            num = keyboard.nextInt();
        }

        System.out.println("The first heap: ");
        myHeap.enumerate();
        System.out.println("The second heap: ");
        myHeap2.enumerate();

        Heap<Integer> myHeap3 = new Heap<Integer>();
        myHeap3 = merge(myHeap, myHeap2);
        System.out.println("The merged heap: ");
        myHeap3.enumerate();

    }
}