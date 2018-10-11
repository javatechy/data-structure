package dp;

import utils.Common;

public class Combination {

	public static void main(String args[]) {
		int n = 15;
		int m = 4;

		int combination = combination(n, m);
		Common.println("combination: " + combination);

		Common.println("\n combination by dp " + combinationDp(n, m));

	}

	private static int combination(int n, int m) {
		if (n == 0 || m == 0)
			return 1;
		if (n == m)
			return 1;
		return combination(n - 1, m) + combination(n - 1, m - 1);
	}

	private static int combinationDp(int n, int m) {
		return PascalTriangle.getPascalTriangle(n+1)[n][m];
	}

}