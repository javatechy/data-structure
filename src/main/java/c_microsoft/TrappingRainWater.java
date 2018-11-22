package c_microsoft;

import java.util.Arrays;

import utils.Common;

/**
 * Count Inversions in an array | Set 1 (Using Merge Sort)
 * 
 * https://www.geeksforgeeks.org/counting-inversions/
 *
 */
public class TrappingRainWater {

	public static void main(String[] args) {

		int arr[] = { 7, 1, 4, 0, 2, 8, 6, 3, 5 };

		Common.println(trapRainWater(arr));

	}

	/**
	 * O(n2) Complexity
	 */
	public static int trapRainWater(int[] arr) {

		int left = 0;
		int right = arr.length - 1;

		int leftMax = 0;
		int rightMax = 0;

		int totalWater = 0;
		int len = arr.length;

		int max = 0;
		while (left < right) {
			if (arr[left] < arr[right]) {
				if (arr[left] > leftMax)
					leftMax = arr[left];
				else
					totalWater += leftMax - arr[left];
				left++;
			} else {
				if (arr[right] > rightMax)
					rightMax = arr[right];
				else
					totalWater += rightMax - arr[right];
				right--;
			}
		}
		return totalWater;

	}

}
