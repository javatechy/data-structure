package arrays;

import utils.Common;

public class PlusOne {

	public static void main(String args[]) {
		int arr[] = { 1, 2, 3, 9 };

		Common.printArray(addNumber(arr));
	}

	static int[] addNumber(int[] arr) {
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] < 9) {
				arr[i]++;
				return arr;
			}
			arr[i] = 0;
		}
		int newArr[] = new int[arr.length + 1];
		newArr[0] = 1;
		return newArr;
	}
}
