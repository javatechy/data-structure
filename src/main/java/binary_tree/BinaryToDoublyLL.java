package binary_tree;

import linkedlist.NodeLL;
import tree.NodeBT;
import utils.Common;

public class BinaryToDoublyLL {
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
		btToDll(root);
		while (head != null) {
			Common.print(" : " + head.data);
			head = head.next;
		}
	}

	static NodeLL head = null;

	static NodeLL nodeLL = null;

	private static void btToDll(NodeBT rootBT) {
		if (rootBT == null) {
			return;
		}
		btToDll(rootBT.left);
		// Common.println(" Working on : " + rootBT.data);
		if (nodeLL != null) {
			// Common.println(" Next Node");
			nodeLL.next = new NodeLL(rootBT.data);
			nodeLL.next.prev = nodeLL;
			nodeLL = nodeLL.next;
		} else {
			// Common.println(" Adding new Node");
			nodeLL = new NodeLL(rootBT.data);
			head = nodeLL;
		}
		btToDll(rootBT.right);
	}

}
