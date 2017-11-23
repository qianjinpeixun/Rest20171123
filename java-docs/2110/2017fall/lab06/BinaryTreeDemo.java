//This is just a starter demo program
//TODO: Get inputs from the user. Do not hardcode them.
public class BinaryTreeDemo
{
	public static void main(String[] args)
	{
		BinaryTree<String> A = new BinaryTree<String>();
		BinaryTree<String> B = new BinaryTree<String>();
		BinaryTree<String> C = new BinaryTree<String>();
		BinaryTree<String> D = new BinaryTree<String>();
		BinaryTree<String> E = new BinaryTree<String>();
		BinaryTree<String> F = new BinaryTree<String>();
		A.makeRoot("A");
		B.makeRoot("B");
		C.makeRoot("C");
		D.makeRoot("D");
		E.makeRoot("E");
		F.makeRoot("F");
		
		A.attachLeft(B);
		A.attachRight(C);
		B.attachLeft(D);
		B.attachRight(E);
		D.attachLeft(F);
		
		
		System.out.print("Preorder:\t");
		BinaryTree.preorder(A);
		System.out.println();
		
		System.out.print("Inorder:\t");
		BinaryTree.inorder(A);
		System.out.println();
		
		System.out.print("Postorder:\t");
		BinaryTree.postorder(A);
		System.out.println();
		
		
	}
	
}