package dp;

import utils.Common;

public class MinFareBetweenStations {

	static int memo[][] = new int[100][100];

	public static void main(String arg[]) {

		//@// @formatter:off
		int arr[][] = { 
					{ 0, 10, 75, 94 }, 
					{ -1, 0, 35, 50 }, 
					{ -1, -1, 0, 80 }, 
					{ -1, -1, -1,0  } 
					};
		
		
		// @formatter:on

		int min = minDistance(arr, 0, 3);
		Common.print("\nMin distance is " + min);

		min = minDistance(arr, 0, 2);
		Common.print("\nMin distance is " + min);

	}

	private static int minDistance(int[][] arr, int s, int d) {
		// If source and destination is same station
		Common.print("\nS = " + s + " and D = " + d);

		if (s == d)
			return 0;
		// Using Memoization
		if (memo[s][d] != 0) {
			Common.println("Getting from memoization table");
			return memo[s][d];
		}
		if (s == d - 1)
			return arr[s][d];

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
}
