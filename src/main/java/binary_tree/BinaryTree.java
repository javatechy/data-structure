package binary_tree;

import java.util.LinkedList;
import java.util.List;

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
		root.right.right = new NodeBT(12);
		inorder(root);
		Common.println();
		preorder(root);
		Common.println();
		postorder(root);

		int search = 1233;
		Common.println("\nSearching :  " + searchNode(root, search));
		LinkedList<Integer> path = new LinkedList<>();
		searchPath(root, search, path);
		Common.println("\nSearching pATH :  " + path);
		Common.println("\nLevel Order Traversal :  ");
		levelOrderTraversal(root);
	}

	public static boolean searchNode(NodeBT root, int element) {
		if (root == null) {
			return false;
		}
		Common.print(" " + root.data);
		if (element == root.data) {
			return true;
		}
		return searchNode(root.left, element) || searchNode(root.right, element);
	}

	/**
	 * Use Queue or this
	 * 
	 */
	public static void levelOrderTraversal(NodeBT root) {
		int height = height(root);

		for (int l = 1; l <= height; l++) {
			printLevel(root, l);
		}

	}

	private static void printLevel(NodeBT root, int level) {
		if (level <= 1 && root != null) {
			Common.print(root.data + " , ");
		}
		if (level > 1) {
			printLevel(root.left, level - 1);
			printLevel(root.right, level - 1);
		}
	}

	public static boolean searchPath(NodeBT root, int element, List<Integer> path) {
		if (root == null) {
			return false;
		}
		if (element == root.data) {
			path.add(root.data);
			return true;
		}
		if (searchPath(root.left, element, path) || searchPath(root.right, element, path)) {
			path.add(root.data);
			return true;
		}
		return false;
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
