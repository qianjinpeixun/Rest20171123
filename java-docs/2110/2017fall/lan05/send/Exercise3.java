
import java.util.Scanner;

/**
 * 
 * This class is designed for Exercise 3.
 *
 */
public class Exercise3 {

    public static void main(String[] args) {
        // enter a positive integer n
        Scanner kb = new Scanner(System.in);
        System.out.print("Please enter a positive integer n:");
        int n = kb.nextInt();
        countDown(n);
    }

    /**
     * if n is even, it displays only even numbers in the countdown,whereas if n
     * is odd, it displays only odd numbers in the countdown
     * 
     * @param n
     *            the number
     * @return the countdown output
     */
    public static int countDown(int n) {
        if (n == 1 || n == 2) {// base case
            System.out.print(n + " BlastOff!");
            return n;
        } else {// recursive case
            System.out.print(n + " ");
            return countDown(n - 2);
        }
    }

}
