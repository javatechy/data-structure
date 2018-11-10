package airtel;

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
		if (low > high) {
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
		int preorder[] = { 37, 41, 43, 13, 5, 11, 29, 23, 2, 17, 47, 7, 3, 19, 31 };
		int inorder[] = { 13, 5, 43, 11, 41, 2, 23, 17, 29, 47, 37, 3, 7, 31, 19 };
		PrintPostOrderFromPreOrderInOrder ppp = new PrintPostOrderFromPreOrderInOrder();
		int postorder[] = ppp.postOrder(preorder, inorder);
		for (int i : postorder) {
			System.out.print(i + " ");
		}
	}
}
