package binary_tree;

import java.util.LinkedList;
import java.util.List;

import tree.NodeBT;
import utils.Common;

public class SearchBT {

	public NodeBT root;

	public static void main(String[] args) {
		NodeBT root = BinaryTree.initialize();

		Common.println("\n------------------------------searching a node ------------------------------------ ");
		int search = 12;
		Common.println("\nSearching :  " + searchNode(root, search));

		Common.println("\n------------------------------searching a node path ------------------------------------ ");
		LinkedList<Integer> path = new LinkedList<>();
		root = BinaryTree.initialize();

		searchPath(root, search, path);
		Common.println("\n------------------------------searching sum path------------------------------------ ");

		Common.println(path);
		root = BinaryTree.initialize();
		searchSumPath(root, 24);
		Common.println("\n------------------------------Sum Tree------------------------------------ ");
		root.right.left = new NodeBT(15);
		sumTree(root);
		BinaryTree.inorder(root);

		root = new NodeBT(3);
		root.left = new NodeBT(1);
		root.right = new NodeBT(2);
		root.right.left = new NodeBT(4);
		Common.println(
				"\n------------------------------IS Sum Tree------------------------------------ " + isSumTree(root));
		root = BinaryTree.initialize();
	}

	/**
	 * The solution involves a simple traversal of the given tree. So the time
	 * complexity is O(n) where n is the number of nodes in the given Binary Tree.
	 */
	private static int sumTree(NodeBT node) {
		if (node == null) {
			return 0;
		}
		int oldVal = node.data;
		node.data = sumTree(node.left) + sumTree(node.right);
		return node.data + oldVal;
	}

	static boolean isSumTree = true;

	private static boolean isSumTree(NodeBT node) {
		// Your code here
		isSumTree = true;
		if (node == null)
			return true;
		fSumTree(node);
		if (isSumTree)
			return true;
		else
			return false;
	}

	public static int fSumTree(NodeBT node) {

		if (node == null)
			return 0;

		if (node.left == null && node.right == null)
			return node.data;

		int lV = fSumTree(node.left);
		int rV = fSumTree(node.right);
		if (node.data != lV + rV) {
			// System.out.println(node.data);
			isSumTree = false;
			return -1;

		} else
			return lV + rV + node.data;
	}

	private static boolean searchNode(NodeBT root, int element) {
		if (root == null) {
			return false;
		}
		Common.print(" " + root.data);
		if (element == root.data) {
			return true;
		}
		return searchNode(root.left, element) || searchNode(root.right, element);
	}

	private static boolean searchPath(NodeBT root, int element, List<Integer> path) {
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

	private static boolean searchSumPath(NodeBT root, int sum) {
		if (root == null) {
			return false;
		}
		if (sum < 0) {
			return false;
		}

		int subtrac = sum - root.data;
		Common.println("data: " + root.data + "sum left : " + sum);
		if (subtrac == 0 && root.left == null && root.right == null) {
			Common.print(" , " + root.data);
			return true;
		}
		if (searchSumPath(root.left, subtrac) || searchSumPath(root.right, subtrac)) {
			Common.print(" , " + root.data);
			return true;
		}
		return false;
	}

	private static boolean haspathSum(NodeBT node, int sum) {
		if (node == null)
			return (sum == 0);
		else {
			boolean ans = false;

			/* otherwise check both subtrees */
			int subsum = sum - node.data;
			if (subsum == 0 && node.left == null && node.right == null)
				return true;
			if (node.left != null)
				ans = ans || haspathSum(node.left, subsum);
			if (node.right != null)
				ans = ans || haspathSum(node.right, subsum);
			return ans;
		}
	}

}
