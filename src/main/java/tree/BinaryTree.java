package tree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

import static utils.Common.*;

public class BinaryTree {
	Node<Integer> root;

	/*
	 * BinaryTree(int key) { root.data = key; }
	 */

	BinaryTree() {
		root = null;
	}

	// Wrappers over above recursive functions
	void printPostorder() {
		printInorder(root);
	}

	public static void main(String[] args) {
		println("Creating Binary tree");
		BinaryTree tree = new BinaryTree();
		tree.root = new Node<>(1);
		tree.root.left = new Node<>(2);
		tree.root.right = new Node<>(3);
		tree.root.right.left = new Node<>(6);
		tree.root.right.right = new Node<>(7);
		tree.root.left.left = new Node<>(4);
		tree.root.left.right = new Node<>(5);

		println("\nIn order");
		tree.printInorder(tree.root);

		println("\nPre Order");
		tree.printPreOrder(tree.root);

		println("\nPost order");
		tree.printPostOrder(tree.root);

		println("\nBFS ");
		tree.bfs(tree.root);

		println("\nLine By Line ");
		tree.printLineByLine(tree.root);
	}

	private void printPreOrder(Node<Integer> root) {
		if (Objects.isNull(root)) {
			return;
		}
		print(root.data);
		printPreOrder(root.left);
		printPreOrder(root.right);

	}

	private void printInorder(Node<Integer> node) {
		if (Objects.isNull(node)) {
			return;
		}
		printInorder(node.left);
		print(node.data);
		printInorder(node.right);

	}

	private void printPostOrder(Node<Integer> root) {
		if (Objects.isNull(root)) {
			return;
		}
		printPostOrder(root.left);
		printPostOrder(root.right);
		print(root.data);

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
