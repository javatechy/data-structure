package tree;

import java.util.LinkedList;
import java.util.List;

import utils.Common;

/**
 * Can Also be used to calculate distance between any 2 nodes.
 * 
 * @author deepak
 *
 */
public class LowestCommonAncestor {

	public static void main(String args[]) {
		BinaryTree bt = BinaryTree.createBinaryTree(8, 6, 10, 2, 7, 9, 11);
		NodeBT root = bt.root;

		// BinaryTree.inorder(root);
		lca(root, 2, 7);
		// lca(root, root, 2, 6);

	}

	private static void lca(NodeBT root, int first, int second) {
		List<NodeBT> firstList = new LinkedList<>();
		List<NodeBT> secondList = new LinkedList<>();

		NodeBT fbt = root;
		firstList.add(fbt);
		secondList.add(fbt);
		while (fbt != null) {
			if (first < fbt.data) {
				fbt = fbt.left;
			} else {
				fbt = fbt.right;
			}
			if (fbt != null)
				firstList.add(fbt);
		}

		fbt = root;
		while (fbt != null) {
			if (second < fbt.data) {
				fbt = fbt.left;
			} else {
				fbt = fbt.right;
			}
			if (fbt != null)
				secondList.add(fbt);
		}
		Common.println("--FIR--");
		firstList.forEach(t -> System.out.print(" " + t.data));
		Common.println("--SEC--");
		secondList.forEach(t -> System.out.print(" " + t.data));

		for (NodeBT node : firstList) {
			if (secondList.remove(node))
				fbt = node;
		}
		Common.println("--LCA--" + fbt.data);

	}

}
