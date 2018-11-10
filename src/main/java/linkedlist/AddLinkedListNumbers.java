package linkedlist;

import utils.Common;

/**
 * @author deepak
 */
public class AddLinkedListNumbers {

	public static void main(String[] args) {
		NodeLL firstLL = new NodeLL(1);
		firstLL.next = new NodeLL(2);
		firstLL.next.next = new NodeLL(3);
		firstLL.next.next.next = new NodeLL(4);

		NodeLL secondLL = new NodeLL(1);
		secondLL.next = new NodeLL(2);
		secondLL.next.next = new NodeLL(3);
		addLL(firstLL, secondLL, 0);
	}

	private static void addLL(NodeLL firstLL, NodeLL secondLL, int carry) {
		if(firstLL ==null || )
	}
}
