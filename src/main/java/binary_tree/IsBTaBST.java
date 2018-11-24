package binary_tree;

import tree.NodeBT;
import utils.Common;

public class IsBTaBST {

	public static void main(String[] args) {
		NodeBT root = new NodeBT(2);
		root.left = new NodeBT(1);
		root.right = new NodeBT(3);

		Common.println("Is bst : " + isBST(root, null, null));
	}

	private static boolean isBST(NodeBT root, NodeBT leftNode, NodeBT rightNode) {
		// Base condition
		if (root == null)
			return true;

		// if left node exist then check it has
		// correct data or not i.e. left node's data
		// should be less than root's data
		if (leftNode != null && root.data < leftNode.data)
			return false;

		// if right node exist then check it has
		// correct data or not i.e. right node's data
		// should be greater than root's data
		if (rightNode != null && root.data > rightNode.data)
			return false;

		// check recursively for every node.
		return isBST(root.left, leftNode, root) && isBST(root.right, root, rightNode);
	}

}
