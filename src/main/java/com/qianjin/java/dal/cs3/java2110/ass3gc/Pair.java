package com.qianjin.java.dal.cs3.java2110.ass3gc;

/*
 * Assignment 3 CSCI 2110
 * 
 * Pair.java
 * 
 * Nov 13rd, 2017 Yiping
 * 
 * Liang B00744822 This is entirely my own work.
 */
public class Pair implements Comparable<Pair> {

    private char character;
    private double probability;
    private int count;
    private String huffman_code;

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getHuffman_code() {
        return huffman_code;
    }

    public void setHuffman_code(String huffman_code) {
        this.huffman_code = huffman_code;
    }

    @Override
    public String toString() {
        return "Pair[character=" + character + ",probability=" + probability + "]";
    }

    @Override
    public int compareTo(Pair o) {
        if (this.probability < o.getProbability())
            return -1;
        if (this.probability > o.getProbability())
            return 1;
        return 0;
    }

}
