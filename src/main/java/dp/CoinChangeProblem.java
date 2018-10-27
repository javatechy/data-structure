package dp;

import java.util.Arrays;

import utils.Common;

public class CoinChangeProblem {

	public static void main(String args[]) {

		int arr[] = { 7, 2, 3, 6 };

		int X = 13;

		int res = minCoinsDp(arr, arr.length, X);
		Common.println(res);

		// subsetSumDp(arr, arr.length, 5);
	}

	/**
	 * Pending
	 */
	private static int minCoins(int[] coins, int n, int sum) {
		// Base Cases
		if (sum == 0)
			return 0;

		int count = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {

			Common.println(" Coin: " + coins[i] + " : Sum: " + sum);

			if (coins[i] <= sum) {
				Common.println(" 			W o: Coin: " + coins[i] + " : Sum: " + sum);
				int temp = 1 + Common.min(minCoins(coins, n, sum - coins[i]));
				if (temp < count) {
					Common.println(" 			Updating MIn: " + temp);
					count = temp;
				}
			}
		}

		return count;
	}

	/**
	 * Pending
	 */
	private static int minCoinsDp(int[] coins, int n, int sum) {
		int result[] = new int[sum + 1];
		int location[] = new int[sum + 1];

		Arrays.fill(location, -1);
		for (int i = 1; i <= sum; i++) {
			result[i] = Integer.MAX_VALUE;
		}

		for (int j = 0; j < n; j++) {
			// Common.println("Running for " + coins[j]);
			for (int i = 1; i <= sum; i++) {
				if (i >= coins[j] && i - coins[j] >= 0) {
					if (result[i - coins[j]] == Integer.MAX_VALUE) {
						continue;
					}
					int temp = Math.min(result[i], 1 + result[i - coins[j]]);
					result[i] = temp;
					location[i] = j;
				}
			}
		}
		Common.printArray(result);
		Common.printArray(location);

		// to make 13
		int temp = sum;
		while (temp != 0) {
			Common.println("SUM IS : " + coins[location[temp]]);
			temp -= coins[location[temp]];
		}
		return result[sum];
	}

}