package c_microsoft;

import linkedlist.ArrayToLinkedList;
import linkedlist.NodeLL;
import utils.Common;

public class PairWiseSwapLL {

	public static void main(String[] args) {

		NodeLL head = ArrayToLinkedList.convert(1, 2, 3, 4, 5);
		linkedlist.LinkedList.print(head);
		Common.println("After Swapping");
		swapInPair(head);
		linkedlist.LinkedList.print(head);
	}

	private static NodeLL swapInPair(NodeLL head) {

		NodeLL node = head;
		while (node != null && node.next != null) {
			int temp = node.data;
			node.data = node.next.data;
			node.next.data = temp;
			node = node.next.next;
		}
		return head;
	}

}
