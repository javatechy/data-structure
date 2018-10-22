package dp;

import utils.Common;

public class StringInterLeaving {

	public static void main(String args[]) {

		String first = "AB";
		String second = "CD";
		String third = "ACBD";

		/*
		 * first = "BCC"; second = "BBCA"; third = "BBCBCAC";
		 */
		if (first.length() + second.length() == third.length()) {
			boolean boolena = interleaveDp(first, second, third);
			Common.println(boolena);
		}
		Common.println(false);
	}

	/**
	 * This Method works only if strings are not repeating eg.(fails for this)
	 * String first = "BCC"; String second = "BBCA"; String third = "BBCBCAC";
	 */
	private static boolean interleave(String first, String second, String third) {
		// println("Comparing : " + first.substring(1) + " & " + second);

		if (first != null && first.length() >= 1 && first.charAt(0) == third.charAt(0)) {
			return interleave(first.substring(1), second, third.substring(1));
		}

		if (second != null && second.length() >= 1 && second.charAt(0) == third.charAt(0)) {
			return interleave(first, second.substring(1), third.substring(1));
		}

		if (second.length() == 0 && first.length() == 0 && third.length() == 0)
			return true;
		return false;
	}

	/**
	 * This Method works only if strings are not repeating eg.(fails for this)
	 * String first = "BCC"; String second = "BBCA"; String third = "BBCBCAC";
	 */
	private static boolean interleaveDp(String first, String second, String third) {

		int len1 = first.length();
		int len2 = second.length();

		boolean mat[][] = new boolean[len1 + 1][len2 + 1];

		mat[0][0] = true;

		for (int c = 1; c < mat[0].length; c++) {

			if (mat[0][c - 1] == true && third.charAt(c - 1) == second.charAt(c - 1)) {
				mat[0][c] = true;
			}
		}

		for (int r = 1; r < mat.length; r++) {
			if (mat[r - 1][0] == true && third.charAt(r - 1) == first.charAt(r - 1)) {
				mat[r][0] = true;
			}
		}

		for (int r = 1; r < mat.length; r++) {
			for (int c = 1; c < mat[0].length; c++) {
				if (mat[r][c - 1] || mat[r - 1][c]) {
					if (third.charAt(r + c - 1) == second.charAt(c - 1)
							|| third.charAt(r + c - 1) == first.charAt(r - 1))
						mat[r][c] = true;
				}
			}
		}
		Common.print2DArray(mat, " ");

		return mat[len1][len2];

	}

}