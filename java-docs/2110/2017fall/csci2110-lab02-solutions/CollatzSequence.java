
/**
 * 
 * This is for CSCI 2110- Data Structures and Algorithms Laboratory No. 2
 * Exercise 2.
 * 
 * This class is designed to find which starting number less than or equal to
 * N produces the longest sequence.
 *
 */

public class CollatzSequence {
    /** Main method */
    public static void main(String[] args) {

        findLongest(5);
        findLongest(100);
        findLongest(1000);
        findLongest(10000);
        findLongest(100000);
        findLongest(1000000);
        findLongest(10000000);
    }

    /** The method is to check if the input is a prime */
    public static void findLongest(long number) {
        long startTime, endTime, executionTime;
        startTime = System.currentTimeMillis();
        long max = 0;
        long value = 1;
        for (long i = 1; i <= number; i++) {
            long count = getLength(i);
            //find the longest sequence
            if (count > max) {
                value = i;
                max = count;
            }
        }
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.println("N=" + number + ",number is:" + value + ",longest length is:" + max + ",execution time is: " + executionTime + " millisecs");
        return;
    }

    /** The method is get how many steps to 1 from number */
    public static long getLength(long number) {
        long count = 1;
        while (true) {
            count++;
            if (number % 2 == 0) {
                number = number / 2;
            } else {
                number = number * 3 + 1;
            }
            //reach the bottom, return value
            if (number == 1) {
                return count;
            }
        }
    }
}
