package binary_tree;

import tree.NodeBT;
import utils.Common;

public class BinaryTree {

	public NodeBT root;

	public static void main(String[] args) {
		NodeBT root = initialize();
		root.right.left = new NodeBT(15);
		root = initialize();
		inorder(root);
		Common.println("\nIs Balanced:  " + isBalanced(root));
		Common.println("\nPrint K Distant nodes:  ");
	}

	static NodeBT initialize() {
		NodeBT root = new NodeBT(10);
		root.left = new NodeBT(8);
		root.right = new NodeBT(2);
		root.left.left = new NodeBT(3);
		root.left.right = new NodeBT(5);
		root.right.right = new NodeBT(12);

		return root;
	}

	public static void inorder(NodeBT root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		Common.print(" " + root.data);
		inorder(root.right);
	}

	public static int height(NodeBT node) {
		if (node == null)
			return 0;
		return 1 + Common.max(height(node.left), height(node.right));
	}

	public static void postorder(NodeBT root) {
		if (root == null) {
			return;
		}
		postorder(root.left);
		postorder(root.right);
		Common.print(" " + root.data);
	}

	public static void preorder(NodeBT root) {
		if (root == null) {
			return;
		}
		Common.print(" " + root.data);
		preorder(root.left);
		preorder(root.right);
	}

	// O(n^2) Worst case occurs in case of skewed tree.
	public static boolean isBalanced(NodeBT root) {
		if (root == null)
			return true;
		int lh = BinaryTree.height(root.left);
		int rh = BinaryTree.height(root.right);

		if (Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right)) {
			return true;
		}
		return false;
	}

}
