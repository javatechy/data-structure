package heap;

import utils.Common;

public class HeapSort {// Java program for implementation of Heap Sort

	// Driver program
	public static void main(String args[]) {
		int arr[] = { 34, 4, 23, 2, 12, 11, 13, 5, 6, 7 };
		Common.printArray(arr);

		int length = arr.length;
		heapify(arr, 0, length - 1);
		Common.printArray(arr);

		for (int j = length, k = 0; j > 0 && k < length; k++, j--) {
			heapify(arr, 0, j - 1);
			Common.printArray(arr);
			Common.println("\nSwapping(" + (j - 1) + " and " + k + " ) ");
			int temp = arr[j - 1];
			arr[j - 1] = arr[0];
			arr[0] = temp;
			Common.printArray(arr);
		}
	}

	private static void heapify(int[] arr, int startIndex, int n) {
		if (n < startIndex)
			return;
		int parent = 0;
		if (n % 2 == 0) {
			parent = (n - 2) / 2;
		} else {
			parent = (n - 1) / 2;
		}
		// Common.println("heapify ( " + n + " : " + parent + ")");

		if (parent < startIndex)
			return;

		if (arr[n] > arr[parent]) {
			int temp = arr[n];
			arr[n] = arr[parent];
			arr[parent] = temp;
		}
		// Common.printArray(arr);

		heapify(arr, startIndex, n - 1);
	}
}
