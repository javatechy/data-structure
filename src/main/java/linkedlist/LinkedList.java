package linkedlist;

import utils.Common;

/**
 * @author deepak
 */
public class LinkedList {

	public static void main(String[] args) {
		/* Start with the empty list. */
		NodeLL head = ArrayToLinkedList.convert(1, 2, 3, 4, 5, 6, 7, 8, 9);
		head = reverse(head);
		Common.println("\nReversed");
		printLinkedList(head);

		head = ArrayToLinkedList.convert(1);
		printLinkedList(head);
		Common.println("\nMiddle: " + middleElement(head).data);

		head = ArrayToLinkedList.convert(1, 2, 3, 4, 5, 6, 7, 8, 9);
		printLinkedList(head);
		int k = 3;
		head = reverseInGrup(head, k);
		Common.println("\nReversed in GROUP");
		printLinkedList(head);

	}

	private static NodeLL reverseInGrup(NodeLL head, int k) {
		int temp = k;
		NodeLL current = head;
		NodeLL prev = null;
		NodeLL next = null;

		while (k != 0 && current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			k--;
		}

		k = temp;

		/*
		 * next is now a pointer to (k+1)th node Recursively call for the list starting
		 * from current. And make rest of the list as next of first node
		 */
		if (next != null)
			head.next = reverseInGrup(next, k);

		// prev is now head of input list
		return prev;
	}

	private static NodeLL sortInGroup(NodeLL head, int k) {
		int temp = k;
		NodeLL current = head;
		NodeLL prev = null;
		NodeLL next = null;

		while (k != 0 && current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			k--;
		}

		k = temp;

		/*
		 * next is now a pointer to (k+1)th node Recursively call for the list starting
		 * from current. And make rest of the list as next of first node
		 */
		if (next != null)
			head.next = reverseInGrup(next, k);

		// prev is now head of input list
		return prev;
	}

	public static NodeLL middleElement(NodeLL head) {
		if (head == null)
			return head;

		if (head.next == null)
			return head;

		NodeLL slow = head;

		NodeLL fast = head.next;

		while (fast != null && fast.next != null) {

			slow = slow.next;

			fast = fast.next.next;
		}

		return slow;
	}

	static void printLinkedList(NodeLL head) {
		System.out.println();
		NodeLL n = head;
		while (n != null) {
			System.out.print(n.data + "  -> ");
			n = n.next;
		}
	}

	static void addANewElement(NodeLL head, int newData) {
		NodeLL node = new NodeLL(30);
		node.next = head;
		head = node;
	}

	static NodeLL reverse(NodeLL head) {
		NodeLL prev = null;
		NodeLL current = head;
		NodeLL next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		head = prev;
		return head;
	}
}
