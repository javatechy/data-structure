package dp;

import utils.Common;

public class WaysToScore13 {

	public static void main(String args[]) {
		int n = 13;
		int combination = countWays(n);
		Common.println(combination);
		combination = countWaysDp(n);
		Common.println(combination);

		/**
		 * combination = countWaysNonRepeating(n); Common.println(combination);
		 * 
		 **/

	}

	private static int countWays(int n) {
		if (n < 0)
			return 0;
		if (n == 0)
			return 1;
		return countWays(n - 5) + countWays(n - 3) + countWays(n - 10);
	}

	private static int countWaysNonRepeating(int n) {
		if (n < 3 || n < 5)
			return 0;
		if (n == 3 || n == 10 || n == 5)
			return 1;
		return countWaysNonRepeating(n - 5) + countWaysNonRepeating(n - 3) + countWaysNonRepeating(n - 10);
	}

	/***
	 * check this if 3,5,3 and 3,5,5 are same case.
	 * https://www.geeksforgeeks.org/count-number-ways-reach-given-score-game/
	 */
	private static int countWaysDp(int n) {
		int arr[] = new int[n + 1];
		arr[0] = 1;

		for (int i = 1; i <= n; i++) {
			if (i - 3 >= 0)
				arr[i] += arr[i - 3];
			if (i - 5 >= 0)
				arr[i] += arr[i - 5];
			if (i - 10 >= 0)
				arr[i] += arr[i - 10];

		}
		Common.printArray(arr);
		return arr[n];

	}

}