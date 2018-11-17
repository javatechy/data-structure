package dp;

import binary_tree.BinaryTree;
import tree.BinarySearchTree;
import tree.NodeBT;
import utils.Common;

public class BinaryTreeChildSum {

	public static void main(String arr[]) {
		NodeBT root = BinarySearchTree.createBST(6, 4, 8, 3, 5, 7, 9);
		BinaryTree.inorder(root);
		Common.println();
		root = childSum(root);
		BinaryTree.inorder(root);
	}

	private static NodeBT childSum(NodeBT root) {
		if (root == null) {
			return root;
		}

		root.left = childSum(root.left);
		root.right = childSum(root.right);

		if (root.left != null)
			root.data += root.left.data;
		if (root.right != null)
			root.data += root.right.data;
		return root;
	}
}
