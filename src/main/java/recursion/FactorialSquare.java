package recursion;

import static utils.Common.println;

public class FactorialSquare {
	public static void main(String args[]) {

		int n = 3;
		int fact = factorial(n);
		println("fact : " + fact);
		fact = recursiveFactorialSq(n);
		println("Square  : " + fact);
	}

	private static int recursiveFactorialSq(int n) {
		return factorial(n * n);
	}

	private static int factorial(int n) {
		if (n == 0 || n == 1)
			return 1;
		return n * factorial(n - 1);
	}
}
