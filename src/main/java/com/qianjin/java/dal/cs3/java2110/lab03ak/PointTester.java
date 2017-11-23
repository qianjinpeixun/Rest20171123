package com.qianjin.java.dal.cs3.java2110.lab03ak;

import java.util.Scanner;

/**
 * This class is a test class designed for CSCI 2110- Data Structures and
 * Algorithms Laboratory No. 3 Exercise 1
 * 
 * 
 */
public class PointTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Firstly, test the Point class with Integer
        System.out.print("Please enter two Integer for xpos and ypos:");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        Point<Integer> point1 = new Point<Integer>(x, y);

        // Then, test the Point class with Double
        System.out.print("Please enter two Double for xpos and ypos:");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        Point<Double> point2 = new Point<Double>(x2, y2);

        // Then, test the Point class with String
        System.out.print("Please enter two String for xpos and ypos:");
        String x3 = scanner.next();
        String y3 = scanner.next();
        Point<String> point3 = new Point<String>(x3, y3);

        // output the three Point objects to check the Generic features
        System.out.println(point1);
        System.out.println(point2);
        System.out.println(point3);
    }
}
