package dynamic_prog;

import static utils.Common.intialize2DMatrix;
import static utils.Common.max;
import static utils.Common.print;
import static utils.Common.print2DArray;
import static utils.Common.println;

/**
 * Longest Common Subsequence
 * 
 * @author deepak
 */
public class LongestCommonSubseqence {

	private static final String SEPERATOR = " ";

	// Driver program to test above functions
	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "cba";
		// print("Longest common sequence " +
		// longestCommonSubsequenceDp(str1.toCharArray(), str2.toCharArray()));
		print("Longest common sequence " + longestCommonSubsequence(str1, str2));
	}

	private static int longestCommonSubsequenceDp(char[] firstArr, char[] secondArr) {
		int flen = firstArr.length;
		int slen = secondArr.length;
		int row = flen + 1;
		int col = slen + 1;
		int mat[][] = new int[row][col];
		intialize2DMatrix(mat, 0);
		print2DArray(mat, SEPERATOR);
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				println("r=>" + r + " | c => " + c);
				if (r == 0 || c == 0) {
					mat[r][c] = 0;
				} else if (firstArr[r - 1] == secondArr[c - 1]) {
					mat[r][c] = mat[r - 1][c - 1] + 1;
				} else {
					int max = max(mat[r - 1][c], mat[r][c - 1]);
					mat[r][c] = max;
				}
				print2DArray(mat, SEPERATOR);
				println();
			}
		}
		return mat[row - 1][col - 1];
	}

	public static String longestCommonSubsequence(String a, String b) {
		println(a + "  ||  " + b);
		int alength = a.length() - 1;
		int blength = b.length() - 1;

		if (alength < 0 || blength < 0)
			return "";

		if (a.substring(alength).equals(b.substring(blength))) {
			return longestCommonSubsequence(a.substring(0, alength), b.substring(0, blength)) + a.substring(alength);
		} else {
			String first = longestCommonSubsequence(a, b.substring(0, blength));
			String second = longestCommonSubsequence(a.substring(0, alength), b);
			if (first.length() > second.length()) {
				return first;
			} else {
				return second;
			}
		}
	}
}
