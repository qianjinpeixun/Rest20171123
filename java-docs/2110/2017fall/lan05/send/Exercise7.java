
import java.util.Scanner;

/*
 * 
 * This class is design for Exercise 7 for the the Tower of Hanoi problem. This
 * class can display the number of moves for a given number of discs and show
 * the execution time for solving the Tower of Hanoi problem given n, the number
 * of discs.
 * 
 */
public class Exercise7 {

    // the number of moves
    private static long moves = 0;

    public static void main(String[] args) {
        long startTime, endTime, executionTime;
        String a = "peg A";
        String b = "peg B";
        String c = "peg C";
        // prompts the user to enter a positive integer n
        Scanner kb = new Scanner(System.in);
        System.out.print("Please enter the number of discs:");
        int n = kb.nextInt();

        startTime = System.currentTimeMillis();
        moveDiscs(n, a, b, c);
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        moves--;
        System.out.println("the number of moves for a " + n + " discs is:" + moves + " with " + executionTime + " millisecondes.");

        // will use the following values of n: 8, 12, 16, 20, 24, 28, and 32 for
        // test, record the values of execution time vs. n in sampe output file

    }

    /**
     * Using recursive to calculate the move number
     * 
     * @param n
     *            the number of discs
     * @param a
     *            the A peg
     * @param b
     *            the B peg
     * @param c
     *            the c peg
     */
    public static void moveDiscs(int n, String a, String b, String c) {
        if (n > 0) {// recursive case
            moveDiscs(n - 1, a, c, b);
            moveDiscs(n - 1, c, b, a);
        } else {// base case
            moves++;
        }
    }
}
