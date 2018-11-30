package binary_tree;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintPostOrderFromPreOrderInOrder {

	public int[] postOrder(int[] preorder, int[] inorder) {
		int[] post = new int[inorder.length];
		AtomicInteger postIndex = new AtomicInteger(post.length - 1);
		postOrder(preorder, inorder, post, 0, inorder.length - 1, 0, postIndex);
		return post;
	}

	private void postOrder(int[] preorder, int[] inorder, int post[], int low, int high, int preIndex,
			AtomicInteger postIndex) {
		if (low > high || preIndex < 0 || postIndex.get() < 0) {
			return;
		}
		post[postIndex.getAndDecrement()] = preorder[preIndex];
		int i;
		for (i = 0; i < inorder.length; i++) {
			if (preorder[preIndex] == inorder[i]) {
				break;
			}
		}
		postOrder(preorder, inorder, post, i + 1, high, preIndex + (i - low) + 1, postIndex);
		postOrder(preorder, inorder, post, low, i - 1, preIndex + 1, postIndex);
	}

	public static void main(String args[]) {
		int preorder[] = { 1, 2, 4, 5, 3, 6 };
		int inorder[] = { 4, 2, 5, 1, 3, 6 };

		PrintPostOrderFromPreOrderInOrder ppp = new PrintPostOrderFromPreOrderInOrder();
		int postorder[] = ppp.postOrder(preorder, inorder);
		for (int i : postorder) {
			System.out.print(i + " ");
		}
	}
}
