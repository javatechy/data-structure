package linkedlist;

import utils.Common;

/**
 * @author deepak
 */

public class CirculatLinkedList {

	public static void main(String arrp[]) {

		NodeLL head = ArrayToLinkedList.circular(3, 7, 9, 11);

		printLl(head);

		insertInSortedOrder(head, 8);
		insertInSortedOrder(head, 6);
		insertInSortedOrder(head, 0);
		insertInSortedOrder(head, 16);
	}

	private static void insertInSortedOrder(NodeLL head, int element) {
		NodeLL current = head;
		NodeLL newNode = new NodeLL(element);
		NodeLL prev = head;

		if (element < head.data) {
			head = newNode;
			newNode.next = current;

			while (current.data < current.next.data)
				current = current.next;
			current.next = head;
			printLl(head);
			return;
		}

		boolean isMatched = false;
		while (current.data < current.next.data) {
			if (current.data > element) {
				isMatched = true;
				break;
			}
			prev = current;
			current = current.next;
		}

		if (!isMatched)
			prev = prev.next;
		NodeLL temp = prev.next;
		prev.next = newNode;
		newNode.next = temp;

		printLl(head);
	}

	private static void printLl(NodeLL head) {
		if (head == null)
			return;
		NodeLL n = head;

		do {
			Common.print(n.data + " ,  ");
			n = n.next;
		} while (n != head);
		Common.println();

	}

}
