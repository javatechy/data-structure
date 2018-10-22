package dp;

import utils.Common;

public class SubSetSum {

	public static void main(String args[]) {

		int arr[] = { 3, 2, 71, -1 ,8};

		int X = 6;

		boolean res = subsetSum(arr, arr.length, X);
		Common.println(res);

		// subsetSumDp(arr, arr.length, 5);
	}

	/**
	 * Pending
	 */
	private static boolean subsetSum(int[] arr, int n, int sum) {
		// Base Cases
		if (sum == 0)
			return true;
		if (n == 0 && sum != 0)
			return false;

		// If last element is greater than
		// sum, then ignore it
		if (arr[n - 1] > sum)
			return subsetSum(arr, n - 1, sum);

		/*
		 * else, check if sum can be obtained by any of the following (a) including the
		 * last element (b) excluding the last element
		 */
		return subsetSum(arr, n - 1, sum) || subsetSum(arr, n - 1, sum - arr[n - 1]);
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