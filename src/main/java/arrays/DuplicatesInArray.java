package arrays;

import utils.Common;

public class DuplicatesInArray {

	public static void main(String args[]) {
		int arr[] = { 1, 2, 3, 1, 3, 6, 6 };

		int len = arr.length;
		 printRepeating(arr, len);
		//findRepeating(arr, len);

	}

	private static void printRepeating(int arr[], int size) {
		int i;
		Common.println("The repeating elements are: \n");
		for (i = 0; i < size; i++) {
			if (arr[Math.abs(arr[i])] >= 0)
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			else
				Common.print(" " + Math.abs(arr[i]));
		}
	}

	private static void findRepeating(int[] arr, int len) {
		for (int i = 0; i < len; i++) {
			int index = arr[i] % len;
			arr[index] += len;
		}
		for (int i = 0; i < len; i++) {
			if ((arr[i] / len) > 1)
				Common.print(" " + i);
		}
	}
}
