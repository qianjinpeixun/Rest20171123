
import java.util.ArrayList;
import java.util.Scanner;

// Get inputs from the user. not hardcode them.
public class BinaryTreeDemo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("How many nodes do you want to have for a tree?");
        int count = Integer.valueOf(scanner.nextLine());
        ArrayList<BinaryTree<String>> list = new ArrayList<BinaryTree<String>>();
        for (int i = 0; i < count; i++) {
            BinaryTree<String> b = new BinaryTree<String>();
            System.out.print("Please Enter the value of the number" + (i + 1) + " node:");
            String data = scanner.nextLine();
            b.makeRoot(data);
            list.add(b);
        }
        BinaryTree<String> tree = BinaryTree.build(list);
        print(tree);

    }

    private static void print(BinaryTree A) {
        System.out.print("Preorder:\t");
        BinaryTree.preorder(A);
        System.out.println();

        System.out.print("Inorder:\t");
        BinaryTree.inorder(A);
        System.out.println();

        System.out.print("Postorder:\t");
        BinaryTree.postorder(A);
        System.out.println();
        System.out.println("The number of nodes in the above tree is: " + BinaryTree.getNumberOfNodes(A));
        System.out.println("The height of the above tree is: " + BinaryTree.getHeigh(A));
        System.out.println("If the above tree is a balanced tree? " + BinaryTree.isBalanced(A));
        System.out.print("Level order traversal of the above tree is: ");
        BinaryTree.levelOrder(A);
        System.out.println();
        System.out.println();
        System.out.println();

    }

}