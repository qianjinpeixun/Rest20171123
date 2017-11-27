package com.qianjin.java.dal.cs3.java2110.ass4ak;

import java.util.ArrayList;
/**
 * This class is design for assignment 4 Part 3 of CSCI 2110 Computer Science
 * III.
 * 
 */
import java.util.Scanner;

public class HeapDemo3 {

    public static <T extends Comparable<T>> Heap<T> merge(Heap<T> heap1, Heap<T> heap2) {

        // copy the first heap into the result heap
        ArrayList<T> list = heap1.getList();
        Heap<T> heap3 = new Heap<T>(list);
        // insert the items one by one from the second heap into the result heap
        ArrayList<T> list2 = heap2.getList();
        for(int i=0;i<list2.size();i++){
            heap3.add(list2.get(i));
        }
        return heap3;
    }

    public static void main(String[] args) {
        Heap<Integer> heap1 = new Heap<Integer>();
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter positive integers into the first heap (-1 when done): ");
        Integer num = keyboard.nextInt();
        while (num != -1) {
            heap1.add(num);
            num = keyboard.nextInt();
        }
        System.out.println("The first heap: ");
        heap1.enumerate();

        Heap<Integer> heap2 = new Heap<Integer>();
        System.out.print("Enter positive integers into the second heap (-1 when done): ");
        num = keyboard.nextInt();
        while (num != -1) {
            heap2.add(num);
            num = keyboard.nextInt();
        }
        System.out.println("The second heap: ");
        heap2.enumerate();

        Heap<Integer> heap3 = merge(heap1, heap2);
        System.out.println("The merged heap: ");
        heap3.enumerate();
        keyboard.close();
    }

}
