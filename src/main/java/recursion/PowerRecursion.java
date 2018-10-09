package recursion;

import utils.Common;

public class PowerRecursion {
	public static void main(String args[]) {
		int pow = findPower(10, 3);
		Common.println(pow);
	}

	private static int findPower(int x, int n) {
		if (n <= 0 || x == 1)
			return 1;

		return x * findPower(x, n - 1);
	}

}