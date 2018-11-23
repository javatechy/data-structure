package binary_tree;

import java.util.Stack;

import tree.NodeBT;
import utils.Common;

public class TraversalWithoutRecursion {

	public static void main(String[] args) {
		NodeBT root = initialize();

		Common.println("\n------------------------------Traversals------------------------------------ ");
		postorder(root);

		Common.println();
		preorder(root);
		Common.println();
		inorder(root);
		Common.println();

	}

	private static void postorder(NodeBT root) {
		NodeBT node = root;
		Stack<NodeBT> childStack = new Stack<>();
		Stack<NodeBT> mainStack = new Stack<>();

		childStack.push(node);

		while (!childStack.isEmpty()) {
			node = childStack.pop();
			mainStack.push(node);
			if (node.left != null)
				childStack.push(node.left);

			if (node.right != null)
				childStack.push(node.right);

		}

		while (!mainStack.isEmpty())
			Common.print(mainStack.pop().data + " -> ");
	}

	private static void inorder(NodeBT root) {
		NodeBT node = root;
		Stack<NodeBT> stack = new Stack<>();
		// stack.push(node);

		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			Common.print(node.data + " -> ");
			node = node.right;
		}

	}

	private static void preorder(NodeBT root) {
		NodeBT node = root;
		Stack<NodeBT> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {

			node = stack.pop();
			Common.print(node.data + " -> ");
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}

	}

	static NodeBT initialize() {
		NodeBT root = new NodeBT(1);
		root.left = new NodeBT(2);
		root.right = new NodeBT(3);
		root.left.left = new NodeBT(4);
		root.left.right = new NodeBT(5);
		return root;
	}

}
