package com.qianjin.java.dal.cs3.ass2for3431;

import java.io.*;
import java.util.*;

/**
 * This is for programming exercise for assignment 2 and the objective of this
 * exercise is to practice using threads in java. according to the requirement
 * of assignment, this class is to be designed as a multithreaded JAVA
 * application that determines whether the solution to a Sudoku puzzle is valid.
 *
 */
public class SudokuChecker {

    public int[] valide(int[][] rows) {
        // an array of integer values that is visible to each thread, and the
        // ith index in this array corresponds to the ith worker thread.
        int[] flags = new int[11];
        try {
            for (int i = 0; i < 11; i++) {
                flags[i] = 0;
            }
            // get the column 2d array
            int[][] cols = convert(rows);
            // the 9 subgrids
            int[][] subs = new int[9][9];
            // a total of eleven separate threads for validating a Sudoku puzzle
            Thread[] workers = new Thread[11];
            // Nine threads to check that each of the 3 × 3 subgrids contains
            // the
            // digits 1 through 9
            for (int i = 0; i < 9; i++) {
                subs[i] = getSubGrid(i, rows);
                int[][] checks = new int[1][9];
                checks[0] = subs[i];
                workers[i] = new Thread(new SudokuWorker(checks, i, flags));
                workers[i].start();
            }

            // A thread to check that each row contains the digits 1 through 9
            workers[9] = new Thread(new SudokuWorker(rows, 9, flags));
            workers[9].start();
            // A thread to check that each column contains the digits 1 through
            // 9
            workers[10] = new Thread(new SudokuWorker(cols, 10, flags));
            workers[10].start();

            // Waiting for the 11 threads finish
            for (int i = 0; i < 9; i++) {
                workers[i].join();
            }
            workers[9].join();
            workers[10].join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // When all worker threads have completed, the parent thread checks each
        // entry in the result array to determine if the Sudoku puzzle is valid
        return flags;
    }

    /**
     * 
     * @param numbers
     *            the original 2d array
     * @return the the new 2d array with columns
     */
    private int[][] convert(int[][] numbers) {
        int[][] ret = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                ret[j][i] = numbers[i][j];
            }
        }
        return ret;
    }

    /**
     * This is a helper method to pring the 2d array
     * 
     * @param numbersthe
     *            original 2d array
     */
    private void printNumbers(int[][] numbers) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(numbers[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 
     * @param no
     *            index of subgrids
     * @param numbers
     *            the current original 2d array
     * @return the subgrid
     */
    private int[] getSubGrid(int no, int[][] numbers) {
        int[] ret = new int[9];
        int row = (no / 3) * 3;
        int col = (no % 3) * 3;
        int index = 0;
        for (int i = row; i < (row + 3); i++) {
            for (int j = col; j < (col + 3); j++) {
                ret[index] = numbers[i][j];
                index++;
            }
        }
        return ret;
    }

}
