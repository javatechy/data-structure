package binary_tree;

import static utils.Common.print;
import static utils.Common.println;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import tree.Node;
import utils.Common;

public class ViewBT {
	Node<Integer> root;

	/*
	 * BinaryTree(int key) { root.data = key; }
	 */

	ViewBT() {
		root = null;
	}

	public static void main(String[] args) {
		println("Creating Binary tree");
		ViewBT tree = new ViewBT();
		tree.root = new Node<>(1);
		tree.root.left = new Node<>(2);
		tree.root.right = new Node<>(3);
		tree.root.right.left = new Node<>(6);
		tree.root.right.right = new Node<>(7);
		tree.root.left.left = new Node<>(4);
		tree.root.left.right = new Node<>(5);

		println("---------------------\nBFS ");
		tree.bfs(tree.root);

		println("---------------------\nLeft View ");
		tree.leftView(tree.root, 1);

		println("---------------------\nRight View ");

		tree.rightView(tree.root, 1);

		println("---------------------\nTOP View ");
		tree.topView(tree.root);
		Map<Integer, Node<Integer>> levelMap = new TreeMap<>();
		tree.topViewRecursive(tree.root, 0, levelMap);
		println("---------------------\nTOP View  recurisve");
		levelMap.values().forEach(t -> System.out.print("|||  level: " + t.level + " | data : " + t.data));
		println("---------------------\nBottom View ");
		tree.bottomView(tree.root);

		println("---------------------\nLine By Line ");
		tree.printLineByLine(tree.root);
	}

	private void bottomView(Node<Integer> root) {
		if (root == null)
			return;

		Map<Integer, Node<Integer>> levelMap = new TreeMap<>();
		Queue<Node<Integer>> queue = new LinkedList<>();
		root.level = 0;
		queue.add(root);

		while (!queue.isEmpty()) {
			Node<Integer> node = queue.remove();

			levelMap.put(node.level, node);

			if (node.left != null) {
				node.left.level = node.level - 1;
				queue.add(node.left);
			}

			if (node.right != null) {
				node.right.level = node.level + 1;
				queue.add(node.right);
			}
		}
		levelMap.values().forEach(t -> System.out.print(t.data));

	}

	int lef_view_max_level = 0;
	int rt_view_max_level = 0;

	private void leftView(Node<Integer> node, int level) {

		if (node == null)
			return;

		if (lef_view_max_level < level) {
			Common.print(node.data + " ,");
			lef_view_max_level = level;
		}

		leftView(node.left, level + 1);
		leftView(node.right, level + 1);
	}

	private void rightView(Node<Integer> node, int level) {

		if (node == null)
			return;

		if (rt_view_max_level < level) {
			Common.print(node.data + " ,");
			rt_view_max_level = level;
		}
		rightView(node.right, level + 1);
		rightView(node.left, level + 1);
	}

	private void topView(Node<Integer> root) {

		if (root == null)
			return;

		Map<Integer, Node<Integer>> levelMap = new TreeMap<>();
		Queue<Node<Integer>> queue = new LinkedList<>();
		root.level = 0;
		queue.add(root);

		while (!queue.isEmpty()) {
			Node<Integer> node = queue.remove();

			if (levelMap.get(node.level) == null) {
				levelMap.put(node.level, node);
			}

			if (node.left != null) {
				node.left.level = node.level - 1;
				queue.add(node.left);
			}

			if (node.right != null) {
				node.right.level = node.level + 1;
				queue.add(node.right);
			}
		}
		levelMap.values().forEach(t -> System.out.print("|||  level: " + t.level + " | data : " + t.data));

	}

	private void topViewRecursive(Node<Integer> root, int dist, Map<Integer, Node<Integer>> map) {

		if (root == null)
			return;

		if (map.get(dist) == null) {
			map.put(dist, root);
		}

		topViewRecursive(root.left, dist - 1, map);
		topViewRecursive(root.right, dist + 1, map);

	}

	//@formatter:off
	/**
	 * 
	 * Get node from the queue 
	 * 1 
	 * 2 3  now 2 beacomes node
	 * pop 2 and add left and right
	 * 3 4 5 
	 * pop 3 and add left and right
	 * 4 5 6 7
	 * @param root
	 */
	//@formatter:on
	private void bfs(Node<Integer> root) {
		Queue<Node<Integer>> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {

			Node<Integer> node = queue.poll();
			print(node.data);
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
		}
	}

	private void printLineByLine(Node<Integer> root) { // Base Case
		if (root == null)
			return;

		// Create an empty queue for level order tarversal
		Queue<Node<Integer>> queue = new LinkedList<>();
		Queue<Node<Integer>> queue2 = new LinkedList<>();
		queue.add(root);
		while (true) {
			while (!queue.isEmpty()) {
				Node<Integer> node = queue.poll();
				print(node.data);
				if (node.left != null)
					queue2.add(node.left);
				if (node.right != null)
					queue2.add(node.right);
			}
			if (queue.isEmpty()) {
				queue = queue2;
				println();
				queue2 = new LinkedList<>();
			}
			if (queue.isEmpty() && queue2.isEmpty())
				return;

		}

	}
}
