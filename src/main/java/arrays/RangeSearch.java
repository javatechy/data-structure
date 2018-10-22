package arrays;

import utils.Common;

/**
 * https://medium.com/@rachit.slt/leetcode-search-for-a-range-753ae1765318
 * 
 * @author deepak
 *
 */
public class RangeSearch {

	// Driver program to test above functions
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };

		int search = 4;
		int start = 2;
		int end = 8;
		int pos = binarySearch(arr, start, end, search);
		Common.print("Localtion is " + pos);
	}

	public static int binarySearch(int[] arr, int start, int end, int search) {
		if (start < 0 || start >= arr.length || end >= arr.length || end < start || arr.length == 0) {
			return -1;
		}

		// 2,3,4,6,8,9
		while (start <= end) {

			int mid = (start + end) / 2;

			Common.println("MID " + mid);
			if (arr[mid] == search) {
				return mid;
			} else if (arr[mid] > search) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}

		}
		return -1;

	}
}
