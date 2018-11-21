package dp;

import utils.Common;

public class MaximumSquareSizeMatrix {

	static int mat[][];

	public static void main(String args[]) {
//		@// @formatter:off
 

		int arr[][] = { { 0, 0, 1, 1, 1 }, 
						{ 1, 1, 1, 1, 1 }, 
						{ 0, 1, 1, 1, 1 }, 
						{ 1, 0, 1, 1, 1 } 
					 };
// @formatter:on
		int result = maxSize(arr);
		System.out.print(result);
	}

	private static int maxSize(int[][] arr) {

		int rlen = arr.length;
		int clen = arr[0].length;

		int mat[][] = new int[rlen + 1][clen + 1];

		int maxVal = 0;

		for (int r = 1; r <= rlen; r++) {
			for (int c = 1; c <= clen; c++) {
				if (arr[r - 1][c - 1] == 1) {
					mat[r][c] = Common.min(mat[r - 1][c - 1], mat[r - 1][c], mat[r][c - 1]) + 1;
					if (maxVal < mat[r][c]) {
						maxVal = mat[r][c];
					}
				}
			}
		}
		Common.print2DArray(mat);
		return maxVal*maxVal;
	}

}