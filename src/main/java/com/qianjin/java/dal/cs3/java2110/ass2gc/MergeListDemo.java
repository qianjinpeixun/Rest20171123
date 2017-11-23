/*
 * Assignment 2 Question 2 CSCI 2110
 * 
 * MergeListDemo.java merge two list using two-finger walking algorithm
 * 
 * Oct 23rd, 2017 Yiping
 * 
 * Liang B00744822 This is entirely my own work.
 */

package com.qianjin.java.dal.cs3.java2110.ass2gc;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MergeListDemo {

    public static void main(String[] args) throws IOException {

        Scanner kb = new Scanner(new File("input1"));
        OrderedList<String> input1 = new OrderedList<String>();
        while (kb.hasNextLine()) {
            input1.insert(kb.next()); // create the first list
        }
        kb.close();
        kb = new Scanner(new File("input2"));
        OrderedList<String> input2 = new OrderedList<String>();
        while (kb.hasNextLine()) {
            input2.insert(kb.next()); // create the second list
        }
        kb.close();
        // start to merge the above two lists
        OrderedList<String> input3 = merge(input1, input2);
        // pirnt the result
        input1.enumerate();
        input2.enumerate();
        input3.enumerate();

    }

    public static <T extends Comparable<T>> OrderedList<T> merge(OrderedList<T> list1, OrderedList<T> list2) {
        OrderedList<T> list = new OrderedList<T>();
        // use these two fingers to walk from beginning
        int finger1 = 0;
        int finger2 = 0;
        while (true) {
            // if reach both the end of list, break the loop
            if (finger1 == (list1.size()) && finger2 == (list2.size()))
                break;
            // if each list do not reach the end
            if (finger1 < (list1.size()) && finger2 < (list2.size())) {
                T t1 = list1.get(finger1);
                T t2 = list2.get(finger2);
                int c = t1.compareTo(t2);// compare the value to decide the
                                         // position
                if (c == 0) {
                    list.add(0, t1);
                    finger1++;
                    finger2++;
                } else if (c < 0) {
                    list.add(0, t1);
                    finger1++;
                } else {
                    list.add(0, t2);
                    finger2++;
                }
            } else if (finger1 < (list1.size())) {// if list does not reach the
                                                  // end
                T t1 = list1.get(finger1);
                list.add(0, t1);
                finger1++;
            } else {// if the second list does not reach the end
                T t2 = list2.get(finger2);
                list.add(0, t2);
                finger2++;
            }
        }
        return list;
    }
}
