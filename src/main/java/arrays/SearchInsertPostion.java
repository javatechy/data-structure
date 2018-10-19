package arrays;

import utils.Common;

/**
 * https://medium.com/@rachit.slt/leetcode-search-for-a-range-753ae1765318
 * https://leetcode.com/problems/search-insert-position/submissions/
 * 
 * @author deepak
 *
 */
public class SearchInsertPostion {

	// Driver program to test above functions
	public static void main(String[] args) {
		int arr[] = { 1, 3, 5, 7 };

		int search = 6;
		int start = 0;
		int end = arr.length - 1;
		int pos = binarySearch(arr, start, end, search);
		Common.print("Localtion is " + pos);
	}

	private static int binarySearch(int[] arr, int start, int end, int search) {

		if (start < 0 || start >= arr.length || end >= arr.length || end < start || arr.length == 0) {
			return -1;
		}

		if (search > arr[end])
			return arr.length;

		if (search < arr[start])
			return 0;

		// 1,3,9
		// 0,1,2
		// 2
		int mid = 0;
		while (start <= end) {
			// 1
			// 0 0
			mid = (start + end) / 2;

			if (arr[mid] == search) {
				return mid;
			} else if (arr[mid] > search) {
				end = mid - 1;
			} else {
				start = mid + 1;
				mid++;
			}

		}
		return mid;

	}
}
