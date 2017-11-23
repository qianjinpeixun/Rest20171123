package com.qianjin.java.dal.cs3.java2110.lab03ak;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * This class is designed as a test class for CSCI 2110- Data Structures and
 * Algorithms Laboratory No. 3 Exercise 3
 * 
 */

public class Exercise3 {

    public static void main(String[] args) throws IOException {
        // Step 1. Create an empty stack, stack1, that can hold student records.
        GenericStack<StudentRecord> stack1 = new GenericStack<>();
        // Step 2. Read a file that contains student records
        Scanner keyboard = new Scanner(System.in);
        // by default file name is StudentRecord.txt
        System.out.print("Enter the filename to read from: ");
        String filename = keyboard.nextLine();
        File file = new File(filename);
        Scanner inputFile = new Scanner(file);
        StringTokenizer token;
        System.out.println("\nThe content of the file is:");
        while (inputFile.hasNext()) {
            String line = inputFile.nextLine();
            System.out.println(line);
            token = new StringTokenizer(line, " ");
            String f = token.nextToken();
            String l = token.nextToken();
            String bString = token.nextToken();
            // Convert bString to an Integer object
            int b = Integer.parseInt(bString);
            // Step 3. create a StudentRecord object and push it into stack1.
            // Create a StudentRecord object with the first name, last name and
            // ID number
            StudentRecord s = new StudentRecord(f, l, b);
            // push it into stack1
            stack1.push(s);
        } // Step 4. Repeat until all the lines in the file are read.
        inputFile.close();

        System.out.println("\nThe stack1 is:"+stack1);

        // Step 5. Create another stack2 that can hold string objects
        GenericStack<String> stack2 = new GenericStack<>();

        //Step 6. Pop stack1 item by item and push only the last name in each
        // student record into stack2
        while (!stack1.isEmpty()) {
            StudentRecord s = stack1.pop();
            stack2.push(s.getLastName());
        }

        //Step 7. Pop stack2 and display the items. With the example set of records
        // given above, this would display the last names in the reverse order:
        System.out.println("\nThe stack2 is:");

        while (!stack2.isEmpty()) {
            String l = stack2.pop();
            System.out.println(l);
        }

    }

}
