package dp;

import utils.Common;

public class CoinChangeProblem {

	public static void main(String args[]) {

		int arr[] = { 1, 2, 5, 10, 20, 50 };

		int X = 65;

		boolean res = noOfCoinChange(arr, arr.length, X);
		Common.println(res);

		// subsetSumDp(arr, arr.length, 5);
	}

	/**
	 * Pending
	 */
	private static boolean noOfCoinChange(int[] arr, int n, int sum) {
		// Base Cases
		if (sum == 0)
			return true;
		if (n == 0 && sum != 0)
			return false;

		if (arr[n - 1] > sum)
			return noOfCoinChange(arr, n - 1, sum);

		return noOfCoinChange(arr, n - 1, sum) || noOfCoinChange(arr, n - 1, sum - arr[n - 1]);
	}

	/**
	 * Pending
	 */
	private static boolean subsetSumDp(int[] arr, int n, int sum) {

		boolean[][] mat = new boolean[arr.length][sum + 1];
		mat[0][0] = true;

		for (int r = 0; r < mat.length; r++) {
			mat[r][0] = true;
		}

		for (int c = 0; c < mat[0].length; c++) {
			if (c == arr[0])
				mat[0][c] = true;
		}

		for (int r = 1; r < mat.length; r++) {
			for (int c = 1; c < mat[0].length; c++) {
				if (mat[r - 1][c])
					mat[r][c] = true;
				else {
					int col = c - arr[r];
					if (col >= 0)
						mat[r][c] = mat[r - 1][c - arr[r]];
				}
			}
		}

		Common.print2DArray(mat, " ");

		return mat[arr.length - 1][sum];

	}

}