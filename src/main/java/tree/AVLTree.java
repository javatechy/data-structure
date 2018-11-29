package tree;

import binary_tree.BinaryTree;
import utils.Common;

public class AVLTree {

	public static void main(String args[]) {

		NodeBT root = BinarySearchTree.createBST(30, 10, 20);
		insert(root, 4);
		insert(root, 6);
		BinaryTree.preorder(root);

//		NodeBT search = search(root, 0);
	//	Common.println("\nNode found " + search(root, 0).data);

	}

	public static NodeBT insert(NodeBT root, int data) {

		if (root == null) {
			root = new NodeBT(data);
			return root;
		}
		if (data < root.data) {
			root.left = insert(root.left, data);
		} else {
			root.right = insert(root.right, data);
		}
		return root;
	}

	public static NodeBT delete(NodeBT node, int data) {
		return node;
		
	}

}
