package binary_tree;

import tree.NodeBT;
import utils.Common;

public class AddChildToParent {

	public static void main(String[] args) {
		NodeBT root = new NodeBT(5);
		root.left = new NodeBT(6);
		root.left.left = new NodeBT(3);
		root.left.right = new NodeBT(5);
		root.right = new NodeBT(9);
		root.right.left = new NodeBT(1);
		root.right.right = new NodeBT(2);
		BinaryTree.inorder(root);
		Common.println();
		SumTree sumTree = new SumTree();
		validateSumTree(root, sumTree);
		Common.println(sumTree.result);

		addChildToParent(root);
		BinaryTree.inorder(root);
		sumTree.result = true;
		validateSumTree(root, sumTree);
		Common.println(sumTree.result);
	}

	static class SumTree {
		boolean result = true;

	}

	private static int addChildToParent(NodeBT root) {
		if (root == null)
			return 0;

		if (root.left == null && root.right == null)
			return root.data;
		int leftSum = addChildToParent(root.left);
		int rightSum = addChildToParent(root.right);
		root.data = leftSum + rightSum;
		return root.data;
	}

	private static int validateSumTree(NodeBT root, SumTree sumTree) {
		if (root == null)
			return 0;

		if (root.left == null && root.right == null)
			return root.data;
		int leftSum = addChildToParent(root.left);
		int rightSum = addChildToParent(root.right);

		Common.println("Compairing: " + (leftSum + rightSum) + "  and " + root.data);
		if (root.data != leftSum + rightSum)
			sumTree.result = false;
		return root.data;
	}

}
