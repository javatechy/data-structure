package dynamic_prog;

import utils.Common;

public class KnapsackProblem {
	public static void main(String arr[]) {
		int val[] = new int[] { 3, 4, 5, 6  };
		int wt[] = new int[] { 2, 3, 4, 5};

		int W = 5;
		int n = val.length;
		System.out.println(knapSack(wt, val, W, n));

		System.out.println(knapSackDp(wt, val, W, n));
	}

	/**
	 * Recursion
	 * 
	 * Time complexity of this naive recursive solution is exponential (2^n)
	 */
	private static int knapSack(int[] weights, int[] values, int bagWeight, int len) {

		if (bagWeight <= 0 || len <= 0) {
			return 0;
		}

		if (weights[len - 1] > bagWeight)
			return knapSack(weights, values, bagWeight, len - 1);

		int whenIncluded = values[len - 1] + knapSack(weights, values, bagWeight - weights[len - 1], len - 1);
		int whenNotIncluded = knapSack(weights, values, bagWeight, len - 1);
		return Math.max(whenIncluded, whenNotIncluded);
	}

	/**
	 * DP
	 * 
	 * Time complexity is O(nw)
	 */
	private static int knapSackDp(int[] weights, int[] values, int capacity, int len) {

		int mat[][] = new int[len + 1][capacity + 1];

		for (int r = 1; r <= len; r++) {
			for (int cp = 1; cp <= capacity; cp++) {

				if (weights[r - 1] > cp) {
					mat[r][cp] = mat[r - 1][cp];
					continue;
				}

				int upperColVal = mat[r - 1][cp];
				int newWeightVal = values[r - 1];
				if (cp - weights[r - 1] >= 0) {
					newWeightVal += mat[r - 1][cp - weights[r - 1]];
				}

				mat[r][cp] = Math.max(upperColVal, newWeightVal);

			}
		}

		Common.print2DArray(mat, " ");
		return mat[len][capacity];

	}

}
