package com.qianjin.java.dal.cs3.java2110.ass4hh;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

import com.qianjin.java.dal.cs3.java2110.ass3hh.Pair;

public class HeapDemo2 {
    public static void main(String[] args) throws Exception {

        InputStreamReader reader;
        BufferedReader buffer;
        String line;
        reader = new InputStreamReader(new FileInputStream("HeapSort1.txt"), "utf-8");
        buffer = new BufferedReader(reader);
        line = buffer.readLine();
        Heap<String> myHeap = new Heap<String>();
        while (line != null) {// begin to read file
            myHeap.add(line);// add into heap
            line = buffer.readLine();
        }
        buffer.close();
        reader.close();
        PrintWriter pw = new PrintWriter(new File("HeapSort2.txt"));
        while (!myHeap.isEmpty()) {
            line = myHeap.deleteMax();// each time is the largest key in heap
            pw.println(line);
        }
        pw.close();

    }
}