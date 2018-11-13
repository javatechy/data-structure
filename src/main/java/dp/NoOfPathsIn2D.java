package dp;

import utils.Common;

/**
 * Refernce
 * https://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
 * 
 * @author deepak
 *
 */
public class NoOfPathsIn2D {

	static int r = 4;
	static int c = 4;

	static int[][] memo = new int[r][c];

	public static void main(String arg[]) {
		Common.print("\nTotal Paths " + findPathsTopDown(r, c, 0, 0));
		Common.print("\nTotal Paths " + findPathsBottomUp(r, c));
		Common.print("\nTotal Paths findPathsBottomUpMemoization : " + findPathsBottomUpMemoization(r, c));
		Common.println();
		Common.print2DArray(memo, " ");
		Common.print("\nTotal Paths DP : " + findPathsDP(r, c));
		Common.println();

		Common.print2DArray(memo, " ");

	}

	private static int findPathsTopDown(int row, int col, int i, int j) {
		if (i == row - 1 || j == col - 1)
			return 1;
		return findPathsTopDown(row, col, i + 1, j) + findPathsTopDown(row, col, i, j + 1);
	}

	private static int findPathsBottomUp(int m, int n) {
		if (m == 1 || n == 1)
			return 1;
		return findPathsBottomUp(m - 1, n) + findPathsBottomUp(m, n - 1);
	}

	// Memoization
	private static int findPathsBottomUpMemoization(int m, int n) {

		if (memo[m - 1][n - 1] != 0) {
			return memo[m - 1][n - 1];
		}
		if (m == 1 || n == 1)
			return 1;
		memo[m - 1][n - 1] = findPathsBottomUpMemoization(m - 1, n) + findPathsBottomUpMemoization(m, n - 1);
		return memo[m - 1][n - 1];
	}

	/**
	 * Dynamic Programming
	 * 
	 * Refernce : https://youtu.be/5E3se3Gm4aQ
	 * 
	 * In below array memo[m-1][n-1] is our desired output.
	 * 
	 * 
	 * 0 1 1 1 1 2 3 4 1 3 6 10 1 4 10 20
	 */
	private static int findPathsDP(int r, int c) {

		for (int i = 0; i < r; i++) {
			memo[i][0] = 1;
		}

		for (int j = 0; j < c; j++) {
			memo[0][j] = 1;
		}

		for (int i = 1; i < r; i++) {
			for (int j = 1; j < c; j++) {
				memo[i][j] = memo[i - 1][j] + memo[i][j - 1];
			}
		}
		Common.print2DArray(memo, " ");
		return memo[r - 1][c - 1];

	}
}