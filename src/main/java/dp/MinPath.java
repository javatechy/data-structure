package dp;

import utils.Common;

/**
 * Find min cost if left downward and diagonal move is allowed
 * @author deepak
 *
 */
public class MinPath {

	static int[][] memo = new int[3][4];

	public static void main(String args[]) {
		//@// @formatter:off
				int arr[][] = {//  0  1   2   3
					/** 0 **/	{  1, 3,  5,  8 }, 
                    			{  4, 2 , 1,  7 }, 
                    			{  4, 3,  2,  3 }
						};
		// @formatter:on	

		int cost = dynamicPrg(arr, arr.length, arr[0].length);
		Common.println("DP : " + cost);

	}

	private static int dynamicPrg(int[][] arr, int r, int c) {

		memo[0][0] = arr[0][0];

		for (int i = 1; i < r; i++)
			memo[i][0] = arr[i][0] + memo[i - 1][0];

		for (int i = 1; i < c; i++)
			memo[0][i] = arr[0][i] + memo[0][i - 1];

		for (int i = 1; i < r; i++) {
			for (int j = 1; j < c; j++) {
				int min = Math.min(memo[i][j - 1], memo[i - 1][j]);
				memo[i][j] = Math.min(min, memo[i - 1][j - 1]) + arr[i][j];
			}
		}
		Common.print2DArray(memo, " ");

		return memo[r - 1][c - 1];
	}

}