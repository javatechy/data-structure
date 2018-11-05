package binary_tree;

import tree.NodeBT;
import utils.Common;

public class BinaryTree {
	public NodeBT root;

	public static void main(String[] args) {
		NodeBT root = new NodeBT(10);
		root.left = new NodeBT(8);
		root.right = new NodeBT(2);
		root.left.left = new NodeBT(3);
		root.left.right = new NodeBT(5);
		root.right.right = new NodeBT(2);
		inorder(root);
		Common.println();
		preorder(root);
		Common.println();
		postorder(root);

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

	public static int height(NodeBT node) {
		if (node == null)
			return 0;
		return 1 + Common.max(height(node.left), height(node.right));
	}

	private static NodeBT insert(NodeBT root, int data) {
		if (root == null) {
			root = new NodeBT(data);
			return root;
		}
		if (data < root.data) {
			// Common.println("Root left : " + root.data);
			root.left = insert(root.left, data);
		} else {
			root.right = insert(root.right, data);
		}
		return root;
	}
}
