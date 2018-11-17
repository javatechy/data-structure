package linkedlist;

import utils.Common;

public class LinkedListReversed {

	public static void main(String args[]) {
		NodeLL head = ArrayToLinkedList.convert(1, 2, 3, 4, 5);
		print(head);
		Common.println();
		reverse(head);
		
		
	}

	
	// Head recursion
	private static void reverse(NodeLL head) {
		if (head == null)
			return;
		reverse(head.next);
		Common.print(head.data);
	}

	// Tail Recursion
	private static void print(NodeLL head) {
		if (head == null)
			return;
		Common.print(head.data);
		print(head.next);
	}

}
