
import java.util.Scanner;

/**
 * 
 * This class is designed for Exercise 1.
 *
 */
public class Exercise1 {

    public static void main(String[] args) {

        // print the first 20 numbers in the Fibonacci series
        System.out.println("The first 20 numbers in the Fibonacci series is:");
        String str="";
        for (int i = 0; i < 20; i++) {
            str=str+fib(i) + ",";
        }
        str=str.substring(0,str.length()-1)+"\n";
        System.out.println(str);

        // print the factorials of 1 to 10.
        System.out.println("The factorials of 1 to 10 are as below:");
        for (int i = 1; i < 11; i++) {
            System.out.println(i+"!="+factorial(i));
        }
        System.out.println();
        // the user to enter x and n and prints x to the power of n.
        Scanner kb = new Scanner(System.in);
        System.out.print("Please enter value of x amd n:");
        int x = kb.nextInt();
        int n = kb.nextInt();
        System.out.print("The power("+x+","+n+")=");
        System.out.println(power(x, n));

    }

    /**
     * finds the nth number in the Fibonacci series.
     * 
     * @param n
     *            the number
     * @return the Fibonacci number
     */
    public static int fib(int n) {
        if (n == 0) { // base case
            return 0;
        } else if (n == 1) {// base case
            return 1;
        } else {// recursive case
            int f = fib(n - 2) + fib(n - 1);
            return f;
        }
    }

    /**
     * finds factorial of a non-negative integer n
     * 
     * @param n
     *            the number
     * @return the factorial number
     */
    public static int factorial(int n) {
        if (n == 0) // base case
            return 1;
        else {// recursive case
            return n * factorial(n - 1);
        }
    }

    /**
     * finds the x to the power n, where x and n are positive integers.
     * 
     * @param x
     * @param n
     * @return the power of x and n
     */
    public static int power(int x, int n) {
        if (n == 0)// base case
            return 1;
        else {// recursive case
            return x * power(x, n - 1);
        }
    }
}
