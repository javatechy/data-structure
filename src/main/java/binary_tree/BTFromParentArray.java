package binary_tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import tree.NodeBT;
import utils.Common;

class Child {
	private NodeBT left;
	private NodeBT right;

	public Child(int ele) {
		left = new NodeBT(ele);
	}

	public NodeBT getLeft() {
		return left;
	}

	public NodeBT getRight() {
		return right;
	}

	public String toString() {
		String str = "";
		if (left != null)
			str += "left: " + left.data;
		if (right != null)
			str += "right :  " + right.data;
		return str;
	}

	public Child setRight(int i) {
		right = new NodeBT(i);
		return this;
	}

}

public class BTFromParentArray {

	public NodeBT root;

	public static void main(String[] args) {

		int parent[] = { 1, 5, 5, 2, 2, -1, 3 };

		Map<Integer, Child> map = new HashMap<>();

		buildMap(parent, map);

		NodeBT root = buildTree(map);
		BinaryTree.inorder(root);
	}

	private static NodeBT buildTree(Map<Integer, Child> map) {
		Queue<NodeBT> queue = new LinkedList<>();

		NodeBT root = map.get(-1).getLeft();
		queue.add(root);
		Common.println("Added value root: " + root.data);

		map.forEach((k, v) -> {
			Common.println("k: " + k);
			Common.println("val: " + v);
		});
		while (!queue.isEmpty()) {
			NodeBT node = queue.remove();
			Common.println("node: " + node.data);
			if (map.get(node.data) == null)
				continue;
			node.left = map.get(node.data).getLeft();
			node.right = map.get(node.data).getRight();
			if (node.right != null)
				queue.add(node.right);
			if (node.left != null)
				queue.add(node.left);

		}
		return root;

	}

	private static void buildMap(int[] parent, Map<Integer, Child> map) {
		for (int i = 0; i < parent.length; i++) {

			if (map.get(parent[i]) == null) {
				Common.println(parent[i] + " , " + i);
				map.put(parent[i], new Child(i));
				continue;
			}
			Common.println(parent[i] + " , " + i);
			map.put(parent[i], map.get(parent[i]).setRight(i));
		}
	}

}
