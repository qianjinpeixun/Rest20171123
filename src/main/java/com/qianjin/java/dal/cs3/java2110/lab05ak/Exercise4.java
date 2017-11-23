package com.qianjin.java.dal.cs3.java2110.lab05ak;

import java.util.Scanner;

/**
 * 
 * This class is designed for Exercise 4.
 *
 */
public class Exercise4 {

    private static String str="";
    public static void main(String[] args) {
        // prompts the user to enter a positive integer n
        Scanner kb = new Scanner(System.in);
        System.out.print("Please enter value of n and m:");
        int n = kb.nextInt();
        int m = kb.nextInt();
        System.out.println("The first " + m + " multiples of " + n + " is as below:");
        multiples(n, m);
        str=str.substring(0,str.length()-1);
        System.out.println(str);
    }

    /**
     * get the first m multiples of a positive integer n
     * 
     * @param n
     *            number for n
     * @param m
     *            number for m
     * @return the multiples
     */
    public static int multiples(int n, int m) {
        if (m == 1) { // base case
            str=str+n + ",";
            return n;
        } else {// recursive case
            int f = n + multiples(n, m - 1);
            str=str+f + ",";
            return f;
        }
    }
}
