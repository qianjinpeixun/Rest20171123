package com.qianjin.java.dal.cs3.java2110.lab09ak;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 * This class is designed for lab09.
 * 
 * This is a practice about how to use HashMap in Java
 *
 */

public class Exercise {

    public static void main(String[] args) throws FileNotFoundException {
        // the default file storing the username, login name and password
        String filename = "input9.txt";
        Scanner scanner = new Scanner(new File(filename));
        HashMap<String, String> hash1 = new HashMap<String, String>();
        HashMap<String, String> hash2 = new HashMap<String, String>();
        // start to read the file
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            Scanner sc = new Scanner(line);
            sc.useDelimiter("\t");
            String name = sc.next();
            String login = sc.next();
            String password = sc.next();
            // a hashmap with the username as key and the password as value
            hash1.put(login, password);
            // another hashmap with the username as key and full name as value
            hash2.put(login, name);
            sc.close();
        }
        scanner.close();
        // prompt the user to enter the login name and password
        int index = 0;
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            // f the password is incorrect, give the user two more chances

            System.out.print("Login: ");
            String login = keyboard.nextLine();
            System.out.print("Password: ");
            String password = keyboard.nextLine();
            
            if (hash1.get(login).equals(password)) {
                // If the login is successful, print a welcome message
                System.out.println("\nLogin successful");
                System.out.println("Welcome " + hash2.get(login));
                break;
            } else {
                if (index == 2) {
                    // If the password is incorrect all three times, the program
                    // quits
                    System.out.println("Sorry. Incorrect login. Please contact the system administrator.");
                    break;
                } else {
                    System.out.println("\nEither the username or password is incorrect. You have " + (2 - index) + " more attempts.");
                }
            }
            index++;
        }
    }
}
