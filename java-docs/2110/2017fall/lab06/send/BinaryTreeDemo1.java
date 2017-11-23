
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * This class is designed for lab06.
 * 
 * This is a generalization of the BinaryTreeDemo.java program.
 *
 */
public class BinaryTreeDemo1 {

   
    /*
     * reads a number of words from the keyboard and create a binary tree by
     * putting the first word in the root and alternately attaching successive
     * words as the left or the right child nodes.
     */
    public static void main(String[] args) {

        ArrayList<BinaryTree<String>> list = new ArrayList<BinaryTree<String>>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name or done:");
        String str = scanner.nextLine();
        while (!str.equalsIgnoreCase("done")) {
            BinaryTree<String> b = new BinaryTree<String>();
            b.makeRoot(str);
            list.add(b);
            System.out.print("Enter name or done:");
            str = scanner.nextLine();
        }

        BinaryTree<String> tree = BinaryTree.build(list);

        System.out.print("\nHeight of the tree is: " + BinaryTree.getHeigh(tree));
        System.out.println();
        System.out.println("Number of nodes in the tree is: " + BinaryTree.getNumberOfNodes(tree));

        System.out.print("Inorder:     ");
        BinaryTree.inorder(tree);
        System.out.println();

        System.out.print("Preorder:    ");
        BinaryTree.preorder(tree);
        System.out.println();

        System.out.print("Postorder:   ");
        BinaryTree.postorder(tree);
        System.out.println();

        System.out.print("Level order: ");
        BinaryTree.levelOrder(tree);
    }

}