package binary_tree;

import tree.NodeBT;
import utils.Common;

public class AncestorOfNode {

	public static void main(String[] args) {
		NodeBT root = new NodeBT(5);
		root.left = new NodeBT(6);
		root.left.left = new NodeBT(3);
		root.left.right = new NodeBT(5);
		root.right = new NodeBT(9);
		root.right.left = new NodeBT(1);
		root.right.right = new NodeBT(2);

		pathToLeafNodes(root, "", "9");
		printAncestors(root, 2);
	}

	private static void pathToLeafNodes(NodeBT root, String string, String node) {
		if (root == null) {
			return;
		}
		pathToLeafNodes(root.left, string + " -> " + root.data, node);
		pathToLeafNodes(root.right, string + " -> " + root.data, node);

		String result = string + "-> " + root.data + " | ";
		if (result.contains(node))
			Common.println(result + result.contains(node));
		return;

	}

	static boolean printAncestors(NodeBT node, int target) {
		/* base cases */
		if (node == null)
			return false;

		if (node.data == target)
			return true;

		/*
		 * If target is present in either left or right subtree of this node, then print
		 * this node
		 */
		if (printAncestors(node.left, target) || printAncestors(node.right, target)) {
			System.out.print(node.data + " ");
			return true;
		}

		/* Else return false */
		return false;
	}
}
