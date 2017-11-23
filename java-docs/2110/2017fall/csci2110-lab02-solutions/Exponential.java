
import java.util.Scanner;

/**
 * 
 * This is for CSCI 2110- Data Structures and Algorithms Laboratory No. 2
 * Exercise 4.
 * 
 * This class is designed to generates 2 power n binary numbers for a given
 * value of n.
 *
 */

public class Exponential {

    /** Main method */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = keyboard.nextInt();
        long startTime, endTime, executionTime;
        startTime = System.currentTimeMillis();
        // get the number of 2^n
        int number = (int) Math.pow(2, n);
        // in a loop to genearete binary value of each number
        for (int i = 0; i < number - 1; i++) {
            String sb = Integer.toBinaryString(i);
        }
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.println("Execution time to generate 2^" + n + " binary numbers:" + executionTime + "    millisecs");

    }
}
