package dp;

import java.util.Arrays;

import utils.Common;

public class MinimumJump {

	public static void main(String args[]) {

		int arr[] = { 2, 3, 1, 1, 2, 4, 2, 0, 1, 1 };

		int X = 5;

		int res = miminimuSteps(arr);
		Common.println(res);

	}

	private static int miminimuSteps(int[] arr) {
		int n = arr.length;

		int[] jump = new int[n];
		int[] ackJump = new int[n];

		for (int i = 1; i < n; i++) {
			jump[i] = 1000000;

			for (int j = 0; j < i; j++) {
				if (arr[j] + j >= i) {
					int steps = jump[j] + 1;
					if (steps < jump[i]) {
						jump[i] = steps;
						ackJump[i] = j;
					}
				}
			}
		}
		Common.printArray(jump);
		Common.printArray(ackJump);

		// to reach last location
		
		return 0;
	}
}