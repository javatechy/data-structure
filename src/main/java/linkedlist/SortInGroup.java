package linkedlist;

import utils.Common;

/**
 * @author deepak L = 4 -> 8 -> 3 -> 9 -> 1 -> 3 -> 6 -> 7 -> 5 -> 2 -> null and
 *         batch size is k = 4
 */
public class SortInGroup {

	private static NodeLL inilialzeLL() {
		NodeLL head = new NodeLL(4);
		head.next = new NodeLL(8);
		head.next.next = new NodeLL(3);
		head.next.next.next = new NodeLL(9);
		head.next.next.next.next = new NodeLL(1);
		head.next.next.next.next.next = new NodeLL(3);
		head.next.next.next.next.next.next = new NodeLL(6);
		head.next.next.next.next.next.next.next = new NodeLL(7);
		head.next.next.next.next.next.next.next.next = new NodeLL(5);
		head.next.next.next.next.next.next.next.next.next = new NodeLL(2);
		return head;
	}

	public static void main(String[] args) {
		/* Start with the empty list. */
		NodeLL head = inilialzeLL();
		printLinkedList(head);
		int k = 4;
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
