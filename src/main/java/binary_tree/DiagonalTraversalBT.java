package binary_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tree.NodeBT;
import utils.Common;

public class DiagonalTraversalBT {

	public static void main(String[] args) {
		NodeBT root = new NodeBT(5);
		root.left = new NodeBT(6);
		root.left.left = new NodeBT(3);
		root.left.right = new NodeBT(5);
		root.right = new NodeBT(9);
		root.right.left = new NodeBT(1);
		root.right.right = new NodeBT(2);

		Map<Integer, List<Integer>> map = new HashMap<>();

		diagonalView(root, 0, map);
		Common.println(" Diagonal View");
		map.entrySet().stream().forEach((k) -> Common.println(k.getKey() + "  => " + k.getValue()));
	}

	private static void diagonalView(NodeBT root, int level, Map<Integer, List<Integer>> map) {
		if (root == null)
			return;

		List<Integer> list = map.get(level);
		Common.println(list);
		if (list == null)
			list = new ArrayList<>();
		list.add(root.data);

		map.put(level, list);
		diagonalView(root.left, level + 1, map);
		diagonalView(root.right, level, map);
	}

}
