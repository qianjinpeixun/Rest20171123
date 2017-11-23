
import java.util.ArrayList;
import java.util.Scanner;

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

    /**
     * determines whether the tree is a binary search tree
     * 
     * @param t
     *            the candidate binary tree
     * @return if binary search tree return true, otherwise return false
     */
    public static <T> boolean isBinarySearchTree(BinaryTree<T> t) {
        // get the in-order output into a string variable
        BinaryTree.getInorder(t);
        // put each node with in-order into an arraylist
        Scanner kb = new Scanner(s);
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (kb.hasNext()) {
            list.add(kb.nextInt());
        }
        kb.close();
        // if the nodes of arraylist is ordered, then means this tree is a
        // binary search tree becuase the in-order of a binary search tree is
        // ordered
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) >= list.get(i))
                return false;
        }
        return true;
    }

    private static String s = "";

    /**
     * get a string output for in-order
     * 
     * @param t
     *            the current tree
     */
    public static <T> void getInorder(BinaryTree<T> t) {
        if (t != null) {
            getInorder(t.getLeft());
            s = s + (t.getData() + "\t");
            getInorder(t.getRight());
        }
    }

    public static <T> void postorder(BinaryTree<T> t) {
        if (t != null) {
            postorder(t.getLeft());
            postorder(t.getRight());
            System.out.print(t.getData() + "\t");
        }
    }

    /**
     * according the input, build a tree, copy from my lab 6
     * 
     * @param list
     *            List of input
     * @return BinaryTree created tree
     */
    public static <T> BinaryTree<T> build(ArrayList<BinaryTree<T>> list) {
        BinaryTree<T> root = list.get(0);
        if (list.size() == 1) {// just one node
            root.attachLeft(null);
            root.attachRight(null);
            return root;
        }
        if (list.size() == 2) {// just two nodes
            list.get(1).attachLeft(null);
            list.get(1).attachRight(null);
            root.attachLeft(list.get(1));
            root.attachRight(null);
            return root;
        }
        if (list.size() == 3) {// just three nodes
            list.get(1).attachLeft(null);
            list.get(1).attachRight(null);
            list.get(2).attachLeft(null);
            list.get(2).attachRight(null);
            root.attachLeft(list.get(1));
            root.attachRight(list.get(2));
            return root;
        }
        // otherwise, create a binary tree by putting the first word in the root
        // and alternately attaching successive words as the left or the right
        // child nodes
        int size = list.size() / 2;
        for (int i = 1; i < size; i++) {
            int left = i * 2 + 1;
            int right = i * 2 + 2;
            list.get(i).attachLeft(list.get(left));
            if (right < list.size())
                list.get(i).attachRight(list.get(right));
        }
        root.attachLeft(list.get(1));
        root.attachRight(list.get(2));
        return root;
    }

}