package tree;

import binary_tree.BinaryTree;
import utils.Common;

public class BinarySearchTree {

	public static void main(String args[]) {

		NodeBT root = insert(null, 1);
		insert(root, 4);
		insert(root, 6);
		BinaryTree.preorder(root);

		NodeBT search = search(root, 0);
		Common.println("\nNode found " + search.data);

	}

	public static BinaryTree createBST(int... arr) {
		BinaryTree bt = new BinaryTree();
		for (int a : arr)
			bt.root = insert(bt.root, a);
		return bt;
	}

	public static NodeBT insert(NodeBT root, int data) {

		if (root == null) {
			root = new NodeBT(data);
			return root;
		}
		if (data < root.data) {
			root.left = insert(root.left, data);
		} else {
			root.right = insert(root.right, data);
		}
		return root;
	}

	public static NodeBT search(NodeBT node, int data) {
		if (node == null) {
			return node;
		}

		if (node.data == data) {
			return node;
		}
		if (data < node.data) {
			return search(node.left, data);
		}
		return search(node.right, data);
	}

}
