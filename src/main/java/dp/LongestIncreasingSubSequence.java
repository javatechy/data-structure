package dp;

import java.util.Arrays;

import utils.Common;

public class LongestIncreasingSubSequence {

	static int mat[][];

	public static void main(String args[]) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };

		Common.printArray(lis(arr));
	}

	public static int[] lis(int[] arr) {
		int len = arr.length;
		int result[] = new int[len];
		Arrays.fill(result, 1);

		for (int i = 1; i < len; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					result[i] = Math.max(result[i], result[j] + 1);
				}
			}
		}
		return result;
	}

}