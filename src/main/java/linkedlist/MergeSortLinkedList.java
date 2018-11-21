package linkedlist;

public class MergeSortLinkedList {

	NodeLL head = null;

	public static void main(String[] args) {
		NodeLL head1 = ArrayToLinkedList.convert(1, 4, 6, 7, 8, 9);
		NodeLL head2 = ArrayToLinkedList.convert(1, 7, 8, 20, 80, 91);
		NodeLL root = sortedMerge(head1, head2);
		LinkedList.print(root);
	}

	private static NodeLL sortedMerge(NodeLL a, NodeLL b) {
		NodeLL result = null;
		/* Base cases */
		if (a == null)
			return b;
		if (b == null)
			return a;

		/* Pick either a or b, and recur */
		if (a.data <= b.data) {
			result = a;
			result.next = sortedMerge(a.next, b);
		} else {
			result = b;
			result.next = sortedMerge(a, b.next);
		}
		return result;

	}

	private NodeLL mergeSort(NodeLL h) {
		// Base case : if head is null
		if (h == null || h.next == null) {
			return h;
		}

		// get the middle of the list
		NodeLL middle = LinkedList.middleElement(h);
		NodeLL nextofmiddle = middle.next;

		// set the next of middle NodeLL to null
		middle.next = null;

		// Apply mergeSort on left list
		NodeLL left = mergeSort(h);

		// Apply mergeSort on right list
		NodeLL right = mergeSort(nextofmiddle);

		// Merge the left and right lists
		NodeLL sortedlist = sortedMerge(left, right);
		return sortedlist;
	}

}
