package com.qianjin.java.dal.cs3.java2110.ass3hh;

import java.util.ArrayList;

// This is a simulation for a Queue
public class Queue<T> {

    private ArrayList<T> list;

    // Contractor to create a new arraylist
    public Queue() {
        list = new ArrayList<T>();
    }

    // see the first node in the queue
    public T peek() {
        return list.get(0);
    }

    public T dequeue() {
        return list.remove(0);
    }

    public void enqueue(T t) {
        list.add(t);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
