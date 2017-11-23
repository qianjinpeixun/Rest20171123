package com.qianjin.java.sss.java2s.a1101.ass42larryla;

public class LinkedList {
    private Node front;
    // private int count;
    // private Node end;

    public LinkedList() {
        front = null;
    }

    public void addToFront(Card d) {
        Node n = new Node(d, front);
        front = n;
    }

    public int size() {
        int count = 0;
        Node cur = front;
        while (cur != null) {
            count++;
            cur = cur.getNext();
        }
        return count;
    }

    public boolean isEmpty() {
        if (front == null)
            return true;
        else
            return false;
    }

    public void clear() {
        front = null;

    }

    public Card getFrontData() {
        return front.getData();
    }

    public Node getFrontNode() {
        return front;
    }

    public void enumerate() {
        String ts = "[";
        Node cur = front;
        while (cur != null) {
            ts += cur;
            cur = cur.getNext();
        }
        ts = ts + "]";
        System.out.println(ts);
    }

    public void removeFront() {
        if (!isEmpty())
            front = front.getNext();
        // else
        // System.out.println(�No front to remove!�);

    }

    public void addToEnd(Card d) {
        Node n = new Node(d, null);
        if (isEmpty())
            front = n;
        else {
            Node cur = front;
            while (cur.getNext() != null)
                cur = cur.getNext();
            cur.setNext(n);
        }
    }

    public void removeLast() {
        if (!isEmpty()) {
            if (front.getNext() == null)
                front = null;
            else {
                Node cur = front;
                while (cur.getNext() != null)
                    cur = cur.getNext();
                cur.setNext(null);
            }
            // } else { System.out.println(�No end to remove!�);
        }
    }

    public int contains(Card d) {
        Node cur = front;
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
                Node cur = front;
                for (int i = 0; i < index - 1; i++)
                    cur = cur.getNext();
                Node n = new Node(d, cur.getNext());
                cur.setNext(n);
            }
        }
        // else { System.out.println(�Index out of bounds!�); }
    }

    public void remove(int index) {
        if (index >= 0 && index <= size()) {
            if (index == 0)
                removeFront();
            else if (index == size() - 1)
                removeLast();
            else {
                Node cur = front;
                for (int i = 0; i < index - 1; i++)
                    cur = cur.getNext();
                cur.setNext(cur.getNext().getNext());
            }
        }
        // else { System.out.println(�Index out of bounds!�); }
    }

    public Node getNode(int index) {
        Node cur = null;
        if (index >= 0 && index <= size()) {
            if (index == 0)
                cur = front;
            else {
                cur = front;
                for (int i = 0; i < index; i++)
                    cur = cur.getNext();
            }
        } // else { System.out.println(�Index out of bounds!�); }
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