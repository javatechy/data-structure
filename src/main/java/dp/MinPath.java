package dp;

import utils.Common;

public class MinPath {

	static int[][] memo = new int[3][3];

	public static void main(String args[]) {
		//@// @formatter:off
				int arr[][] = {//  0  1   2   3
					/** 0 **/	{1, 2, 3}, 
                    {4, 8, 2}, 
                    {1, 5, 3}
						};
		// @formatter:on	

		iterativeSolution(arr);
		int cost = recursiveSolution(arr, arr.length - 1, arr[0].length - 1);
		Common.println("Cost of " + cost);

		cost = memoization(arr, arr.length - 1, arr[0].length - 1);
		Common.println("Memoization : " + cost);

		cost = dynamicPrg(arr, arr.length - 1, arr[0].length - 1);
		Common.println("Memoization : " + cost);

	}

	private static int dynamicPrg(int[][] arr, int r, int c) {

		return 0;
	}

	private static int recursiveSolution(int[][] arr, int r, int c) {

		if (r < 0 || c < 0)
			return Integer.MAX_VALUE;
		else if (r == 0 && c == 0)
			return arr[r][c];
		else
			return arr[r][c] + min(recursiveSolution(arr, r - 1, c - 1), recursiveSolution(arr, r - 1, c),
					recursiveSolution(arr, r, c - 1));
	}

	private static int memoization(int[][] arr, int r, int c) {

		if (memo[r][c] != 0)
			return memo[r][c];

		if (r < 0 || c < 0)
			return Integer.MAX_VALUE;
		else if (r == 0 && c == 0) {
			memo[r][c] = arr[r][c];
			return arr[r][c];
		} else {
			memo[r][c] = arr[r][c] + min(recursiveSolution(arr, r - 1, c - 1), recursiveSolution(arr, r - 1, c),
					recursiveSolution(arr, r, c - 1));
			return memo[r][c];
		}
	}

	static int min(int x, int y, int z) {
		if (x < y)
			return (x < z) ? x : z;
		else
			return (y < z) ? y : z;
	}

	private static void iterativeSolution(int[][] arr) {
		int minCost = arr[0][0];
		int r = 0;
		int c = 0;

		while (true) {
			int min = 0;
			if (c + 1 == arr[0].length && r + 1 == arr.length)
				break;
			if (c + 1 == arr[0].length) {
				min = arr[r + 1][c];
				Common.println("Path r: " + (r + 1) + " c: " + c);
				r++;
			} else if (r + 1 == arr.length) {
				min = arr[r][c + 1];
				Common.println("Path r: " + r + " c: " + (c + 1));
				c = c + 1;
			} else {
				min = Math.min(arr[r][c + 1], arr[r + 1][c]);

				if (min == arr[r][c + 1]) {
					Common.println("Path r: " + r + " c: " + (c + 1));
					c = c + 1;
				} else {
					Common.println("Path r: " + (r + 1) + " c: " + c);
					r = r + 1;
				}
			}
			minCost += min;
		}

		Common.print("Miimum cost : " + minCost);
	}

}