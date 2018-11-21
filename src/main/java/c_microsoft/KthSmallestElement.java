package c_microsoft;

import java.util.Arrays;
import java.util.PriorityQueue;

import utils.Common;

/**
 * https://www.geeksforgeeks.org/find-first-non-repeating-character-stream-characters/
 *
 */
public class KthSmallestElement {

	public static void main(String[] args) {
		int arr[] = { 7, 10, 4, 3, 20, 15 };

		int k = 3;

		// heap
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		Arrays.stream(arr).forEach(queue::add);

		Common.println(queue);
		int ele = arr[0];
		for (int i = 0; i < k; i++)
			ele = queue.remove();
		Common.println(queue);
	}

}
