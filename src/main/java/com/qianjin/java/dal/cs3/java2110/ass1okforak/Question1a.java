package com.qianjin.java.dal.cs3.java2110.ass1okforak;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * This class is for the CSCI 2110 Computer Science III Data Structures and
 * Algorithms ASSIGNMENT NO. 1 Question 1a
 * 
 * This class can generate all possible paths of a lattice of a given size,
 * stores the paths as Strings in an array list and print the output.
 * 
 */
public class Question1a {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            list.clear();
            System.out.print("\nEnter the lattice size: ");
            int n = scanner.nextInt();
            if (n == 0)
                break;
            // start to find all paths
            getCount(n, 0, 0, "", list, -1);
            // found the all paths
            System.out.println("The lattice paths number is:" + list.size());
            System.out.println("The lattice paths are:" + list);
        }
    }

    /**
     * 
     * This recursion method is designed to find all the potential paths
     * 
     * @param n
     *            the size of grid
     * @param row
     *            the x position where to start with
     * @param col
     *            the y position where to start with
     * @param path
     *            the current path
     * @param list
     *            this list to contain all of potential paths
     * @param step
     *            the indicator is up or right. if is up, set to N, otherwise
     *            set to E
     */
    public static void getCount(int n, int row, int col, String path, ArrayList<String> list, int step) {
        // set north or east according to step
        if (step == 0) {
            path = path + "N";
        } else if (step == 1) {
            path = path + "E";
        }
        // if reach the right up corner, then found a path
        if (row == n && col == n) {
            list.add(path);
        } else if (row > n || col > n) { // if exceed the bound of grid, return
            return;
        } else {
            // firstly, try to move up
            getCount(n, row + 1, col, path, list, 0);
            // then try to move right
            getCount(n, row, col + 1, path, list, 1);
        }
    }// end of getCount
}
