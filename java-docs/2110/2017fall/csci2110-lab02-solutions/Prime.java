
/**
 * 
 * This is for CSCI 2110- Data Structures and Algorithms Laboratory No. 2
 * Exercise 1.
 * 
 * This class is designed to to find the 11th, the 101st, 1001st, 10001st prime
 * numbers and determine how long your program takes to find each of those
 * primes
 *
 */

public class Prime {
    /** Main method */
    public static void main(String[] args) {
        getExecutionTime(11);
        getExecutionTime(101);
        getExecutionTime(1001);
        getExecutionTime(10001);
    }

    /** The method is to calculate the prime and excution time */
    public static void getExecutionTime(long number) {
        long startTime, endTime, executionTime;
        long start = 1;
        long count = 0;
        startTime = System.currentTimeMillis();
        while (true) {
            start++;
            // if the number is prime, continue to calculate the next
            if (isPrime(start)) {
                count++;
            }
            // if it reach number, start to print results
            if (count == number) {
                endTime = System.currentTimeMillis();
                executionTime = endTime - startTime;
                System.out.println("number " + count + " prime is:" + start + ", Execution time is: " + executionTime + " millisecs");
                return;
            }
        }
    }

    /** The method is to check if the input is a prime */
    public static boolean isPrime(long number) {
        for (long i = 2; i < number; i++) {
            // if it's factor for number
            // then this number is not a prime
            if (number % i == 0) {
                return false;
            }
        }
        // otherwise, this is a prime
        return true;
    }

}
