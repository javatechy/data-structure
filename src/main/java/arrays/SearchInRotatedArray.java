package arrays;

import utils.Common;

/**
 * https://www.geeksforgeeks.org/array-rotation/
 * 
 * @author deepak
 *
 */

public class SearchInRotatedArray {

	// Driver program to test above functions
	public static void main(String[] args) {

		int arr[] = { 5, 6, 7, 8, 9, 10, 11, 12, 1, 2, 3, 4 };

		int search = 9;

		int index = search(arr, search);
		Common.print("Found at  " + index);
	}

	/**
	 * Attempt 2 on 19 OCT 2018
	 **/
	private static int search(int[] arr, int search) {

		int pivot = arr.length - 1;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				pivot = i;
				break;
			}
		}
		Common.println("Pivot : " + pivot);

		int index = RangeSearch.binarySearch(arr, 0, pivot, search);
		if (index == -1) {
			index = RangeSearch.binarySearch(arr, pivot + 1, arr.length - 1, search);
		}
		return index;
	}

	

}
