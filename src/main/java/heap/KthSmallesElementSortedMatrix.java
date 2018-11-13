package heap;

import utils.Common;

/**
 * https://www.programcreek.com/2016/08/leetcode-kth-smallest-element-in-a-sorted-matrix-java/
 * 
 * @author deepak
 *
 */
public class KthSmallesElementSortedMatrix {

	public static void main(String arr[]) {
		//@// @formatter:off
		int mat[][] = {
			
				{ 1, 5, 9},
				{10, 11, 3},
				{12, 13, 15}
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
