package arrays;

import java.util.ArrayList;
import java.util.List;

import utils.Common;

public class RemoveElement {

	public static void main(String arr[]) {
		int[] nums = new int[] { 3, 3, 3, 3 };
		// new RemoveElement().removeElement(nums, 3);
		// Common.printArray(nums);

		removeElement2(nums, 3);

	}

	/**
	 * LEET Code Method: https://leetcode.com/problems/remove-element/description/
	 */
	private static void removeElement2(int[] nums, int val) {
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[i] = nums[j];
				j++;
			}
		}
		Common.printArray(nums);
	}

	public int removeElementExtraSpace(int[] nums, int val) {

		if (nums == null || nums.length == 0)
			return -1;

		List<Integer> numlist = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				numlist.add(nums[i]);
			}
		}
		nums = new int[numlist.size()];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = numlist.get(i);
		}
		return nums.length;
	}

	public int removeElement(int[] arr, int val) {

		if (arr == null || arr.length == 0)
			return -1;

		int len = arr.length;
		int i = 0;
		int j = 1;

		while (i < len && j < len) {
			if (arr[i] == val && arr[j] == val) {
				j++;
			} else if (arr[i] == val && arr[j] != val) {
				arr[i] = arr[j];
				arr[j] = -1;
				i++;
				j++;
			} else {
				i++;
				j++;
			}
			Common.printArray(arr);
		}

		return arr.length;
	}

}
