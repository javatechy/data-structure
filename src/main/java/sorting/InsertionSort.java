package sorting;

import utils.Common;

/**
 * Time Complexity: O(n*n) Auxiliary Space: O(1)
 */
class InsertionSort {

	public static void main(String[] argv) throws Exception {
		int[] arr = new int[] { 12, 11, 13, 5, 6 };
		int[] sortedArray = insertionSort(arr);
		Common.printArray(sortedArray);
	}

	private static int[] insertionSort(int[] arr) {
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			Common.println("For Array  i  = " + i + "\n");
			Common.printArray(arr);

		}
		return arr;
	}

}