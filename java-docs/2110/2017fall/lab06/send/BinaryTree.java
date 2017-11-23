
import java.util.ArrayList;

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

    /**
     * This is a recursive method to find the number of nodes in a binary tree
     * 
     * @param t
     *            the Binary Tree
     * @return Integer, the number of nodes
     */
    public static <T> int getNumberOfNodes(BinaryTree<T> t) {
        int c = 0;
        if (t == null || t.isEmpty()) // base case
            return c;
        else {// recursive base
            c = 1 + getNumberOfNodes(t.getLeft()) + getNumberOfNodes(t.getRight());
        }
        return c;
    }

    /**
     * This is a recursive method to find the height of a binary tree.
     * 
     * @param t
     *            the Binary Tree
     * @return Integer, the height of the tree
     */
    public static <T> int getHeigh(BinaryTree<T> t) {
        int h = 0;
        if (t == null || t.isEmpty()) {// base case
            return 0;
        }else {// recursive case
            h = h + Math.max(getHeigh(t.getLeft()), getHeigh(t.getRight())) + 1;
        }
        return h;
    }

    /**
     * This is a recursive method that determines whether a specified binary
     * tree is height balanced.
     * 
     * @param t
     *            the Binary Tree
     * @return Boolean, if the tree is a balanced tree, true will be returned
     */
    public static <T> boolean isBalanced(BinaryTree<T> t) {
        if (t==null ||t.isEmpty())
            return true; // an empty tree is a balanced tree
        int l = getHeigh(t.getLeft());
        int r = getHeigh(t.getRight());
        // A binary tree is height balanced if, for every node in the tree, the
        // height of its left subtree differs from the height of its right
        // subtree by no more than one.
        int diff = Math.abs(l - r);
        if (diff > 1) // base case
            return false;
        // recursive case
        return isBalanced(t.getLeft()) && isBalanced(t.getRight());

    }

    /**
     * This is a method which performs a level order traversal of the specified
     * tree.
     * 
     * @param tree
     *            the Binary Tree
     */
    public static <T> void levelOrder(BinaryTree<T> tree) {
        // Use an ArrayList of type BinaryTree
        ArrayList<BinaryTree<T>> list = new ArrayList<BinaryTree<T>>();
        if (tree.isEmpty())
            return;
        // Initially put the root of the tree in it.
        list.add(tree.root());
        // Repeat the procedure until the ArrayList is empty
        while (!list.isEmpty()) {
            BinaryTree<T> t = list.remove(0);
            if (t != null) {
                System.out.print(t.getData() + "\t");
                // Remove the current node and put its children.
                list.add(t.getLeft());
                list.add(t.getRight());
            }
        }

    }
    
    
    /**
     * according the input, build a tree
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