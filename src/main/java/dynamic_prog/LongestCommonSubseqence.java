package dynamic_prog;

import static utils.Common.intialize2DMatrix;
import static utils.Common.max;
import static utils.Common.print;
import static utils.Common.print2DArray;

/**
 * https://www.geeksforgeeks.org/array-rotation/
 * 
 * @author deepak
 *
 */
public class LongestCommonSubseqence {

	// Driver program to test above functions
	public static void main(String[] args) {
		print("Longest common sequence " + longestIncreasingSubsequence("ABCD".toCharArray(), "ABCF".toCharArray()));
	}

	private static int longestIncreasingSubsequence(char[] firstArr, char[] secondArr) {
		int flen = firstArr.length;
		int slen = secondArr.length;
		int row = slen + 1;
		int col = flen + 1;
		int mat[][] = new int[row][col];
		intialize2DMatrix(mat, 0);
		print2DArray("========", mat);
		for (int r = 0; r <= row; r++) {
			for (int c = 0; c <= col; c++) {
				print("r=>" + r + " | c => " + c);
				if (r == 0 || c == 0) {
					mat[r][c] = 0;
				} else if (secondArr[r - 1] == firstArr[c - 1]) {
					mat[r][c] = mat[r - 1][c - 1] + 1;
				} else {
					int max = max(mat[r - 1][c], mat[r][c - 1]);
					print("max => " + max + " secondArr[r - 1]" + secondArr[r - 1] + " firstArr[c - 1] =>"
							+ firstArr[c - 1]);
					mat[r][c] = max;
				}
				print2DArray("========", mat);
			}
		}
		return 0;
	}
}
