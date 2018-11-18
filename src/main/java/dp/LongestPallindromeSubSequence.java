package dp;

import utils.Common;

public class LongestPallindromeSubSequence {

	static int mat[][];

	public static void main(String args[]) {

		String str = "Nitpi";

		Common.println(lps(str, 0, str.length() - 1));
		lpsDp(str);
	}

	/**
	 * 0(2^n)
	 */
	public static int lps(String str, int start, int end) {

		if (start > end) {
			return 0;
		}
		if (start == end) {
			return 1;
		}

		if (str.charAt(start) == str.charAt(end)) {
			return 2 + lps(str, start + 1, end - 1);
		} else {
			return Math.max(lps(str, start + 1, end), lps(str, start, end - 1));
		}
	}

	/**
	 * 0(2^n)
	 */
	public static int lpsDp(String str) {

		int len = str.length();

		int[][] mat = new int[len][len];

		for (int i = 0; i < len; i++) {
			mat[i][i] = 1;
		}
		// k is diffierence
		for (int k = 1; k <= len - 1; k++) {
			for (int j = k; j <= (len - 1); j++) {
				int i = j - k;
				if (str.charAt(i) == str.charAt(j)) {
					mat[i][j] = 2 + mat[i + 1][j - 1];
				} else {
					mat[i][j] = Math.max(mat[i][j - 1], mat[i + 1][j]);
				}
			}
		}

		Common.print2DArray(mat);
		return mat[0][len - 1];
	}

}