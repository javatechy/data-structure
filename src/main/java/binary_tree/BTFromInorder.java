package binary_tree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import tree.NodeBT;

public class BTFromInorder {

	public static void main(String[] args) {
		int in[] = new int[] { 9, 8, 4, 2, 10, 5, 10, 1, 6, 3, 13, 12, 7 };
		int pre[] = new int[] { 1, 2, 4, 8, 9, 5, 10, 10, 3, 6, 7, 12, 13 };
		int len = in.length;

		NodeBT root = buildTree(pre, in);

		BinaryTree.inorder(root);
	}

	static Set<NodeBT> set = new HashSet<>();
	static Stack<NodeBT> stack = new Stack<>();

	// Function to build tree using given traversal
	public static NodeBT buildTree(int[] preorder, int[] inorder) {

		NodeBT root = null;
		// looping preorder
		for (int pre = 0, in = 0; pre < preorder.length;) {

			NodeBT node = null;
			do {
				node = new NodeBT(preorder[pre]);
				if (root == null) {
					root = node;
				}
				if (!stack.isEmpty()) {
					if (set.contains(stack.peek())) {
						set.remove(stack.peek());
						stack.pop().right = node;
					} else {
						stack.peek().left = node;
					}
				}
				stack.push(node);
			} while (preorder[pre++] != inorder[in] && pre < preorder.length);

			node = null;
			while (!stack.isEmpty() && in < inorder.length && stack.peek().data == inorder[in]) {
				node = stack.pop();
				in++;
			}

			if (node != null) {
				set.add(node);
				stack.push(node);
			}
		}

		return root;
	}

}
