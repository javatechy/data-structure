package binary_tree;

import tree.NodeBT;
import utils.Common;

public class PrintPathToAllLeaves {

	public static void main(String[] args) {
		NodeBT root = new NodeBT(5);
		root.left = new NodeBT(6);
		root.left.left = new NodeBT(3);
		root.left.right = new NodeBT(5);
		root.right = new NodeBT(9);
		root.right.left = new NodeBT(1);
		root.right.right = new NodeBT(2);

		pathToLeafNodes(root, "");
	}

	private static void pathToLeafNodes(NodeBT root, String string) {
		if (root == null) {
			return;
		}

		pathToLeafNodes(root.left, string + " -> " + root.data);
		pathToLeafNodes(root.right, string + " -> " + root.data);
		if (root.left == null && root.right == null) {
			Common.println(string + "-> " + root.data);
			return;
		}


	}
}
