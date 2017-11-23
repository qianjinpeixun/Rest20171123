
import java.util.Scanner;

/**
 * 
 * This class is designed for Exercise 5.
 * 
 * 
 */
public class Exercise5 {

    public static void main(String[] args) {
        // prompts the user to enter a positive integer n
        Scanner kb = new Scanner(System.in);
        System.out.print("Please enter value of n:");
        int n = kb.nextInt();
        writeVertical(n);
    }

    /**
     * takes one non-negative integer and displays that integer with the digits
     * going down the screen one per line.
     * 
     * @param n
     *            number
     */
    public static void writeVertical(int n) {
        if (n < 10) {// base case
            System.out.println(n);
        } else {// recursive case
            int f = n / 10;
            writeVertical(f);
            System.out.println(n % 10);
        }
    }

}
