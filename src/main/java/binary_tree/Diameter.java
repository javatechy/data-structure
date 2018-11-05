package binary_tree;

import tree.NodeBT;
import utils.Common;

public class Diameter {
	public NodeBT root;

	public static void main(String[] args) {
		NodeBT root = new NodeBT(1);
		root.left = new NodeBT(2);
		root.right = new NodeBT(3);
		root.left.left = new NodeBT(4);
		root.left.right = new NodeBT(5);
		root.left.right.right = new NodeBT(5);
		BinaryTree.inorder(root);
		Common.println("Diameter:  " + diameter(root));
	}

	public static int diameter(NodeBT node) {
		if (node == null)
			return 0;
		int leftHeight = BinaryTree.height(node.left);
		int rightHeight = BinaryTree.height(node.right);

		int dai = leftHeight + rightHeight + 1;
		int leftDia = diameter(node.left);
		int rightDia = diameter(node.right);
		return Common.max(dai, leftDia, rightDia);
	}
}
