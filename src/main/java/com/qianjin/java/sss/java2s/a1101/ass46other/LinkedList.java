package com.qianjin.java.sss.java2s.a1101.ass46other;

public class LinkedList {
    private Node head;
    private int count;

    public LinkedList() {
        head = null;
        count = 0;
    }

    public void addToFront(Card d) {
        Node n = new Node(d, head);
        head = n;
    }

    public int size() {
        int count = 0;
        Node cur = head;
        while (cur != null) {
            count++;
            cur = cur.getNext();
        }
        return count;
    }

    public boolean isEmpty() {
        if (head == null)
            return true;
        else
            return false;
    }

    public void clear() {
        head = null;

    }

    public Card getFrontData() {
        return head.getData();

    }

    public Node getFrontNode() {
        return head;

    }

    public void enumerate() {
        String ts = "[";
        Node cur = head;
        while (cur != null) {
            ts += cur;
            cur = cur.getNext();
        }
        ts = ts + "]";
        System.out.println(ts);
    }

    public void removeFront() {
        if (!isEmpty())
            head = head.getNext();
    }

    public void addToEnd(Card d) {
        Node n = new Node(d, null);
        if (isEmpty())
            head = n;
        else {
            Node cur = head;
            while (cur.getNext() != null)
                cur = cur.getNext();
            cur.setNext(n);
        }
    }

    public void removeLast() {
        if (!isEmpty()) {
            if (head.getNext() == null)
                head = null;
            else {
                Node cur = head;
                while (cur.getNext() != null)
                    cur = cur.getNext();
                cur.setNext(null);
            }
        }
    }

    public int contains(Card d) {
        Node cur = head;
        boolean found = false;
        int index = -1;

        while (cur != null && !found) {
            index++;
            if (cur.getData().equals(d))
                found = true;
            cur = cur.getNext();
        }
        if (!found)
            index = -1;
        return index;
    }

    public void add(int index, Card d) {
        if (index >= 0 && index <= size()) {
            if (index == 0)
                addToFront(d);
            else {
                Node cur = head;
                for (int i = 0; i < index - 1; i++)
                    cur = cur.getNext();
                Node n = new Node(d, cur.getNext());
                cur.setNext(n);
            }
        }
    }

    public void remove(int index) {
        if (index >= 0 && index <= size()) {
            if (index == 0)
                removeFront();
            else if (index == size() - 1)
                removeLast();
            else {
                Node cur = head;
                for (int i = 0; i < index - 1; i++)
                    cur = cur.getNext();
                cur.setNext(cur.getNext().getNext());
            }
        }
    }

    public Node getNode(int index) {
        Node cur = null;
        if (index >= 0 && index <= size()) {
            if (index == 0)
                cur = head;
            else {
                cur = head;
                for (int i = 0; i < index; i++)
                    cur = cur.getNext();
            }
        }
        return cur;
    }

    public void addAll(LinkedList other) {
        Node cur = other.getFrontNode();
        while (cur != null) {
            addToEnd(cur.getData());
            cur = cur.getNext();
        }
    }

}