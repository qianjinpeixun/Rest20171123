package com.qianjin.java.dal.cs3.lab8ak;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * This class is designed for CSCI 2110 Data Structures and Algorithms
 * Laboratory No.
 * 
 * 8 This class needs a LinkedList and Node object, I got them from Lab 4
 *
 */
public class HashDemo {

    public static void main(String[] args) {
        ArrayList<LinkedList> list = new ArrayList<LinkedList>();
        Scanner keyboard = new Scanner(System.in);
        // 1. Get the user to enter the table_size.
        System.out.print("Enter the size of the hash table: ");
        int table_size = Integer.parseInt(keyboard.nextLine());
        // 2. Declare an arraylist of linked lists of that size. Assume that the
        // linked list store integer objects.
        for (int i = 0; i < table_size; i++) {
            LinkedList<Integer> link = new LinkedList<Integer>();
            list.add(link);
        }
        // 3. Get the user to enter the number of keys to be hashed. Generate
        // that many random keys in the range 1 to 10000. You don’t need to
        // check for duplicate keys.
        System.out.print("Enter the number of keys to be hashed: ");
        int number = Integer.parseInt(keyboard.nextLine());
        System.out.println();

        int collisions = 0;

        for (int i = 0; i < number; i++) {
            int key = (int) (1 + Math.random() * (10000 - 1 + 1));
            // 4. For each key generated, determine where it should be mapped
            // (pos = key%table_size).
            int pos = key % table_size;
            // find the number of collisions
            if (!list.get(pos).isEmpty()) {
                collisions++;
            }
            // 5. Go to the arraylist index pos and add the key into the linked
            // list in that position.
            list.get(pos).add(key);
        }

        // 6. After all the keys have been added, enumerate all the linked
        // lists
        System.out.println("Hash Table created:");
        int max_length = 0;
        for (int i = 0; i < table_size; i++) {

            // find the number of collisions and the longest list length
            if (list.get(i).size() > max_length) {
                max_length = list.get(i).size();
            }
            list.get(i).enumerate();
            System.out.println();
        }

        System.out.println("Table size: " + table_size);
        System.out.println("Number of keys: " + number);
        System.out.println("Load factor: " + ((double) number / table_size));
        System.out.println("Number of collisions: " + collisions);
        System.out.println("Longest list: " + max_length);
        keyboard.close();
    }

}
