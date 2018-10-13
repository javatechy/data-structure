package dp;

import utils.Common;

public class TileCoverProblem {

	public static void main(String args[]) {
		int n = 5;
		int combination = countWays(n);
		Common.print(combination);

	}

	private static int countWays(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		return countWays(n - 1) + countWays(n - 2);
	}

}