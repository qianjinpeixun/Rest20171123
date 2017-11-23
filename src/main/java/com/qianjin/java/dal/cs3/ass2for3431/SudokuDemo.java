package com.qianjin.java.dal.cs3.ass2for3431;

import java.io.*;
import java.util.*;

/**
 * 
 * This class is designed to as a demo program to test the sudoku puzzle
 * validation for assignment 2.
 *
 */
public class SudokuDemo {

    public static void main(String[] args) {

        int[][] numbers;
        int[] flags;
        SudokuChecker checker = new SudokuChecker();
        String filename;

        // start to check sudoku1.txt from brightspace.
        filename = "sudoku1.txt";
        numbers = readFile(filename);
        flags = checker.valide(numbers);
        printResult(flags, filename);

        // start to check sudoku2.txt from brightspace.
        filename = "sudoku2.txt";
        numbers = readFile(filename);
        flags = checker.valide(numbers);
        printResult(flags, filename);

        // start to check sudoku3.txt which is prepared by myself
        filename = "sudoku3.txt";
        numbers = readFile(filename);
        flags = checker.valide(numbers);
        printResult(flags, filename);

    }

    private static void printResult(int[] flags, String filename) {
        boolean valid = Arrays.toString(flags).equals("[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]");

        if (valid)
            System.out.println("The " + filename + " is valid Sudoku puzzle!");
        else {
            System.out.println("The " + filename + " is invalid Sudoku puzzle! The detailed check result is:" + Arrays.toString(flags));
        }
        System.out.println();
    }

    /**
     * This method will read the file and convert the file content into a 2d
     * integer array
     * 
     * @param filename
     *            the filename of test file
     * @return the 2d array includes each number
     */
    public static int[][] readFile(String filename) {
        int[][] numbers = new int[9][9];
        int index = 0;
        try {
            InputStreamReader reader;
            BufferedReader buffer;
            String line;
            reader = new InputStreamReader(new FileInputStream(filename), "utf-8");
            buffer = new BufferedReader(reader);
            line = buffer.readLine();
            // parse each line in the file
            while (line != null) {
                String[] nn = line.split("\t");
                for (int i = 0; i < 9; i++) {
                    numbers[index][i] = Integer.parseInt(nn[i].trim());
                }
                index++;
                line = buffer.readLine();
            }
            buffer.close();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numbers;
    }

}
