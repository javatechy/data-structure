package tree;

import utils.Common;

public class BinaryTree {
	private NodeBT root;

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new NodeBT(1);

		insert(bt.root, 1);
		insert(bt.root, 2);
		insert(bt.root, 3);
		insert(bt.root, 4);
		insert(bt.root, 5);
		insert(bt.root, 6);
		insert(bt.root, 30);
		print(bt.root);
		// insert(bt.root, 10);

	}

	private static void print(NodeBT root) {
		if (root == null) {
			return;
		}
		Common.print(" " + root.data);
		print(root.left);
		print(root.right);
	}

	private static NodeBT insert(NodeBT root, int data) {

		if (root == null) {
			root = new NodeBT(data);
			return root;
		}

		Common.println("Root data : " + root.data);
		if (data < root.data) {
			Common.println("Root left : " + root.data);
			insert(root.left, data);
		} else {
			Common.println("Root Right : " + root.data);
			insert(root.right, data);
		}
		return root;
	}
}
