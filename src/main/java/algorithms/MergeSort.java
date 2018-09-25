package algorithms;

import utils.Common;

public class MergeSort {

	// Driver program to test above functions
	public static void main(String[] args) {
		int[] arr = new int[] { 64, 25, 12, 25, 11, 0 };
		mergeSort(arr, 0, arr.length);
		Common.printArray(arr);
	}

	private static void mergeSort(int[] arr, int startIndex, int endIndex) {

		if (endIndex - startIndex == 1) {
			int temp = arr[endIndex];
			arr[endIndex] = arr[startIndex];
			arr[startIndex] = temp;
			Common.printArray(arr);
			return;
		}
		int mid = (startIndex + endIndex) / 2;
		mergeSort(arr, startIndex, mid - 1);
		mergeSort(arr, mid, endIndex);
	}
}