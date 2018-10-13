package dp;

import utils.Common;

public class EditDistance {

	public static void main(String args[]) {
		String first = "SUNDAY";
		String second = "DEEPAK";
		int distance = editDistance(first, second);
		Common.println(distance);

	}

	private static int editDistance(String first, String second) {
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

}