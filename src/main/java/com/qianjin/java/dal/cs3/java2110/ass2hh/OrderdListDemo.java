package com.qianjin.java.dal.cs3.java2110.ass2hh;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class OrderdListDemo {

    public static void main(String[] args) throws Exception, FileNotFoundException {
        InputStreamReader reader;
        BufferedReader buffer;
        String line;
        reader = new InputStreamReader(new FileInputStream("list1"), "utf-8");
        buffer = new BufferedReader(reader);
        line = buffer.readLine();
        OrderedList<String> list1 = new OrderedList<String>();
        while (line != null) {
            list1.insert(line);// list1 is ordered
            line = buffer.readLine();
        }
        buffer.close();
        reader.close();

        reader = new InputStreamReader(new FileInputStream("list2"), "utf-8");
        buffer = new BufferedReader(reader);
        line = buffer.readLine();
        OrderedList<String> list2 = new OrderedList<String>();
        while (line != null) {
            list2.insert(line); // list2 is ordered
            line = buffer.readLine();
        }
        buffer.close();
        reader.close();

        OrderedList<String> list3 = merge(list1, list2);
        System.out.println("Frist list:");
        list1.enumerate();
        System.out.println("Second list:");
        list2.enumerate();
        System.out.println("Merged list:");
        list3.enumerate();// list3 is a merged ordered list
    }

    public static <T extends Comparable<T>> OrderedList<T> merge(OrderedList<T> list1, OrderedList<T> list2) {
        OrderedList<T> list = new OrderedList<T>();
        T f1 = list1.first();
        T f2 = list2.first();
        while (f1 != null && f2 != null) {// two fingers walking algorithm
            if (f1.compareTo(f2) == 0) {
                list.add(0, f1);
                f1 = list1.next();
                f2 = list2.next();
            } else if (f1.compareTo(f2) < 0) {
                list.add(0, f1);
                f1 = list1.next();
            } else {
                list.add(0, f2);
                f2 = list2.next();
            }
        }

        while (f1 != null) {
            list.add(0, f1);
            f1 = list1.next();
        }
        while (f2 != null) {
            list.add(0, f2);
            f2 = list2.next();
        }
        return list;
    }

}
