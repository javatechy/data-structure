package sorting;

import utils.Common;

/**
 * Time Complexity: O(n*n) Auxiliary Space: O(1)
 */
class CountingSort {

	public static void main(String[] argv) throws Exception {
		int[] arr = new int[] { 1, 4, 1, 2, 7, 5, 2 };

		int[] finalArray = sort(arr);

		Common.printArray(finalArray, " ");
	}

	private static int[] sort(int[] arr) {
		int sizeOfNewArray = Common.max(arr);

		int count[] = new int[sizeOfNewArray + 1];

		// Count number of elemenets
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}
		// Add prev count in the array
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

		Common.printArray(count);
		int finalArray[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			finalArray[count[arr[i]] - 1] = arr[i];
			count[arr[i]]--;
		}
		return finalArray;
	}

}