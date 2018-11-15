package dp;

import java.util.Arrays;

import utils.Common;

public class LongestDecreasingSubSequence {

	static int mat[][];

	public static void main(String args[]) {
		int arr[] = { 80, 60, 41, 9, 33, 10, 22, 45 };

		Common.printArray(lds(arr));
	}

	public static int[] lds(int[] arr) {
		int len = arr.length;
		int result[] = new int[len];
		Arrays.fill(result, 1);

		for (int i = 1; i < len; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[i]) {
					result[i] = Math.max(result[i], result[j] + 1);
				}
			}
		}
		return result;
	}

	/**
	 * Used in bitonic
	 * 
	 * @param arr
	 * @return
	 */
	public static int[] ldsReverse(int[] arr) {
		int len = arr.length;
		int result[] = new int[len];
		Arrays.fill(result, 1);

		for (int i = len - 2; i >= 0; i--) {
			for (int j = len - 1; j > i; j--) {
				if (arr[i] > arr[j]) {
					result[i] = Math.max(result[i], result[j] + 1);
				}
			}
		}
		return result;
	}

}