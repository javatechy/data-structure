package c_microsoft;

import utils.Common;

/**
 * https://www.geeksforgeeks.org/print-a-pattern-without-using-any-loop/
 *
 */
public class PatternWithoutLoop {

	public static void main(String[] args) {
		int n = 16;
		int factor = 5;
		// pattern(n, n, factor, false);
		pattern2(n, factor);
	}

	/**
	 * Best
	 */
	private static void pattern2(int n, int factor) {
		Common.println(n);
		if (n <= 0) {
			return;
		}
		pattern2(n - factor, factor);
		Common.println(n);

	}

	private static void pattern(int n, int m, int factor, boolean flag) {
		Common.println(n);
		if (flag && m == n) {
			return;
		}
		if (!flag) {
			n = n - factor;
		}
		if (flag) {
			n = n + factor;
		}

		if (!flag && n <= 0) {
			flag = true;
		}
		pattern(n, m, factor, flag);

	}

	private static void printPatternInc(int m, int n, int factor) {
		Common.println(m);
		if (m == n) {
			return;
		}
		printPatternInc(m + factor, n, factor);

	}

	private static int printPattern(int n, int factor) {
		if (n <= 0) {
			return n;
		}
		Common.println(n);
		return printPattern(n - factor, factor);
	}

}
