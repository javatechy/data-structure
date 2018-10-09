package recursion;

import static utils.Common.println;

public class HanoiProblem {
	public static void main(String args[]) {
		hanoi("S", "D", "E", 200);
	}

	private static void hanoi(String source, String destination, String extra, int n) {
		if (n <= 0) {
			return;
		}
		hanoi(source, extra, destination, n - 1);
		println("FROM " + source + " -> " + destination + " [disk= " + n + "]");
		hanoi(extra, destination, source, n - 1);
	}

}
