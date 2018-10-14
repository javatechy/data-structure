package dp;

import static utils.Common.intialize2DMatrix;
import static utils.Common.min;
import static utils.Common.print2DArray;
import static utils.Common.println;

import utils.Common;

public class EditDistance {

	private static final String SEPERATOR = " ";

	public static void main(String args[]) {
		String first = "DEEPAK";
		String second = "PREETI";
		int distance = editDistance(first, second);
		Common.println(distance);

		// println("No of Changes Needed to convert string are " +
		editDistanceDp(first, second);

	}

	private static int editDistance(String first, String second) {
		println("Comparing : " + first + " & " + second);
		if (first == null || first.length() == 0)
			return second.length();

		if (second == null || second.length() == 0)
			return first.length();

		int len1 = first.length();
		int len2 = second.length();

		if (first.charAt(0) == second.charAt(0)) {
			return editDistance(first.substring(1, len1), second.substring(1, len2));
		}

		int d = editDistance(first.substring(1, len1), second);
		int u = editDistance(first.substring(1, len1), second.substring(1, len2));
		int i = editDistance(first, second.substring(1, len2));
		return Common.min(d, u, i) + 1;
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
	 * 
	 * 0 1 2 3 4 5 6 
	 1 1 2 3 4 5 6 
2 2 2 2 3 4 5 
3 3 3 2 2 3 4 
4 3 4 3 3 3 4 
5 4 4 4 4 4 4 
6 5 5 5 5 5 5 
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