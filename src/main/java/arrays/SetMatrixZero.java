package arrays;

import java.util.ArrayList;
import java.util.List;

import utils.Common;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 * 
 * And Page : 216 : CTCI We can reduce the space to 0(1) by using the first row
 * as a replacement for the row array and the first column as a replacement for
 * the column array. This works as follows:
 * 
 * 1. Check if the first row and first column have any zeros, and set variables
 * rowHasZero and columnHasZero. (We'll nullify the first row and first column
 * later, if necessary.)
 * 
 * 2. Iterate through the rest of the matrix, setting matrix[ i] [ 0) and matrix
 * [ 0) [ j] to zero whenever there's a zero in matrix[i] [j ].
 * 
 * 3. Iterate through rest of matrix, nullifying row i if there's a zero in
 * matrix [ i] [ 0].
 * 
 * 4. Iterate through rest of matrix, nullifying column j if there's a zero in
 * matrix [ 0] [ j]. 5. Nullify the first row and first column, if necessary
 * (based on values from Step 1 ).
 * 
 * @author deepak
 *
 */
public class SetMatrixZero {

	// Driver program to test above functions
	public static void main(String[] args) {
		int mat[][] = { { 9, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 0, 1, 5 }, { 1, 3, 1, 5 }, { 1, 3, 1, 5 } };
		Common.print2DArray(mat, " ");
		setZeroNoExtraSpace(mat, mat.length, mat[0].length);

		Common.print2DArray(mat, " ");
	}

	/**
	 * No External space
	 * 
	 * @param mat
	 */
	private static void setZeroNoExtraSpace(int[][] mat, int R, int C) {
		boolean isRowHasZero = false;
		boolean isColHasZero = false;

		for (int c = 0; c < C; c++) {
			if (mat[0][c] == 0) {
				isRowHasZero = true;
			}
		}

		for (int r = 0; r < C; r++) {
			if (mat[r][0] == 0) {
				isColHasZero = true;
			}
		}
		for (int r = 1; r < R; r++) {
			for (int c = 1; c < C; c++) {
				if (mat[r][c] == 0) {
					mat[r][0] = 0;
					mat[0][c] = 0;
				}
			}
		}

		for (int c = 1; c < C; c++) {
			if (mat[0][c] == 0) {
				nullifyCol(mat, c, R);
			}
		}
		for (int r = 1; r < C; r++) {
			if (mat[r][0] == 0) {
				nullifyRow(mat, r, C);
			}
		}

		if (isRowHasZero) {
			nullifyRow(mat, 0, C);
		}

		if (isColHasZero) {
			nullifyCol(mat, 0, R);
		}

	}

	private static void nullifyRow(int[][] mat, int row, int C) {
		for (int c = 0; c < C; c++)
			mat[row][c] = 0;
	}

	private static void nullifyCol(int[][] mat, int col, int R) {
		for (int r = 0; r < R; r++)
			mat[r][col] = 0;
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

			for (int j = 0; j < mat.length; j++) {
				mat[row.row][j] = 0;
			}

			for (int j = 0; j < mat[0].length; j++) {
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
