
import java.util.ArrayList;
import java.util.Scanner;

public class BinaryTreeDemo1 {

    public static void main(String[] args) {
        // start to prompt to enter the data
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name or done:");
        String l = sc.nextLine();
        int position = 0;
        // using an arraylist to store the tree
        ArrayList<BinaryTree<String>> list = new ArrayList<BinaryTree<String>>();
        while (!l.equals("done")) {
            // build the tree
            BinaryTree<String> node = new BinaryTree<String>();
            node.makeRoot(l);
            //get the current node's parent node
            int parent = (position-1) / 2;
            //if the current node is left or right leaf
            int left = position % 2;
            if (position != 0) {
                if (left == 0) {
                    list.get(parent).attachRight(node);
                } else {
                    list.get(parent).attachLeft(node);
                }
            }
            position++;
            list.add(node);
            System.out.print("Enter name or done:");
            l = sc.nextLine();
        }

        // build a tree and test the methods of BinaryTree
        print(list.get(0));
    }

    private static <T> void print(BinaryTree<T> A) {

        System.out.print("Height of the tree is: ");
        System.out.print(BinaryTree.height(A));
        System.out.println();

        System.out.print("Number of nodes in the tree is: ");
        System.out.print(BinaryTree.numberNodes(A));
        System.out.println();

        System.out.print("Inorder:\t");
        BinaryTree.inorder(A);
        System.out.println();
        System.out.print("Preorder:\t");
        BinaryTree.preorder(A);
        System.out.println();

        System.out.print("Postorder:\t");
        BinaryTree.postorder(A);
        System.out.println();
        System.out.print("Levelorder:\t");
        BinaryTree.levelOrder(A);
        System.out.println();

        System.out.println();
        System.out.println();
    }
}