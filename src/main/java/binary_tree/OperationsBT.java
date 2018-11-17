package binary_tree;

import tree.NodeBT;
import utils.Common;

public class OperationsBT {

	public NodeBT root;

	public static void main(String[] args) {
		NodeBT root = BinaryTree.initialize();
		root.right.left = new NodeBT(15);
		// Sum tree
		sumTree(root);
		BinaryTree.inorder(root);
		Common.println("\nMirror (Inorder):  ");
		mirror(root);
		BinaryTree.inorder(root);
		Common.println("\nIs Balanced:  " + isBalanced(root, new Height()));
		Common.println("\nPrint K Distant nodes:  ");
		printKDistant(root, 2);
	}

	private static void printKDistant(NodeBT root, int k) {

		if (root == null)
			return;

		if (k == 0) {
			Common.print(root.data + " , ");
			return;
		}

		printKDistant(root.left, k - 1);
		printKDistant(root.right, k - 1);
	}

	private static void mirror(NodeBT root) {
		if (root == null)
			return;
		NodeBT left = root.left;
		NodeBT right = root.right;
		root.right = left;
		root.left = right;
		mirror(root.left);
		mirror(root.right);
	}

	// O(n) Worst case
	private static boolean isBalanced(NodeBT root, Height height) {
		if (root == null) {
			height.h = 0;
			return true;
		}
		Height lheight = new Height(), rheight = new Height();

		boolean lbal = isBalanced(root.left, lheight);
		boolean rBal = isBalanced(root.right, rheight);

		int lh = lheight.h;
		int rh = rheight.h;

		// Height of current node is max of heights of left and right subtrees plus 1
		height.h = Math.max(lh, rh) + 1;

		if (Math.abs(lh - rh) >= 2) {
			return false;
		}
		return lbal & rBal;
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

}
