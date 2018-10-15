package heap;

import utils.Common;

public class KthSmallestElementSortedRowMatrix {

	public static void main(String arr[]) {
		//@// @formatter:off
		int mat[][] = {
				{ 10, 20, 30, 40},
				{ 15, 25, 35, 45},
				{ 24, 29, 37, 48},
				{ 32, 33, 39, 50}
			};
		// @formatter:on

		int numebr = findRowSmallest(mat, 8);

		Common.println(" Number is  " + numebr);

		numebr = findColSmallest(mat, 8);

		Common.println(" Number is  " + numebr);

	}

	private static int findRowSmallest(int[][] mat, int nth) {

		int r = 0;
		while (r < mat.length && nth > mat.length) {
			nth = nth - mat.length;
			r++;
		}

		return mat[r][nth - 1];
	}

	private static int findColSmallest(int[][] mat, int nth) {
		int c = 0;
		while (c < mat[0].length && nth > mat.length) {
			nth = nth - mat[0].length;
			c++;
		}
		return mat[nth - 1][c];
	}
}
