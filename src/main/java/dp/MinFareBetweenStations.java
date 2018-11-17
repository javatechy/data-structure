package dp;

import utils.Common;

public class MinFareBetweenStations {

	static int memo[][] = new int[6][6];

	public static void main(String arg[]) {

		//@// @formatter:off
		int arr[][] = {//  0  1    2    3   4   5
			/** 0 **/	{ 0, 10,  75,  94, 67, 40 }, 
			/** 1 **/	{ -1, 0,  35,  50, 90, 44 }, 
			/** 2 **/	{ -1, -1,  0,  80, 80, 23 }, 
			/** 3 **/	{ -1, -1, -1,  0 , 88, 12 }, 
			/** 4 **/	{ -1, -1, -1, -1 ,  0, 12 }, 
			/** 5 **/	{ -1, -1, -1, -1 , -1,  0 }, 
					};
		
		
		int min =0;
		
		min=  minDistanceRecursive(arr, 0, 5);

		
		Common.println("Min distance is " + min);

		Common.print2DArray(memo, " ");
		
		Common.println("-------------------------------- ");

		min = minDistance(arr, 0, 2);
		Common.print("\nMin distance is " + min);
		
		min = minDistanceDp(arr);
		Common.print("\nMin DP distance is " + min);
		
		// @formatter:on

	}

	private static int minDistanceRecursive(int[][] arr, int s, int d) {
		if (s == d)
			return 0;
		if (s == d - 1) {
			return arr[s][d];
		}
		int min = arr[s][d];
		for (int i = s + 1; i < d; i++) {

			int dist = minDistance(arr, s, i) + minDistance(arr, i, d);
			if (dist < min)
				min = dist;
		}
		return min;
	}

	private static int minDistance(int[][] arr, int s, int d) {
		// If source and destination is same station
		// Common.print("\nS = " + s + " and D = " + d);

		if (s == d)
			return 0;
		// Using Memoization
		if (memo[s][d] != 0) {
			Common.println("Getting from memoization table for " + s + " and D = " + d);
			return memo[s][d];
		}
		if (s == d - 1) {
			memo[s][d] = arr[s][d];
			return arr[s][d];
		}
		// Memoization Ends
		int min = arr[s][d];
		for (int i = s + 1; i < d; i++) {

			int dist = minDistance(arr, s, i) + minDistance(arr, i, d);
			if (dist < min)
				min = dist;
		}
		// Using Memoization
		memo[s][d] = min;
		// Memoization Ends
		return min;
	}

	/**
	 * Minimum Distance using Dp
	 */
	private static int minDistanceDp(int[][] arr) {
		int size = arr[0].length;
		int mem[] = new int[size];
		mem[0] = 0;
		mem[1] = arr[0][1];
		Common.println("----------");
		for (int row = 2; row < size; row++) {
			mem[row] = arr[0][row];
			for (int j = 0; j < row; j++) {
				if (arr[row][j] + mem[row] < mem[row]) {
					mem[row] = arr[row][j] + mem[row];
				}
			}
		}
		Common.printArray(mem);
		return mem[size - 1];
	}
}
