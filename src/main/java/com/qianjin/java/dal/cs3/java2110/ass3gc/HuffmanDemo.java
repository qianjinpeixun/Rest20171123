package com.qianjin.java.dal.cs3.java2110.ass3gc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Assignment 3 CSCI 2110
 * 
 * HuffmanDemo.java show how to use Huffman class to encode and decode
 * 
 * Nov 13rd, 2017 Yiping
 * 
 * Liang B00744822 This is entirely my own work.
 */
public class HuffmanDemo {

    public static void main(String[] args) throws FileNotFoundException {

        Huffman huffman = new Huffman();
        Scanner kb = new Scanner(new File("Pokemon.txt"));
        System.out.println("Step 1, Pokemon.txt is:");
        // put the all characters in the file into Huffman object
        while (kb.hasNextLine()) {
            String str = kb.nextLine();
            System.out.println(str);
            huffman.addLine(str);
        }
        kb.close();
        // get the probability of each character according to occurrence
        huffman.setProbability();
        // create the queue in order to get huffman code
        Queue queue = huffman.createQueue();
        BinaryTree<Pair> root = huffman.createHuffmanTree();
        System.out.println("\nStep 3, build the Huffman tree, preorder is:");
        BinaryTree.preorder(root);

        huffman.getHuffmanCodes();
        String filename = "Huffman.txt";
        File file = new File(filename);
        huffman.printHuffmanCodeFile(file);
        // encode the file using huffman codes
        huffman.encodeToFile();
        // decode
        huffman.decodeToFile();
        // last step, check the decode file
        Scanner kb1 = new Scanner(new File("Pokemon.txt"));
        Scanner kb2 = new Scanner(new File("Decoded.txt"));
        boolean check = true;
        while (kb1.hasNextLine()) {
            String str1 = kb1.nextLine();
            String str2 = kb2.nextLine();
            if (!str1.equals(str2)) {
                check = false;
                break;
            }
        }
        kb1.close();
        kb2.close();
        if (check)
            System.out.println("Finally, compare the Pokemon.txt with Decoded.txt: the result is correct!");
        else
            System.out.println("Finally, compare the Pokemon.txt with Decoded.txt: wrong decode file!");

    }

}
