package binary_tree;

import tree.NodeBT;
import utils.Common;

public class ChildSumProperty {
	public NodeBT root;

	public static void main(String[] args) {
		NodeBT root = new NodeBT(10);
		root.left = new NodeBT(8);
		root.right = new NodeBT(2);
		root.left.left = new NodeBT(3);
		root.left.right = new NodeBT(5);
		root.right.right = new NodeBT(2);
		root.right.right.left = new NodeBT(2);
		BinaryTree.inorder(root);
		Common.println();

		boolean isChildSum = childSum(root);
		Common.print("IS CHILD SUM PROPERTY: " + isChildSum);
		root.right.right.left.left = new NodeBT(9);
		root.right.right.left.left.left = new NodeBT(9);
		root.right.right.left.left.left.left = new NodeBT(9);
		root.right.right.left.left.left.left.left = new NodeBT(9);
		root.right.right.left.left.left.left.left.left = new NodeBT(9);

		Common.println("Height " + BinaryTree.height(root));
	}

	private static boolean childSum(NodeBT node) {

		if (node == null)
			return true;

		int leftSum = 0;
		int rightSum = 0;

		if (node.left == null && node.right == null)
			return true;

		if (node.left != null)
			leftSum = node.left.data;

		if (node.right != null)
			rightSum = node.right.data;

		if (leftSum + rightSum == node.data) {
			return true && childSum(node.left) && childSum(node.right);
		}
		return false;
	}
}
