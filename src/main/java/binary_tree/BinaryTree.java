package binary_tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tree.NodeBT;
import utils.Common;

public class BinaryTree {

	public NodeBT root;

	public static void main(String[] args) {
		NodeBT root = initialize();

		Common.println("\n------------------------------Traversals------------------------------------ ");
		inorder(root);
		Common.println();
		preorder(root);
		Common.println();
		postorder(root);

		Common.println("\nLevel Order Traversal :  ");
		levelOrderTraversal(root);
		Common.println("\nLevel By Level  Traversal :  ");
		levelByLevelTraversal(root);

		Common.println("\nBoundary  Traversal :  ");
		boundaryTraversal(root);

		Common.println("\n------------------------------searching and path------------------------------------ ");
		// searching and path
		int search = 1233;
		Common.println("\nSearching :  " + searchNode(root, search));
		LinkedList<Integer> path = new LinkedList<>();
		searchPath(root, search, path);
		Common.println("\nSearching pATH :  " + path);

		// mirroring
		root = initialize();
		root.right.right.right = new NodeBT(19);
		Common.println("\nMirror (Inorder):  ");
		mirror(root);
		inorder(root);

	}

	private static NodeBT initialize() {
		NodeBT root = new NodeBT(10);
		root.left = new NodeBT(8);
		root.right = new NodeBT(2);
		root.left.left = new NodeBT(3);
		root.left.right = new NodeBT(5);
		root.right.right = new NodeBT(12);

		return root;
	}

	public static void mirror(NodeBT root) {
		if (root == null)
			return;
		NodeBT left = root.left;
		NodeBT right = root.right;
		root.right = left;
		root.left = right;
		mirror(root.left);
		mirror(root.right);
	}

	/**
	 * it has 3 parts:
	 * <li>left size all</li>
	 * <li>leaf nodes</li>
	 * <li>right size</li>
	 * 
	 * @param root
	 */
	public static void boundaryTraversal(NodeBT root) {
		Common.println(root.data);
		printBoundryLeft(root.left);
		printLeaves(root);
		printBoundryRight(root.right);
	}

	private static void printLeaves(NodeBT root) {

	}

	private static void printBoundryLeft(NodeBT leftNode) {
		if (leftNode == null) {
			return;
		}

		Common.println(leftNode.data);
		printBoundryLeft(leftNode.left);
	}

	private static void printBoundryRight(NodeBT rightNode) {
		if (rightNode == null) {
			return;
		}
		printBoundryRight(rightNode.right);
		Common.println(rightNode.data);
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

	public static boolean searchNode(NodeBT root, int element) {
		if (root == null) {
			return false;
		}
		Common.print(" " + root.data);
		if (element == root.data) {
			return true;
		}
		return searchNode(root.left, element) || searchNode(root.right, element);
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

	private static void printLevel(NodeBT root, int level) {
		if (level <= 1 && root != null) {
			Common.print(root.data + " , ");
		}
		if (level > 1) {
			printLevel(root.left, level - 1);
			printLevel(root.right, level - 1);
		}
	}

	public static boolean searchPath(NodeBT root, int element, List<Integer> path) {
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

	public static void inorder(NodeBT root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		Common.print(" " + root.data);
		inorder(root.right);
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

	public static int height(NodeBT node) {
		if (node == null)
			return 0;
		return 1 + Common.max(height(node.left), height(node.right));
	}

}
