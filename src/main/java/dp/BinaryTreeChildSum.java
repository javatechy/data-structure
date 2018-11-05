package dp;

import binary_tree.BinaryTree;
import tree.NodeBT;
import utils.Common;

public class BinaryTreeChildSum {

	public static void main(String arr[]) {
		BinaryTree bt = BinaryTree.createBinaryTree(6, 4, 8, 3, 5, 7, 9);
		BinaryTree.inorder(bt.root);
		Common.println();
		bt.root = childSum(bt.root);
		BinaryTree.inorder(bt.root);
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
