package linkedlist;

import java.util.Objects;

import utils.Common;

/**
 * @author deepak
 */

public class SimpleLinkedList {

	public static void main(String arrp[]) {
		NodeLL third = new NodeLL(30);
		third.next = null;

		NodeLL second = new NodeLL(20);
		second.next = third;

		NodeLL first = new NodeLL(10);
		first.next = second;

		NodeLL head = first;

		head = insertAtFront(first);

		printLl(head);
	}

	private static NodeLL insertAtFront(NodeLL first) {
		NodeLL head;
		NodeLL frontInsert = new NodeLL(90);
		frontInsert.next = first;
		head = frontInsert;
		return head;
	}

	private static void printLl(NodeLL first) {
		NodeLL n = first;

		while (Objects.nonNull(n)) {
			Common.println(n.data);
			n = n.next;
		}

	}

}
