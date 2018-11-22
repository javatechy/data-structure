package tree;

import java.util.LinkedList;
import java.util.List;

import binary_tree.BinaryTree;
import binary_tree.SearchBT;
import utils.Common;

/**
 * Can Also be used to calculate distance between any 2 nodes.
 * 
 * @author deepak
 *
 */
public class LowestCommonAncestor {

	public static void main(String args[]) {
		NodeBT root = BinarySearchTree.createBST(8, 6, 10, 2, 7, 9, 11);
		BinaryTree.inorder(root);
		Common.println(lca(root, 2, 7));
	}

	private static int lca(NodeBT root, int first, int second) {
		List<Integer> firstList = new LinkedList<>();
		List<Integer> secondList = new LinkedList<>();

		boolean findPathSecond = SearchBT.searchPath(root, second, secondList);
		boolean findPathFirst = SearchBT.searchPath(root, first, firstList);
		if (!findPathFirst || !findPathSecond)
			return -1;

		Common.println("--FIR--" + firstList);
		Common.println("--SIR--" + secondList);

		for (int i = 0; i < firstList.size() && i < secondList.size(); i++) {
			if (firstList.get(i) == secondList.get(i))
				return firstList.get(i);
		}
		return -1;

	}

	static boolean findPathInReverseOrder(NodeBT root, int element, List<Integer> path) {
		if (root == null)
			return true;
		if (root.data == element || findPathInReverseOrder(root.left, element, path)
				|| findPathInReverseOrder(root.right, element, path)) {
			path.add(root.data);
			return true;

		}
		return false;

	}

}
