package arrays;

import utils.Common;

/**
 * https://www.geeksforgeeks.org/array-rotation/
 * 
 * @author deepak
 *
 */

public class ImageRotation {

	// Driver program to test above functions
	public static void main(String[] args) {
		// @// @formatter:off
		int arr[][] = { { 1, 2, 3, 4 }, 
						{ 5, 6, 7, 8 }, 
						{ 9, 10, 11, 12 }, 
						{ 13, 14, 15, 16 }
					  };
		// @formatter:on
		Common.printArray(arr);

		// rotate90DegreeUsingExtraArray(arr);

		rotate90Degree(arr);
		// Common.printArray(arr);
	}

	private static void rotate90Degree(int[][] mat) {
		int N = mat.length;
		// Consider all squares one by one
		for (int x = 0; x < N / 2; x++) {
			// Consider elements in group of 4 in
			// current square
			for (int y = x; y < N - x - 1; y++) {
				Common.println("------------------------------------------");
				// store current cell in temp variable
				int temp = mat[x][y];

				// move values from right to top
				mat[x][y] = mat[y][N - 1 - x];

				Common.println("[x][y] :" + x + " ," + y + " and [y][N - 1 - x] " + y + "," + (N - 1 - x));

				// move values from bottom to right
				mat[y][N - 1 - x] = mat[N - 1 - x][N - 1 - y];

				Common.println("[y][N - 1 - x] :" + y + "," + (N - 1 - x) + " and  [N - 1 - x][N - 1 - y] "
						+ (N - 1 - x) + "," + (N - 1 - y));

				// move values from left to bottom
				mat[N - 1 - x][N - 1 - y] = mat[N - 1 - y][x];
				Common.println("[N - 1 - x][N - 1 - y] " + (N - 1 - x) + " , " + (N - 1 - y) + " and  [N - 1 - y][x] : "
						+ (N - 1 - y) + " , " + x);

				// assign temp to left
				mat[N - 1 - y][x] = temp;
			}
		}

	}

	private static void rotate90DegreeUsingExtraArray(int[][] mat) {
		int N = mat.length - 1;
		int[][] mat2 = new int[mat.length][mat.length];
		for (int c = 0; c <= N; c++) {
			for (int r = N; r >= 0; r--) {

				Common.print("[" + c + "][" + (N - r) + "] , ");
				Common.print("[" + r + "][" + c + "] , ");
				mat2[c][N - r] = mat[r][c];
			}
			Common.println();
		}
		Common.print2DArray(mat2, " , ");
	}

}