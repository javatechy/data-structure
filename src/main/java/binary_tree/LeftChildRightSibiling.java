package binary_tree;

import tree.NodeBT;
import utils.Common;

public class LeftChildRightSibiling {

	public static void main(String[] args) {
		NodeBT root = new NodeBT(5);
		root.left = new NodeBT(6);
		root.left.left = new NodeBT(3);
		root.left.right = new NodeBT(5);
		root.right = new NodeBT(9);
		root.right.left = new NodeBT(1);
		root.right.right = new NodeBT(2);
		BinaryTree.inorder(root);
		leftChildRightSibling(root);
		Common.println(" leftChildRightSibling View");
		BinaryTree.inorder(root);
	}

	private static void leftChildRightSibling(NodeBT root) {
		if (root == null)
			return;

		// recursively convert left and right subtree first
		leftChildRightSibling(root.left);
		leftChildRightSibling(root.right);

		// if left child is empty, then make right child as left's
		// and set right to null
		if (root.left == null) {
			root.left = root.right;
			root.right = null;
		}

		// if left child already exists, then make right child of the
		// left child to point to right child of current node and
		// set current right child as null
		else {
			root.left.right = root.right;
			root.right = null;
		}
	}

}
