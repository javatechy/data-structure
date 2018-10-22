package dp;

import utils.Common;

public class LongestCommonSubSequence {

	static int mat[][];

	public static void main(String args[]) {
		String str1 = "ABCD";
		String str2 = "ABED";

		mat = new int[str1.length() + 1][str2.length() + 1];
		Common.intialize2DMatrix(mat, -1);

		int res = lcsDp(str1, str2, str1.length(), str2.length());

		Common.print2DArray(mat, " , ");
		Common.println(res);
	}

	private static int lcs(String str1, String str2, int len1, int len2) {
		if (len1 == 0 || len2 == 0)
			return 0;

		if (str1.charAt(len1 - 1) == str2.charAt(len2 - 1))
			return 1 + lcs(str1, str2, len1 - 1, len2 - 1);

		return Math.max(lcs(str1, str2, len1, len2 - 1), lcs(str1, str2, len1 - 1, len2));
	}

	private static int lcsMemo(String str1, String str2, int len1, int len2) {
		System.out.println("Setting mat[" + len1 + "][" + len2 + "] " + mat[len1][len2]);
		if (len1 == 0 || len2 == 0)
			return 0;

		if (mat[len1][len2] != -1) {
			return mat[len1][len2];
		}
		if (str1.charAt(len1 - 1) == str2.charAt(len2 - 1)) {
			mat[len1][len2] = 1 + lcs(str1, str2, len1 - 1, len2 - 1);
		} else {
			mat[len1][len2] = Math.max(lcs(str1, str2, len1, len2 - 1), lcs(str1, str2, len1 - 1, len2));
		}
		return mat[len1][len2];
	}

	private static int lcsDp(String str1, String str2, int len1, int len2) {
		mat = new int[len1 + 1][len2 + 1];

		for (int r = 1; r < mat.length; r++) {
			for (int c = 1; c < mat[0].length; c++) {
				if (str1.charAt(r - 1) == str2.charAt(c - 1)) {
					mat[r][c] = mat[r - 1][c - 1] + 1;
				} else {
					mat[r][c] = Math.max(mat[r - 1][c], mat[r][c - 1]);
				}
			}
		}

		// Printing Common String
		for (int r = 1; r < mat.length; r++) {
			for (int c = 1; c < mat[0].length; c++) {
				if (mat[r][c] == mat[r - 1][c - 1])
					Common.println(str1.charAt(r - 1));
			}
		}

		return mat[len1][len2];
	}

}