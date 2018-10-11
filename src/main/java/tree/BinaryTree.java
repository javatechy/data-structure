package tree;

import utils.Common;

public class BinaryTree {
	public NodeBT root;

	public static void main(String[] args) {
		BinaryTree bt = createBinaryTree(6,4,8,3,5,7,9);
		inorder(bt.root);
		Common.println();
		preorder(bt.root);
		Common.println();
		postorder(bt.root);

	}

	public static void inorder(NodeBT root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		Common.print(" " + root.data);
		inorder(root.right);
	}
	
	public static void postorder(NodeBT root) {
		if (root == null) {
			return;
		}
		postorder(root.left);
		postorder(root.right);
		Common.print(" " + root.data);
	}
	
	public static void preorder(NodeBT root) {
		if (root == null) {
			return;
		}
		Common.print(" " + root.data);
		preorder(root.left);
		preorder(root.right);
	}

	public static BinaryTree createBinaryTree(int... arr) {
		BinaryTree bt = new BinaryTree();
		for (int a : arr)
			bt.root = insert(bt.root, a);
		return bt;
	}

	private static NodeBT insert(NodeBT root, int data) {
		if (root == null) {
			root = new NodeBT(data);
			return root;
		}
		if (data < root.data) {
			//Common.println("Root left : " + root.data);
			root.left = insert(root.left, data);
		} else {
			root.right = insert(root.right, data);
		}
		return root;
	}
}
