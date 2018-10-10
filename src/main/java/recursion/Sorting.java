package recursion;

import utils.Common;

public class Sorting {

	public static void main(String args[]) {

		int arr[] = new int[] { 52, 1, 2, 4, 9, 229, 23672 };
		bubbleSort(arr, 0, arr.length);
		Common.printArray(arr);
	}

	private static void bubbleSort(int[] arr, int n, int len) {
		if (n == len)
			return;
		for (int i = 0; i < len; i++)
			if (arr[n] < arr[i]) {
				int temp = arr[i];
				arr[i] = arr[n];
				arr[n] = temp;
			}
		bubbleSort(arr, n + 1, len);
	}

}