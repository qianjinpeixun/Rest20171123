package com.qianjin.java.dal.cs3.java2110.ass5ak;

import java.util.ArrayList;

/**
 * This class is design for assignment 5 of CSCI 2110 Computer Science III.
 * 
 * This class is a queue using an internal arraylist to store the queue
 * 
 */

public class Queue<T> {

    private ArrayList<T> list;

    public Queue() {
        list = new ArrayList<T>();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void enQueue(T t) {
        list.add(t);
    }

    public T deQueue() {
        return list.remove(0);
    }

    public boolean contains(T t) {
        return list.contains(t);
    }

}
