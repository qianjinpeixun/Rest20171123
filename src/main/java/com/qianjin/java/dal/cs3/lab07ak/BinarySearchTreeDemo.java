package com.qianjin.java.dal.cs3.lab07ak;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * This class is designed as a demo class for Lab 7 in order to test the
 * Exercise 1 to 4.
 *
 */

public class BinarySearchTreeDemo {

    public static void main(String[] args) {

        // NOThardcode any of the input values in your source code.
        // Prompt the user to enter the values.
        Scanner kb = new Scanner(System.in);
        System.out.print("How many nodes do you want to build a binary search tree? ");
        int n = kb.nextInt();

        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        // start to build the binarysearchtree
        for (int i = 0; i < n; i++) {
            System.out.print("Please Enter the value of the number " + (i + 1) + " node: ");
            int v = kb.nextInt();
            tree.insert(v);
        }

        System.out.println("The inorder of the tree is as follows:");
        BinaryTree.inorder(tree.getTree());

        System.out.println("\nExercise 1, the largest key in the binary search tree is: " + tree.findMax());
        System.out.println("Exercise 2, the smallest key in the binary search tree is: " + tree.findMin());

        System.out.print("Exercise 3, please enter the numbers which you want to search in the tree: ");
        int s = kb.nextInt();
        System.out.println("The search result is: " + tree.recursiveSearch(s).getData());

        // start to test if a tree is a binarysearchtree
        // first step is to build a new tree for testing
        Scanner scanner = new Scanner(System.in);
        System.out.print("Exercise 4, how many nodes do you want to have for a tree?");
        int count = Integer.valueOf(scanner.nextLine());
        ArrayList<BinaryTree<String>> list = new ArrayList<BinaryTree<String>>();
        for (int i = 0; i < count; i++) {
            BinaryTree<String> b = new BinaryTree<String>();
            System.out.print("Please enter the value of the number " + (i + 1) + " node: ");
            String data = scanner.nextLine();
            b.makeRoot(data);
            list.add(b);
        }
        BinaryTree<String> tt = BinaryTree.build(list);
        System.out.println("The inorder of the new tree is:");
        BinaryTree.inorder(tt);
        System.out.println();
        boolean btree = BinaryTree.isBinarySearchTree(tt);
        if (btree) {
            System.out.println("This tree is a binary search tree!");
        } else {
            System.out.println("This tree is not a binary search tree!");
        }

    }

}
