package com.qianjin.java.dal.cs3.java2110.ass1version2ak;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class is designed to apply the string-matching algorithm that developed
 * in Exercise 2(A) to DNA analysis.
 * 
 * The basic function is that read a text file, prompts the user for a test
 * string and determines the matches of this string in the DNA sequence. This
 * program also reports the execution time for string matching ( not including
 * the execution time for reading the file).
 *
 */
public class DNAMatch {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the filename to read from: ");
        String fileName = scanner.nextLine();

        System.out.print("Enter the test string: ");
        String str = scanner.nextLine();

        // This file contains 20,000 base pairs of DNA sequences from the human
        // genome. Genome.txt
        Scanner fileReader = new Scanner(new File(fileName));
        long startTime, endTime, executionTime;
        List<String> list = new ArrayList<>();
        while (fileReader.hasNextLine()) {
            // get the each line in the file
            String line = fileReader.nextLine();
            list.add(line);
        }

        int count = 0;
        startTime = System.currentTimeMillis();
        for (String line : list) {
            // start to count
            int cunt = StringMatch.getCount(line, str);
            if (cunt != -1) {
                count = count + cunt;
            }

        }
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.println("Substring " + str + " was found " + count + " times");
        System.out.println("Execution time for string matching: "+executionTime+" ms");
    }

}
