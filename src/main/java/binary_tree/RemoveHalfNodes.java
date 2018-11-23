package binary_tree;

import linkedlist.NodeLL;
import tree.NodeBT;
import utils.Common;

public class RemoveHalfNodes {
	public NodeBT root;

	public static void main(String[] args) {
		NodeBT root = new NodeBT(1);
		root.left = new NodeBT(2);
		root.right = new NodeBT(3);
		root.right.left = new NodeBT(9);
		root.right.right = new NodeBT(8);
//		root.left.left = new NodeBT(4);
		root.left.right = new NodeBT(5);
		root.left.right.right = new NodeBT(7);
		BinaryTree.inorder(root);

		removeHalfNodes(root);
		Common.println();
		BinaryTree.inorder(root);
	}

	private static void removeHalfNodes(NodeBT root) {
		if (root == null)
			return;
		removeHalfNodes(root.left);
		removeHalfNodes(root.right);
		if (root.left != null && root.right == null) {
			root.data = root.left.data;
			root.left = null;
		}
		if (root.right != null && root.left == null) {
			root.data = root.right.data;
			root.right = null;
		}

	}

}
