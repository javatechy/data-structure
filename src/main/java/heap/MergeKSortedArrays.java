package heap;

import java.util.PriorityQueue;

import utils.Common;

class QueueNode implements Comparable<QueueNode> {
	int array, index, value;

	public QueueNode(int array, int index, int value) {
		super();
		this.array = array;
		this.index = index;
		this.value = value;
	}

	@Override
	public int compareTo(QueueNode node) {
		if (this.value > node.value)
			return 1;
		return -1;
	}

}

public class MergeKSortedArrays {
	public static void main(String[] args) {
		//@// @formatter:off
 
		int arr[][] = { { 1, 2, 32, 46 },
						{ 4, 5, 15, 18, 20 }, 
						{ 3 }, 
						{ 6, 8 } 
					};
		// @formatter:on

		System.out.println("after sorting");
		Common.printArray(mergeKSortedArrays(arr, arr.length));
	}

	public static int[] mergeKSortedArrays(int[][] arr, int k) {

		PriorityQueue<QueueNode> queue = new PriorityQueue<>();

		int size = 0;

		for (int i = 0; i < k; i++) {
			size += arr[i].length;
			if (arr[i].length > 0) {
				queue.add(new QueueNode(i, 0, arr[i][0]));
			}
		}

		int[] result = new int[size];

		for (int i = 0; i < size && !queue.isEmpty(); i++) {
			QueueNode node = queue.remove();
			result[i] = node.value;
			int nextIndex = node.index + 1;
			if (arr[node.array].length > node.index + 1)
				queue.add(new QueueNode(node.array, node.index + 1, arr[node.array][nextIndex]));
		}

		return result;

	}

}
