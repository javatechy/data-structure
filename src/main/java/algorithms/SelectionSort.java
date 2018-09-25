package algorithms;

import utils.Common;

public class SelectionSort {

	// Driver program to test above functions
	public static void main(String[] args) {

		int[] arr = new int[] { 64, 25, 12, 25, 11, 0 };

		selectionSort(arr);
	}

	private static void selectionSort(int[] arr) {
		Common.printArray(arr);
		for (int i = 0; i < arr.length; i++) {
			int selection = arr[i];
			int mininndex = findMin(arr, i, selection);
			int temp = arr[mininndex];
			arr[mininndex] = selection;
			arr[i] = temp;
		}
		Common.printArray(arr);

	}

	static int findMin(int arr[], int startIndex, int selction) {
		int index = startIndex;
		for (; startIndex < arr.length; startIndex++) {
			if (arr[startIndex] < selction)
				index = startIndex;
		}
		return index;

	}
}
