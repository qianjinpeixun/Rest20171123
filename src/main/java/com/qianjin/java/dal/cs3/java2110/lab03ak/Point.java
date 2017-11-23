package com.qianjin.java.dal.cs3.java2110.lab03ak;

/**
 * This class is designed for CSCI 2110- Data Structures and Algorithms
 * Laboratory No. 3 Exercise 1
 * 
 * This class has xpos and ypos as its fields, get and set methods, and a
 * toString method. It is written as a generic class, which means that it work
 * for any type of object.
 * 
 */
public class Point<T> {

    // the xpos and ypos could be either Integer objects, or Double objects, or
    // String objects.
    private T xpos;
    private T ypos;

    public Point(T x, T y) {
        xpos = x;
        ypos = y;
    }

    public T getXpos() {
        return xpos;
    }

    public void setXpos(T xpos) {
        this.xpos = xpos;
    }

    public T getYpos() {
        return ypos;
    }

    public void setYpos(T ypos) {
        this.ypos = ypos;
    }

    @Override
    public String toString() {
        return "XPOS:" + xpos + "    YPOS:" + ypos;
    }

}
