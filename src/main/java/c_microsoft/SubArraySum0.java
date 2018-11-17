package c_microsoft;

import java.util.HashMap;
import java.util.Map;

import utils.Common;

/**
 * https://www.geeksforgeeks.org/print-all-subarrays-with-0-sum/
 *
 */
public class SubArraySum0 {

	public static void main(String[] args) {

		int arr[] = { 6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7 };

		subrarryZero(arr);
		Common.printArray(arr);
	}

	public static void subrarryZero(int[] arr) {

		Map<Integer, Integer> map = new HashMap<>();

		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sum == 0) {
				Common.println(0 + " to " + i);
			}
			if (map.get(sum) != null) {
				Common.println((map.get(sum) + 1) + " to " + i);

	            // map[sum] stores starting index of all subarrays 
				// Pending Part
			}

			map.put(sum, i);
		}
	}

}
