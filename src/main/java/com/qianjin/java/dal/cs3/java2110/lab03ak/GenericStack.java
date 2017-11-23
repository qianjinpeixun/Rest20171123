package com.qianjin.java.dal.cs3.java2110.lab03ak;

import java.util.ArrayList;

/**
 * This class is designed for CSCI 2110- Data Structures and Algorithms
 * Laboratory No. 3 Exercise 2
 * 
 * This class create a simple generic stack class that is implemented with an
 * ArrayList to store the stack elements
 * 
 */
public class GenericStack<T> {
    // Using ArrayList to store the elements
    private ArrayList<T> stack;

    // construct method
    public GenericStack() {
        // create a new and empty list
        stack = new ArrayList<>();
    }

    public int getSize() {
        return stack.size();
    }

    /**
     * look the top element
     * 
     * @return look the top of stack's element
     */
    public T peek() {
        if (isEmpty())
            return null;
        return stack.get(stack.size() - 1);
    }

    /**
     * remove the top element
     * 
     * @return remove the top element in stack
     */
    public T pop() {
        if (isEmpty())
            return null;
        return stack.remove(stack.size() - 1);
    }

    /**
     * add a new element into stack
     * 
     * @param t
     */
    public void push(T t) {
        stack.add(t);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        return "GenericStack [stack=" + stack + "]";
    }
}
