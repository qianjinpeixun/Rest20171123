package com.qianjin.java.dal.cs3.java2110.ass4ak;

/**
 * This class is design for assignment 4 Part 2 of CSCI 2110 Computer Science
 * III.
 * 
 * This class implements the HeapSort algorithm.
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HeapDemo2 {

    public static void main(String[] args) throws FileNotFoundException {
        // reads a text file with words
        Scanner scanner = new Scanner(new File("heap1.txt"));
        Heap<String> myHeap = new Heap<String>();
        while (scanner.hasNext()) {
            String word = scanner.nextLine();
            // builds a heap with the words
            myHeap.add(word);
        }

        PrintWriter p = new PrintWriter(new File("heap2.txt"));
        while (!myHeap.isEmpty()) {
            // repeatedly removes the max item and puts it output text file
            p.println(myHeap.deleteMax());
        }
        p.close();

    }

}
