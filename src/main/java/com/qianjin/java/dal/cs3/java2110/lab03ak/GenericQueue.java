package com.qianjin.java.dal.cs3.java2110.lab03ak;

import java.util.ArrayList;

/**
 * This class is designed for CSCI 2110- Data Structures and Algorithms
 * Laboratory No. 3 Exercise 4
 * 
 * This class Implement the generic Queue class using an ArrayList to store the
 * Queue elements
 * 
 */

public class GenericQueue<T> {
    private ArrayList<T> queue;
    int cursor; // the cursor is mainly used for the first and the next methods.

    // construct method
    public GenericQueue() {
        queue = new ArrayList<>();
        cursor = -1;
    }

    /**
     * add new item to the end of the queue
     * 
     * @param item
     */
    public void enqueue(T item) {
        queue.add(item);
    }

    /**
     * remove and return the item from the front of the queue
     * 
     * @return
     */
    public T dequeue() {
        if (isEmpty())
            return null;
        return queue.remove(0);
    }

    /**
     * return the number of elements in the queue
     * 
     * @return length
     */
    public int size() {
        return queue.size();
    }

    /**
     * return true if the queue is empty, false otherwise
     * 
     * @return true or false
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /**
     * clear the queue
     */
    public void clear() {
        queue.clear();
    }

    /**
     * return the entry from the front of the queue, null if the queue is empty
     * 
     */
    public T peek() {
        if (isEmpty())
            return null;
        else
            return queue.get(0);
    }

    /**
     * Return the position of the specified item and -1 if not found
     * 
     * @param item
     *            specified element
     * @return position
     */
    public int positionOf(T item) {
        for (int i = 0; i < queue.size(); i++) {
            if (queue.get(i).equals(item)) {
                return i;
            }
        }
        return -1;
    }

    /*
     * Remove the first occurrence (from front) of specified item
     */
    public void remove(T item) {
        int index = positionOf(item);
        if (index != -1) {
            queue.remove(index);
        }
    }

    /*
     * Return the first item in the queue(front), null if queue is empty
     */
    public T first() {
        if (isEmpty()) {
            cursor = -1;
            return null;

        } else {
            cursor = 0;
            return queue.get(0);
        }
    }

    /*
     * Return the next item in the queue relative to the previous call to first
     * or next. Return null if end of queue is reached
     */
    public T next() {
        if (isEmpty()) {
            cursor = -1;
            return null;

        } else {
            cursor++;
            if (cursor >= queue.size()) {
                return null;
            } else {
                return queue.get(cursor);
            }
        }

    }

    @Override
    public String toString() {
        return "GenericQueue [queue=" + queue + ", cursor=" + cursor + "]";
    }

}
