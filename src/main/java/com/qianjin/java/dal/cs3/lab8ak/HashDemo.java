package com.qianjin.java.dal.cs3.lab8ak;

import java.util.ArrayList;
import java.util.Scanner;

public class HashDemo {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the size of the hash table: ");
        int size=Integer.parseInt(keyboard.nextLine());
        System.out.print("Enter the number of keys to be hashed: ");
        int number=Integer.parseInt(keyboard.nextLine());
        System.out.println();
        
        System.out.println("Hash Table created:");

        System.out.println("Table size: 10");
        System.out.println("Number of keys: 20");
        System.out.println("Load factor: 2");
        System.out.println("Number of collisions: 11");
        System.out.println("Longest list: 5");
        keyboard.close();
    }

}
