package com.qianjin.java.sss.java2s.a1101.ass46other;

public class Node {
    private Card data;
    private Node next;

    public Node(Card d, Node n) {
        data = d;
        next = n;
    }

    public void setData(Card d) {
        data = d;
    }

    public void setNext(Node n) {
        next = n;
    }

    public Card getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public String toString() {
        return data + " --> ";
    }
}