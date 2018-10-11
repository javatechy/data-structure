package dp;

import utils.Common;

public class PascalTriangle {

	public static void main(String args[]) {
		int N = 10;
		getPascalTriangle(N);
	}

	public static int[][] getPascalTriangle(int N) {
		int mat[][] = new int[N][N];

		for (int r = 0; r < N; r++) {
			mat[r][r] = 1;
			mat[r][0] = 1;
		}

		for (int r = 2; r < N; r++) {
			for (int c = 1; c < r; c++) {
				mat[r][c] = mat[r - 1][c - 1] + mat[r - 1][c];
			}
		}
		Common.print2DArray(mat, " ");
		return mat;
	}
}
