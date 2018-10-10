package dp;

import utils.Common;

public class NoOfPathsIn2D {

	public static void main(String arg[]) {

		//@// @formatter:off
		int arr[][] = { 
					{ 0, 10, 75, 94 }, 
					{ -1, 0, 35, 50 }, 
					{ -1, -1, 0, 80 }, 
					{ -1, -1, -1,0  } 
					};
		// @formatter:on

		int ar2[][] = { { 0, 10 }, { -1, 0 } };

		int paths = findPaths(ar2, 0, 0, 0);
		Common.print("\nTotal Paths " + paths);

	}

	private static int findPaths(int[][] arr, int i, int j, int count) {
		int len = arr[0].length - 1;
		Common.print("\nlen " + len);

		if (i == len && j == len)
			return count;

		if (i == len || j == len)
			return 0;

		count++;
		Common.print("count " + count);
		return findPaths(arr, i + 1, j, count) + findPaths(arr, i, j + 1, count);
	}
}
