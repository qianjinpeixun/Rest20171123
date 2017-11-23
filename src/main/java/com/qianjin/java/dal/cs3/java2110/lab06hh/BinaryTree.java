package com.qianjin.java.dal.cs3.java2110.lab06hh;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class BinaryTree<T> {
    private T data;
    private BinaryTree<T> parent;
    private BinaryTree<T> left;
    private BinaryTree<T> right;

    public BinaryTree() {
        parent = left = right = null;
        data = null;
    }

    public void makeRoot(T data) {
        if (!isEmpty()) {
            System.out.println("Can't make root. Already exists");
        } else
            this.data = data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setLeft(BinaryTree<T> tree) {
        left = tree;
    }

    public void setRight(BinaryTree<T> tree) {
        right = tree;
    }

    public void setParent(BinaryTree<T> tree) {
        parent = tree;
    }

    public T getData() {
        return data;
    }

    public BinaryTree<T> getParent() {
        return parent;
    }

    public BinaryTree<T> getLeft() {
        return left;
    }

    public BinaryTree<T> getRight() {
        return right;
    }

    public void attachLeft(BinaryTree<T> tree) {
        if (tree == null)
            return;
        else if (left != null || tree.getParent() != null) {
            System.out.println("Can't attach");
            return;
        } else {

            tree.setParent(this);
            this.setLeft(tree);
        }
    }

    public void attachRight(BinaryTree<T> tree) {
        if (tree == null)
            return;
        else if (right != null || tree.getParent() != null) {
            System.out.println("Can't attach");
            return;
        } else {

            tree.setParent(this);
            this.setRight(tree);
        }
    }

    public BinaryTree<T> detachLeft() {
        if (this.isEmpty())
            return null;
        BinaryTree<T> retLeft = left;
        left = null;
        if (retLeft != null)
            retLeft.setParent(null);
        return retLeft;
    }

    public BinaryTree<T> detachRight() {
        if (this.isEmpty())
            return null;
        BinaryTree<T> retRight = right;
        right = null;
        if (retRight != null)
            retRight.setParent(null);
        return retRight;
    }

    public boolean isEmpty() {
        if (data == null)
            return true;
        else
            return false;
    }

    public void clear() {
        left = right = parent = null;
        data = null;
    }

    public BinaryTree<T> root() {
        if (parent == null)
            return this;
        else {
            BinaryTree<T> next = parent;
            while (next.getParent() != null)
                next = next.getParent();
            return next;
        }
    }

    public static <T> void preorder(BinaryTree<T> t) {
        if (t != null) {
            System.out.print(t.getData() + "\t");
            preorder(t.getLeft());
            preorder(t.getRight());
        }
    }

    public static <T> void inorder(BinaryTree<T> t) {
        if (t != null) {
            inorder(t.getLeft());
            System.out.print(t.getData() + "\t");
            inorder(t.getRight());
        }
    }

    public static <T> void postorder(BinaryTree<T> t) {
        if (t != null) {
            postorder(t.getLeft());
            postorder(t.getRight());
            System.out.print(t.getData() + "\t");
        }
    }

    public static <T> int numberNodes(BinaryTree<T> t) {
        if (t == null)
            return 0;
        else {
            // the number of nodes is one plus number of nodes of left and right
            return 1 + numberNodes(t.getLeft()) + numberNodes(t.getRight());
        }
    }

    public static <T> int height(BinaryTree<T> t) {
        if (t == null)
            return 0;
        else {
            int lheight = height(t.getLeft());
            int rheight = height(t.getRight());
            // the height of tree is the maximum of left or right sub-tree
            if (lheight > rheight) {
                return (1 + lheight);
            } else {
                return (1 + rheight);
            }
        }
    }

    public static <T> boolean balance(BinaryTree<T> t) {
        if (t == null)
            return true;
        else {
            int lheight = height(t.getLeft());
            int rheight = height(t.getRight());
            // if more than 1,then is not a balanced tree
            if (Math.abs(lheight - rheight) > 1)
                return false;
            else {
                // otherwise, enter in a cursive mode
                boolean b1 = balance(t.getLeft());
                boolean b2 = balance(t.getRight());
                return (b1 && b2);
            }
        }
    }

    public static <T> void levelOrder(BinaryTree<T> t) {
        if (t == null)
            return;
        // In the lab's hint, we can use arraylist
        // after learning the request, I found that using a queue is better
        Queue<BinaryTree<T>> q = new ArrayDeque<BinaryTree<T>>();
        //put the first as root into a queque
        q.add(t);
        BinaryTree<T> cur;
        while (!q.isEmpty()) {
            cur = q.peek();
            System.out.print(cur.getData() + "\t");
            if (cur.left != null)
                q.add(cur.left);
            if (cur.right != null)
                q.add(cur.right);
            //remove the current node from quue
            q.poll();
        }
    }

}