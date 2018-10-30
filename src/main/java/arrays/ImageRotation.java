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
		int arr[][] = { { 1, 2, 3, 4, 5 }, { 5, 6, 7, 8, 9 }, { 9, 10, 11, 12, 13 }, { 13, 14, 15, 16, 19

				}, { 17, 18, 19, 20, 21

				} };

		Common.printArray(arr);
		rotate90DegreeUsingExtraArray(arr);
		
		rotate90Degree(arr);
		//Common.printArray(arr);
	}

	private static void rotate90Degree(int[][] arr) {
		
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
