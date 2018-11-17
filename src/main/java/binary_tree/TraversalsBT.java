package binary_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import tree.NodeBT;
import utils.Common;

public class TraversalsBT {

	public static void main(String[] args) {
		NodeBT root = BinaryTree.initialize();

		Common.println("\n------------------------------Traversals------------------------------------ ");
		BinaryTree.inorder(root);
		Common.println();
		BinaryTree.preorder(root);
		Common.println();
		BinaryTree.postorder(root);

		Common.println("\nLevel Order Traversal :  ");
		levelOrderTraversal(root);
		Common.println("\nLevel By Level  Traversal :  ");
		levelByLevelTraversal(root);
		Common.println("\n[REVERSE ]Level ORDER  Traversal :  ");
		root = BinaryTree.initialize();
		reverseLevelOrderTraversal(root);
		Common.println("\nBoundary  Traversal :  ");
		boundaryTraversal(root);

	}

	/**
	 * it has 3 parts:
	 * <li>left size all</li>
	 * <li>leaf nodes</li>
	 * <li>right size</li>
	 */
	public static void boundaryTraversal(NodeBT root) {
		Common.print(" " + root.data);
		printBoundryLeft(root.left);
		printLeaves(root);
		printBoundryRight(root.right);
	}

	public static void printLeaves(NodeBT node) {
		if (node == null) {
			return;
		}
		printLeaves(node.left);
		// Print it if it is a leaf node
		if (node.left == null && node.right == null)
			System.out.print(" " + node.data);
		printLeaves(node.right);
	}

	public static void printBoundryLeft(NodeBT leftNode) {
		if (leftNode == null) {
			return;
		}

		if (leftNode.left != null) {
			Common.print(" " + leftNode.data);
			printBoundryLeft(leftNode.left);
		} else if (leftNode.right != null) {
			Common.print(" " + leftNode.data);
			printBoundryLeft(leftNode.right);
		}
	}

	public static void printBoundryRight(NodeBT rightNode) {
		if (rightNode == null) {
			return;
		}
		if (rightNode.right != null) {
			printBoundryRight(rightNode.right);
			Common.print(" " + rightNode.data);
		} else if (rightNode.left != null) {
			printBoundryRight(rightNode.left);
			Common.print(" " + rightNode.data);
		}

	}

	public static void levelByLevelTraversal(NodeBT root) {

		Queue<NodeBT> queue = new LinkedList<>();
		queue.add(root);

		while (true) {
			int nodeCount = queue.size();
			if (nodeCount == 0)
				break;
			Common.println("--------------");
			while (nodeCount > 0) {

				NodeBT node = queue.remove();

				Common.print(":" + node.data);
				if (node.left != null)
					queue.add(node.left);

				if (node.right != null)
					queue.add(node.right);

				nodeCount--;
			}
		}
	}

	/**
	 * Use Queue or this
	 * 
	 */
	public static void levelOrderTraversal(NodeBT root) {
		int height = height(root);

		for (int l = 1; l <= height; l++) {
			printLevel(root, l);
		}

	}

	/**
	 * Use Queue or this
	 * 
	 */
	public static void reverseLevelOrderTraversal(NodeBT root) {

		if (root == null)
			return;

		Queue<NodeBT> queue = new LinkedList<>();
		Stack<NodeBT> stack = new Stack<>();

		queue.add(root);

		while (!queue.isEmpty()) {
			NodeBT btNode = queue.remove();
			stack.push(btNode);

			if (btNode.right != null) {
				queue.add(btNode.right);
			}

			if (btNode.left != null) {
				queue.add(btNode.left);
			}

		}
		while (!stack.isEmpty())
			Common.print(stack.pop().data + " , ");

	}

	public static void printLevel(NodeBT root, int level) {
		if (level <= 1 && root != null) {
			Common.print(root.data + " , ");
		}
		if (level > 1) {
			printLevel(root.left, level - 1);
			printLevel(root.right, level - 1);
		}
	}

	public static int height(NodeBT node) {
		if (node == null)
			return 0;
		return 1 + Common.max(height(node.left), height(node.right));
	}

}
