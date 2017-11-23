
import java.util.Scanner;

/**
 * 
 * This class is designed for Exercise 2.
 *
 */
public class Exercise2 {

    public static void main(String[] args) {
        // enter a positive integer n
        Scanner kb = new Scanner(System.in);
        System.out.print("Please enter a positive integer n:");
        int n = kb.nextInt();
        countDown(n);
    }

    /**
     * Given a single int parameter, n>=0, and displays a countdown
     * 
     * @param n
     *            the number
     * @return the countdown output
     */
    public static int countDown(int n) {
        if (n == 1) {// base case
            System.out.print("1 BlastOff!");
            return 1;
        } else {// recursive case
            System.out.print(n + " ");
            return countDown(n - 1);
        }
    }

}
