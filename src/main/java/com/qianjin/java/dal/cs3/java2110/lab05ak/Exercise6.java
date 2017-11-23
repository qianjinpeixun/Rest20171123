package com.qianjin.java.dal.cs3.java2110.lab05ak;

import java.util.Scanner;

/**
 * This class is designed for Exercise 6.
 * 
 *
 */
public class Exercise6 {

    private static String str = "";

    public static void main(String[] args) {
        // prompts the user to enter a positive integer n
        Scanner kb = new Scanner(System.in);
        System.out.print("Please enter value of n:");
        int n = kb.nextInt();
        int result = squares(n);
        str = str.substring(0, str.length() - 1) + "=";
        System.out.println(str + result);

    }

    /**
     * calculate the sum of squares of all integers up to n
     * 
     * @param n
     *            the number
     * @return the result
     */
    public static int squares(int n) {
        if (n == 1) {// base case
            str = str + "1*1+";
            return 1;
        } else {// recursive case
            int f = n * n + squares(n - 1);
            str = str + "" + n + "*" + n + "+";
            return f;
        }
    }

}
