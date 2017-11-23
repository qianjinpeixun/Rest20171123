
import java.util.ArrayList;
import java.util.Scanner;

/*
 * This class is for the CSCI 2110 Computer Science III Data Structures and
 * Algorithms ASSIGNMENT NO. 1 Question 1c
 * 
 * This class reuses the question1a and question1b's algorithm to get the
 * execution time according to different grid size.
 * 
 */
public class Question1c {

    public static void main(String[] args) {
        ArrayList<String> l = new ArrayList<>();
        l.clear();
        long startTime, endTime, executionTime;

        // calculate the lattice paths with two directions
        for (int i = 1; i < 13; i++) {
            l.clear();
            startTime = System.currentTimeMillis();
            Question1a.findPath(i);
            endTime = System.currentTimeMillis();
            executionTime = endTime - startTime;
            System.out.println("Question 1A executionTime for Lattice Paths (n=" + i + "): " + executionTime + " milliseconds");
        }

        System.out.println("\n\n");
        // calculate the lattice paths with three directions
        for (int i = 1; i < 8; i++) {
            l.clear();
            startTime = System.currentTimeMillis();
            Question1b.findPath(i);
            endTime = System.currentTimeMillis();
            executionTime = endTime - startTime;
            System.out.println("Queston 1B executionTime for Lattice Paths with diagonal (n=" + i + "): " + executionTime + " milliseconds");
        }

    }

}
