package binary_tree;

import tree.NodeBT;
import utils.Common;

class Height {
	int h;
}

public class Diameter {
	public NodeBT root;

	public static void main(String[] args) {
		NodeBT root = new NodeBT(1);
		root.left = new NodeBT(2);
		root.right = new NodeBT(3);
		root.right.left = new NodeBT(9);
		root.right.right = new NodeBT(8);
		root.left.left = new NodeBT(4);
		root.left.right = new NodeBT(5);
		root.left.right.right = new NodeBT(7);
		BinaryTree.inorder(root);
		Common.println("Diameter:  " + diameter(root));

		Height height = new Height();
		Common.println("Diameter:  " + diameterOpt(root, height));

	}

	/**
	 * On2 complexity
	 * 
	 * @param node
	 * @return
	 */
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

	/**
	 * In O(n) complexity
	 * 
	 * @param root
	 * @param height
	 * @return
	 */
	static int diameterOpt(NodeBT root, Height height) {
		Height leftHeight = new Height();
		Height rightHeight = new Height();

		if (root == null) {
			Common.println("Root is null");
			height.h = 0;
			return 0; /* diameter is also 0 */
		}

		Common.println("BEFORE REC: diameterOpt(" + root.data + ", " + height.h);

		int ldiameter = diameterOpt(root.left, leftHeight);
		int rdiameter = diameterOpt(root.right, rightHeight);

		height.h = Math.max(leftHeight.h, rightHeight.h) + 1;
		Common.println("AFTER REC : diameterOpt(" + root.data + ", " + height.h + ")");
		Common.println("Compairing : Math.max(ldiameter, rdiameter) : " + Math.max(ldiameter, rdiameter) + " and "
				+ (leftHeight.h + rightHeight.h + 1));
		return Math.max(leftHeight.h + rightHeight.h + 1, Math.max(ldiameter, rdiameter));
	}
}
