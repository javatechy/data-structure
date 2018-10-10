package recursion;

import utils.Common;

public class Fibonaaci {

	private static int[] memo = new int[100];

	public static void main(String args[]) {
		int n = 40;
		int sum = fibonaaciIterative(n);
		Common.println("Sum is " + sum);

		//sum = fibonaaciRecursive(n);
		Common.println("Sum is " + sum);

		sum = fibonaaciMemoization(n);
		Common.println("Sum is " + sum);

	}

	private static int fibonaaciMemoization(int n) {
		if (n == 1 || n == 2)
			return 1;

		if (memo[n] != 0) {
			return memo[n];
		}
		//Common.println(n);
		memo[n] = fibonaaciMemoization(n - 1) + fibonaaciMemoization(n - 2);
		return memo[n];
	}

	private static int fibonaaciRecursive(int n) {
		if (n == 1 || n == 2)
			return 1;
		Common.println(n);
		return fibonaaciRecursive(n - 1) + fibonaaciRecursive(n - 2);
	}

	private static int fibonaaciIterative(int n) {
		int a = 1, b = 1, c = 0;
		for (int i = 3; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return b;
	}

}