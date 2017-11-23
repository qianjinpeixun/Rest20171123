
import java.util.Scanner;
import java.util.StringTokenizer;

public class BinarySearchTreeDemo {

    // build a no binary search tree for testing
    private static BinaryTree<Integer> build2(Scanner sc) {

        BinaryTree<Integer> A = new BinaryTree<Integer>();
        BinaryTree<Integer> B = new BinaryTree<Integer>();
        BinaryTree<Integer> C = new BinaryTree<Integer>();
        BinaryTree<Integer> D = new BinaryTree<Integer>();
        BinaryTree<Integer> E = new BinaryTree<Integer>();
        BinaryTree<Integer> F = new BinaryTree<Integer>();
        System.out.println("Firstly, We will create a tree with 6 nodes.");
        // not hardcode, prompt the user to enter the value for each node
        System.out.print("What's the value of node 1? ");
        A.makeRoot(Integer.parseInt(sc.nextLine()));
        System.out.print("What's the value of node 2? ");
        B.makeRoot(Integer.parseInt(sc.nextLine()));
        System.out.print("What's the value of node 3? ");
        C.makeRoot(Integer.parseInt(sc.nextLine()));
        System.out.print("What's the value of node 4? ");
        D.makeRoot(Integer.parseInt(sc.nextLine()));
        System.out.print("What's the value of node 5? ");
        E.makeRoot(Integer.parseInt(sc.nextLine()));
        System.out.print("What's the value of node 6? ");
        F.makeRoot(Integer.parseInt(sc.nextLine()));
        System.out.println();
        System.out.println("Start to create the tree for testsing.\n");

        // build the first tree for testing
        A.attachLeft(B);
        A.attachRight(C);
        B.attachLeft(D);
        B.attachRight(E);
        D.attachLeft(F);
        return A;
    }

    // build a binary search tree for testing
    private static BinaryTree<Integer> build3(Scanner sc) {

        BinaryTree<Integer> A = new BinaryTree<Integer>();
        BinaryTree<Integer> B = new BinaryTree<Integer>();
        BinaryTree<Integer> C = new BinaryTree<Integer>();
        BinaryTree<Integer> D = new BinaryTree<Integer>();
        BinaryTree<Integer> E = new BinaryTree<Integer>();
        BinaryTree<Integer> F = new BinaryTree<Integer>();
        BinaryTree<Integer> G = new BinaryTree<Integer>();
        System.out.println("Firstly, We will create a binary search tree with 7 nodes.");
        // not hardcode, prompt the user to enter the value for each node
        System.out.print("What's the value of node 1? ");
        A.makeRoot(Integer.parseInt(sc.nextLine()));
        System.out.print("What's the value of node 2? ");
        B.makeRoot(Integer.parseInt(sc.nextLine()));
        System.out.print("What's the value of node 3? ");
        C.makeRoot(Integer.parseInt(sc.nextLine()));
        System.out.print("What's the value of node 4? ");
        D.makeRoot(Integer.parseInt(sc.nextLine()));
        System.out.print("What's the value of node 5? ");
        E.makeRoot(Integer.parseInt(sc.nextLine()));
        System.out.print("What's the value of node 6? ");
        F.makeRoot(Integer.parseInt(sc.nextLine()));
        System.out.print("What's the value of node 7? ");
        G.makeRoot(Integer.parseInt(sc.nextLine()));
        System.out.println();
        System.out.println("Start to create the tree for testsing.\n");

        // build the first tree for testing

        D.attachLeft(B);
        D.attachRight(F);
        B.attachLeft(A);
        B.attachRight(C);
        F.attachLeft(E);
        F.attachRight(G);

        return D;
    }

    // build a binary search tree using insert method
    private static BinarySearchTree<String> build1(Scanner sc) {

        BinarySearchTree<String> tree = new BinarySearchTree<String>();
        BinaryTree<String> A = new BinaryTree<String>();
        BinaryTree<String> B = new BinaryTree<String>();
        BinaryTree<String> C = new BinaryTree<String>();
        BinaryTree<String> D = new BinaryTree<String>();
        BinaryTree<String> E = new BinaryTree<String>();
        BinaryTree<String> F = new BinaryTree<String>();

        System.out.println("Firstly, We will create a binary search tree with 6 nodes:");
        // not hardcode, prompt the user to enter the value for each node
        System.out.print("What's the value of node 1? ");
        tree.insert(sc.nextLine());
        System.out.print("What's the value of node 2? ");
        tree.insert(sc.nextLine());
        System.out.print("What's the value of node 3? ");
        tree.insert(sc.nextLine());
        System.out.print("What's the value of node 4? ");
        tree.insert(sc.nextLine());
        System.out.print("What's the value of node 5? ");
        tree.insert(sc.nextLine());
        System.out.print("What's the value of node 6? ");
        tree.insert(sc.nextLine());
        System.out.println();
        System.out.println("Start to create the first tree for testsing.");
        return tree;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // build a binary search tree
        BinarySearchTree<String> A = build1(scanner);
        String max = A.findMax();
        System.out.println("Step 1, FindMax=" + max);
        String min = A.findMin();
        System.out.println("Step 2, FindMin=" + min);

        System.out.print("Please enter the value for searching: ");
        String search = scanner.nextLine();
        BinaryTree<String> rr = A.recursiveSearch(search);
        if (rr != null) {
            System.out.println("Step 3, Found it, value is:" + rr.getData());
        } else {
            System.out.println("Step 3, Not found!");
        }

        BinaryTree<Integer> B = build2(scanner);
        BinaryTree<Integer> tmp = B;
        System.out.println("Inorder:");
        BinaryTree.inorder(tmp);
        System.out.println();
        boolean b = false;
        b = isBinarySearchTree(B);
        if (b) {
            System.out.println("Yes, it's a binary search tree!");
        } else {
            System.out.println("No, it is not a binary search tree!");
        }

        System.out.println();
        BinaryTree<Integer> C = build3(scanner);
        tmp = C;
        System.out.println("Inorder:");
        BinaryTree.inorder(tmp);
        System.out.println();
        b = isBinarySearchTree(C);
        if (b) {
            System.out.println("Yes, it's a binary search tree!");
        } else {
            System.out.println("No, it is not a binary search tree!");
        }

    }

    // An algorithm to determine if one binary tree is a binary search tree
    // after the inorder, check if it's ordered
    public static <T extends Comparable<T>> boolean isBinarySearchTree(BinaryTree<T> t) {
        boolean btree = true;
        String result = "";
        BinaryTree.setInOrderResult("");
        BinaryTree.printinorder(t);
        result = BinaryTree.getInOrderResult();
        StringTokenizer token = new StringTokenizer(result, " ");
        int[] arr = new int[token.countTokens()];
        int index = 0;
        while (token.hasMoreElements()) {
            arr[index] = Integer.parseInt(token.nextToken());
            index++;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                btree = false;
                break;
            }
        }
        return btree;
    }
}
