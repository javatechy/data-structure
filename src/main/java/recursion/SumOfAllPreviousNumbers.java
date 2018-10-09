package recursion;

import utils.Common;

public class SumOfAllPreviousNumbers {
	public static void main(String args[]) {
		int arr[] = new int[] { 1, 2, 3, 9 };
		int sum = findSum(arr, arr.length - 1);
		Common.println(sum);
		addPrevRec1(arr, arr.length);
		Common.printArray(arr);
	}

	private static int findSum(int[] arr, int N) {
		if (N < 0) {
			return 0;
		}
		return findSum(arr, N - 1) + arr[N];
	}

	static void addPrevRec1(int arr[], int n) {
		// TERMINATING CONDITION.
		// if we are first element, don't do anything
		if (n <= 1) {
			return;
		}

		// Add all prev elements for first n-1 elements
		addPrevRec1(arr, n - 1);

		// With problem solved till (n-1),
		// we just need to add (n-1)th element to n'th element
		arr[n - 1] += arr[n - 2];
	}

}