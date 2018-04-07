package dynamic_prog;

import static utils.Common.intialize2DMatrix;
import static utils.Common.min;
import static utils.Common.print2DArray;
import static utils.Common.println;

public class KnapsackProblem {
	private static final String SEPERATOR = " ";
	volatile static int changes;

	public static void main(String arr[]) {
		println("No of Changes  Needed to convert string are " + editDistanceDp("CART", "MARCH"));

	}

	private static int editDistanceDp(String first, String second) {
		int flen = first.length();
		int slen = second.length();
		int row = flen + 1;
		int col = slen + 1;
		int mat[][] = new int[row][col];
		initialSetup(row, col, mat);
		println("Starting logic");
		for (int r = 1; r < row; r++) {
			for (int c = 1; c < col; c++) {
				println("Compairing " + first.charAt(r - 1) + "  & " + second.charAt(c - 1));
				if (first.charAt(r - 1) != second.charAt(c - 1)) {
					// find min between left right and dignal and add 1
					int left = mat[r - 1][c];
					int right = mat[r][c - 1];
					int diagonal = mat[r - 1][c - 1];
					mat[r][c] = min(left, right, diagonal) + 1;
				} else {
					mat[r][c] = mat[r - 1][c - 1];
				}
				print2DArray(mat, SEPERATOR);
			}
			// print2DArray(mat, SEPERATOR);
		}

		return mat[flen][slen];

	}

	//@// @formatter:off

	/**
	 * Initialize with NULL and 123
	 * 
	 *    ~ M A R C H
	 * ~  0 1 2 3 4 5 
	 * C  1 0 0 0 0 0 
	 * A  2 0 0 0 0 0 
	 * R  3 0 0 0 0 0 
	 * T  4 0 0 0 0 0 
	 */
	 
	// @formatter:on

	private static void initialSetup(int row, int col, int[][] mat) {
		intialize2DMatrix(mat, 0);
		mat[0][0] = 0;
		for (int i = 1; i < row; i++) {
			mat[i][0] = i;
			// print2DArray(mat, SEPERATOR);
		}
		for (int i = 1; i < col; i++) {
			mat[0][i] = i;
		}
		print2DArray(mat, SEPERATOR);
	}

}
