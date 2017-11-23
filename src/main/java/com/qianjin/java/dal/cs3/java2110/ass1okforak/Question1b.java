package com.qianjin.java.dal.cs3.java2110.ass1okforak;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * This class is for the CSCI 2110 Computer Science III Data Structures and
 * Algorithms ASSIGNMENT NO. 1 Question 1b
 * 
 * This class extends question 1a to generate all possible paths in a n x n grid
 * if diagonal moves within a square (from bottom left to top right) are also
 * allowed. For example, in a 1 x 1 grid, the possible paths would be: [NE, EN,
 * D] where D is the diagonal hop.
 */
public class Question1b {

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
        int n = 2;

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
     *            the indicator is up or right. if is up, set to N, if is right,
     *            set to E, otherwise set to E
     */
    public static void getCount(int n, int row, int col, String path, ArrayList<String> list, int step) {
        // set north,east or diagonal according to step
        if (step == 0) {
            path = path + "N";
        } else if (step == 1) {
            path = path + "E";
        } else if (step == 2) {
            path = path + "D";
        }
        // if reach the right up corner, then found a path
        if (row == n && col == n) {
            list.add(path);
        } else if (row > n || col > n) {
            return;
        } else {
            // firstly, try to move up
            getCount(n, row + 1, col, path, list, 0);
            // then try to move right
            getCount(n, row, col + 1, path, list, 1);
            // then try to move diagonal
            getCount(n, row + 1, col + 1, path, list, 2);
        }
    }// end of getCount
}
