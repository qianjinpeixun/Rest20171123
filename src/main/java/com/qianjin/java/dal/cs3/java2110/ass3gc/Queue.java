package com.qianjin.java.dal.cs3.java2110.ass3gc;

import java.util.ArrayList;

/*
 * Assignment 3 CSCI 2110
 * 
 * Queue.java
 * 
 * Nov 13rd, 2017 Yiping
 * 
 * Liang B00744822 This is entirely my own work.
 */
public class Queue {

    private ArrayList<BinaryTree<Pair>> queue;

    public Queue() {
        queue = new ArrayList<BinaryTree<Pair>>();
    }

    public BinaryTree<Pair> peeke() {
        return queue.get(0);
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public BinaryTree<Pair> dequeue() {
        return queue.remove(0);
    }

    // if put an object into this queue, the order should be calculated by
    // probability rather than putting in the last position
    public void enqueue(BinaryTree<Pair> b) {
        if (queue.isEmpty()) {
            queue.add(b);
            return;
        }
        if (b.getData().compareTo(queue.get(queue.size() - 1).getData()) > 0) {
            queue.add(b);
            return;
        }

        if (b.getData().compareTo(queue.get(0).getData()) < 0) {
            queue.add(0, b);
            return;
        }

        for (int i = 0; i < queue.size(); i++) {
            if (b.getData().compareTo(queue.get(i).getData()) < 0) {
                queue.add(i - 1, b);
                return;
            }
        }
    }

}
