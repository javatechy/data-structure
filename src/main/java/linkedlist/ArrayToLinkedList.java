package linkedlist;

import java.util.Objects;

import utils.Common;

public class ArrayToLinkedList {

	public static void main(String[] args) {
		NodeLL head = convert(1, 1, 2, 2, 2, 3, 4, 4, 4, 4, 9, 9);
		print(head);
		head = removeDuplicates(head);
		print(head);
		Common.print("Lenght " + len(head));
	}

	private static void print(NodeLL head) {
		NodeLL n = head;

		while (Objects.nonNull(n)) {
			Common.print(n.data + " ");
			n = n.next;
		}
		Common.println();

	}

	public static NodeLL convert(int... arr) {
		NodeLL head = new NodeLL(arr[0]);

		NodeLL pointer = head;
		for (int i = 1; i < arr.length; i++) {
			NodeLL newNode = new NodeLL(arr[i]);
			pointer.next = newNode;
			pointer = newNode;
		}
		return head;
	}
	
	public static NodeLL circular(int... arr) {
		NodeLL head = new NodeLL(arr[0]);

		NodeLL pointer = head;
		for (int i = 1; i < arr.length; i++) {
			NodeLL newNode = new NodeLL(arr[i]);
			pointer.next = newNode;
			pointer = newNode;
		}
		pointer.next =head;
		return head;
	}

	private static NodeLL removeDuplicates(NodeLL head) {
		NodeLL pointer = head;

		int data = head.data;
		pointer = head.next;

		NodeLL prev = head;
		while (pointer != null) {
			if (pointer.data == data) {
				prev.next = pointer.next;
				pointer = prev.next;
				continue;
			} else {
				data = pointer.data;
				prev = pointer;
				pointer = pointer.next;

			}
		}
		return head;
	}
	
	private static int len(NodeLL head) {
		NodeLL pointer = head;
		int count = 0;
		while (pointer != null) {
			count++;
			pointer = pointer.next;
		}
		return count;
	}
}
