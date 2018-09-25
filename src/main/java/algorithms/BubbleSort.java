package algorithms;

import utils.Common;

public class BubbleSort {

	// Driver program to test above functions
	public static void main(String[] args) {
		int[] arr = new int[] { 64, 25, 12, 25, 11, 0 };
		bubbleSort(arr);
	}

	private static void bubbleSort(int[] arr) {
		Common.printArray(arr);
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[i]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		Common.printArray(arr);

	}
}