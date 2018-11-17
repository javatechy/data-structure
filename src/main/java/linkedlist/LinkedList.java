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
		print(head);

		head = ArrayToLinkedList.convert(1);
		print(head);
		Common.println("\nMiddle: " + middleElement(head).data);

		head = ArrayToLinkedList.convert(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Common.println("\n Delete Middle: ");
		deleteMiddle(head);
		print(head);

		head = ArrayToLinkedList.convert(1, 2, 3, 4, 5, 6, 7, 8, 9);
		print(head);
		int k = 3;
		head = reverseInGrup(head, k);
		Common.println("\nReversed in GROUP");
		print(head);
		Common.println("\nAdding List ");
		head = addLists(ArrayToLinkedList.convert(9, 2), ArrayToLinkedList.convert(1, 2, 3));
		print(head);
	}

	/**
	 * : O(m + n) where m and n are number of nodes in first and second lists
	 * respectively.
	 */
	private static NodeLL addLists(NodeLL list1, NodeLL list2) {

		NodeLL head = null;
		int carry = 0;
		NodeLL pos = head;

		while (list1 != null || list2 != null) {
			int sum = carry;
			if (list1 != null) {
				sum += list1.data;
				list1 = list1.next;

			}
			if (list2 != null) {
				sum += list2.data;
				list2 = list2.next;
			}
			if (sum > 9) {
				carry = 1;
				sum = sum % 10;
			} else {
				carry = 0;
			}

			NodeLL dataNode = new NodeLL(sum);
			if (pos == null) {
				head = dataNode;
				pos = head;
			} else {
				pos.next = dataNode;
				pos = pos.next;
			}

		}

		if (carry != 0)
			pos.next = new NodeLL(1);
		return head;

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

	public static NodeLL deleteMiddle(NodeLL head) {
		if (head == null)
			return head;

		if (head.next == null)
			return head;

		NodeLL slow = head;

		NodeLL prev = slow;
		NodeLL fast = head.next;

		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;

			fast = fast.next.next;
		}

		prev.next = slow.next;
		return prev;
	}

	public static void print(NodeLL head) {
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
