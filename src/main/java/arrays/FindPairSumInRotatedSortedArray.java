package arrays;

import utils.Common;

/**
 * https://www.geeksforgeeks.org/given-a-sorted-and-rotated-array-find-if-there-is-a-pair-with-a-given-sum/
 * 
 * @author deepak
 *
 */
public class FindPairSumInRotatedSortedArray {

	// Driver program to test above functions
	public static void main(String[] args) {
		// l i
		int arr[] = { 5, 6, 7, 8, 9, 10, 11, 12, 1, 2, 3, 4 };
		int sum = 511;
		int pivot = findPivot(arr);

		if (pivot == -1)
			return;

		boolean result = findMatch(pivot, arr, sum);

		System.out.println(result);
		printArray(arr, arr.length);
	}

	private static boolean findMatch(int pivot, int[] arr, int sum) {
		int l = pivot;
		// int r = arr.length;
		int i = pivot + 1;

		while (i != l) {
			if (i == arr.length - 1)
				i = 0;
			if (l == 0)
				l = arr.length - 1;

			int tSum = arr[l] + arr[i];
			if (tSum < sum)
				i++;
			else if (tSum > sum)
				l--;
			else {
				Common.print("Found at " + arr[l] + " and " + arr[i]);
				return true;
			}
		}
		return false;
	}

	private static int findPivot(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1])
				return i;
		}
		return -1;
	}

	/* Fuction to get gcd of a and b */
	static int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

	/* utility function to print an array */
	static void printArray(int arr[], int size) {
		int i;
		System.out.println();
		for (i = 0; i < size; i++)
			System.out.print(arr[i] + " ");
	}
}
