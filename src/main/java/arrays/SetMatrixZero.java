package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.Common;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 * 
 * @author deepak
 *
 */
public class SetMatrixZero {

	// Driver program to test above functions
	public static void main(String[] args) {
		int mat[][] = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };

		setZero(mat);
		Common.print2DArray(mat, " ");
	}

	private static void setZero(int[][] mat) {

		List<RowCol> rows = new ArrayList<>();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (mat[i][j] == 0) {
					rows.add(new RowCol(i, j));
				}
			}
			System.out.println();
		}

		for (RowCol row : rows) {

			for (int j = 0; j < mat[0].length; j++) {
				mat[row.row][j] = 0;
			}

			for (int j = 0; j < mat.length; j++) {
				mat[j][row.col] = 0;
			}
		}
	}

	static class RowCol {

		RowCol(int r, int c) {
			this.row = r;
			this.col = c;
		}

		public int row;
		public int col;
	}
}
