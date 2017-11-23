package com.qianjin.java.dal.cs3.java2110.lab06hh;

import java.util.Scanner;

public class BinaryTreeDemo {

    public static void main(String[] args) {
        // build a tree and test the methods of BinaryTree
        BinaryTree<String> A = build1();
        print(A);

        // build another tree and test the methods of BinaryTree
        A = build2();
        print(A);

        // build the third tree and test the methods of BinaryTree
        A = build3();
        print(A);
    }

    private static BinaryTree<String> build3() {
        BinaryTree<String> A = new BinaryTree<String>();
        BinaryTree<String> B = new BinaryTree<String>();
        BinaryTree<String> C = new BinaryTree<String>();
        BinaryTree<String> D = new BinaryTree<String>();
        BinaryTree<String> E = new BinaryTree<String>();
        BinaryTree<String> F = new BinaryTree<String>();
        BinaryTree<String> G = new BinaryTree<String>();
        System.out.println("\nFinally, We will create the third tree with 7 nodes:");
        // not hardcode, prompt the user to enter the value for each node
        Scanner sc = new Scanner(System.in);
        System.out.print("What's the value of node 1? ");
        A.makeRoot(sc.nextLine());
        System.out.print("What's the value of node 2? ");
        B.makeRoot(sc.nextLine());
        System.out.print("What's the value of node 3? ");
        C.makeRoot(sc.nextLine());
        System.out.print("What's the value of node 4? ");
        D.makeRoot(sc.nextLine());
        System.out.print("What's the value of node 5? ");
        E.makeRoot(sc.nextLine());
        System.out.print("What's the value of node 6? ");
        F.makeRoot(sc.nextLine());
        System.out.print("What's the value of node 7? ");
        G.makeRoot(sc.nextLine());
        System.out.println();
        System.out.println("Start to create the third tree for testsing.");

        // build the first tree for testing
        A.attachLeft(B);
        A.attachRight(C);
        B.attachLeft(D);
        B.attachRight(E);
        D.attachLeft(F);
        C.attachLeft(G);

        return A;
    }

    private static BinaryTree<String> build1() {
        BinaryTree<String> A = new BinaryTree<String>();
        BinaryTree<String> B = new BinaryTree<String>();
        BinaryTree<String> C = new BinaryTree<String>();
        BinaryTree<String> D = new BinaryTree<String>();
        BinaryTree<String> E = new BinaryTree<String>();
        BinaryTree<String> F = new BinaryTree<String>();
        System.out.println("Firstly, We will create a tree with 6 nodes:");
        // not hardcode, prompt the user to enter the value for each node
        Scanner sc = new Scanner(System.in);
        System.out.print("What's the value of node 1? ");
        A.makeRoot(sc.nextLine());
        System.out.print("What's the value of node 2? ");
        B.makeRoot(sc.nextLine());
        System.out.print("What's the value of node 3? ");
        C.makeRoot(sc.nextLine());
        System.out.print("What's the value of node 4? ");
        D.makeRoot(sc.nextLine());
        System.out.print("What's the value of node 5? ");
        E.makeRoot(sc.nextLine());
        System.out.print("What's the value of node 6? ");
        F.makeRoot(sc.nextLine());
        System.out.println();
        System.out.println("Start to create the first tree for testsing.");

        // build the first tree for testing
        A.attachLeft(B);
        A.attachRight(C);
        B.attachLeft(D);
        B.attachRight(E);
        D.attachLeft(F);
        return A;
    }

    private static BinaryTree<String> build2() {
        BinaryTree<String> A = new BinaryTree<String>();
        BinaryTree<String> B = new BinaryTree<String>();
        BinaryTree<String> C = new BinaryTree<String>();
        BinaryTree<String> D = new BinaryTree<String>();
        BinaryTree<String> E = new BinaryTree<String>();
        BinaryTree<String> F = new BinaryTree<String>();
        System.out.println("\nSecondly, We will create another tree with 6 nodes:");
        // not hardcode, prompt the user to enter the value for each node
        Scanner sc = new Scanner(System.in);
        System.out.print("What's the value of node 1? ");
        A.makeRoot(sc.nextLine());
        System.out.print("What's the value of node 2? ");
        B.makeRoot(sc.nextLine());
        System.out.print("What's the value of node 3? ");
        C.makeRoot(sc.nextLine());
        System.out.print("What's the value of node 4? ");
        D.makeRoot(sc.nextLine());
        System.out.print("What's the value of node 5? ");
        E.makeRoot(sc.nextLine());
        System.out.print("What's the value of node 6? ");
        F.makeRoot(sc.nextLine());
        System.out.println();
        System.out.println("Start to create the first tree for testsing.");

        // build the first tree for testing
        A.attachLeft(B);
        B.attachRight(C);
        C.attachLeft(D);
        D.attachRight(E);
        E.attachLeft(F);
        return A;
    }

    private static <T> void print(BinaryTree<T> A) {
        System.out.println("Start to print the tree:");
        System.out.print("Preorder:\t");
        BinaryTree.preorder(A);
        System.out.println();

        System.out.print("Inorder:\t");
        BinaryTree.inorder(A);
        System.out.println();

        System.out.print("Postorder:\t");
        BinaryTree.postorder(A);
        System.out.println();

        System.out.print("Number of Nodes:\t");
        System.out.print(BinaryTree.numberNodes(A));
        System.out.println();

        System.out.print("Height:\t");
        System.out.print(BinaryTree.height(A));
        System.out.println();

        boolean b = BinaryTree.balance(A);
        if (b)
            System.out.print("This tree is balanced\t");
        else
            System.out.print("This tree is not balanced\t");
        System.out.println();

        System.out.print("Levelorder:\t");
        BinaryTree.levelOrder(A);
        System.out.println();
        System.out.println();
        System.out.println();

    }
}