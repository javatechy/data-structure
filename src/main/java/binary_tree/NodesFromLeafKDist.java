package binary_tree;

import tree.NodeBT;

public class NodesFromLeafKDist {

	public static void main(String[] args) {
		/* Let us construct the tree shown in above diagram */
		NodeBT root = new NodeBT(1);
		root.left = new NodeBT(2);
		root.right = new NodeBT(3);
		root.left.left = new NodeBT(4);
		root.left.right = new NodeBT(5);
		root.right.left = new NodeBT(6);
		root.right.right = new NodeBT(7);
		root.right.left.right = new NodeBT(8);

		printKDistantfromLeaf(root, 1);
	}

	// // 0
	static void kDistantFromLeafUtil(NodeBT node, int path[], boolean visited[], int pathLen, int k) {
		// Base case
		if (node == null)
			return;

		/* append this Node to the path array */
		path[pathLen] = node.data;
		visited[pathLen] = false;
		pathLen++;

		/*
		 * it's a leaf, so print the ancestor at distance k only if the ancestor is not
		 * already printed
		 */

		int len = pathLen - k - 1;

		//System.out.println("len now : " + len);
		if (node.left == null && node.right == null && len >= 0 && visited[len] == false) {
			System.out.print(path[len]);
			visited[pathLen - k - 1] = true;
			return;
		}

		/* If not leaf node, recur for left and right subtrees */
		kDistantFromLeafUtil(node.left, path, visited, pathLen, k);
		kDistantFromLeafUtil(node.right, path, visited, pathLen, k);
	}

	/*
	 * Given a binary tree and a nuber k, print all nodes that are k distant from a
	 * leaf
	 */
	static void printKDistantfromLeaf(NodeBT node, int k) {
		int path[] = new int[1000];
		boolean visited[] = new boolean[1000];
		kDistantFromLeafUtil(node, path, visited, 0, k);
	}

}
