package dp;

import java.util.Arrays;

import utils.Common;

public class MobileKeyPadProblem {

	public static void main(String args[]) {

//		@// @formatter:off
		char[][] keypad = { {'1','2','3'}, 
		        			{'4','5','6'}, 
		        			{'7','8','9'}, 
		        			{'*','0','#'} 
		    			  }; 
// @formatter:on
		// Common.println("Count for numbers of length 1: " + getCount(keypad, 1));
		Common.println("Count for numbers of length 2: " + getCount(keypad, 4));

	}

	private static int getCount(char[][] keypad, int n) {
		if (keypad == null || n <= 0)
			return 0;
		if (n == 1)
			return 10;

		// odd[i], even[i] arrays represent count of numbers starting
		// with digit i for any length j
		int odd[] = new int[10], even[] = new int[10];
		int i = 0, j = 0, useOdd = 0, totalCount = 0;

		Arrays.fill(odd, 1);

		// Bottom Up calculation from j = 2 to n
		for (j = 2; j <= n; j++) {
			useOdd = 1 - useOdd;

			// Here we are explicitly writing lines for each number 0
			// to 9. But it can always be written as DFS on 4X3 grid
			// using row, column array valid moves
			if (useOdd == 1) {
				setEvenOddArrays(odd, even);
			} else {
				setEvenOddArrays(even, odd);
			}
			Common.println("For Value  :  " + j + " and userOdd : " + useOdd);
			Common.printArray(odd);
			Common.printArray(even);
		}

		// Get count of all possible numbers of length "n" starting
		// with digit 0, 1, 2, ..., 9
		totalCount = 0;
		if (useOdd == 1) {
			for (i = 0; i <= 9; i++)
				totalCount += even[i];
		} else {
			for (i = 0; i <= 9; i++)
				totalCount += odd[i];
		}
		return totalCount;
	}

	private static void setEvenOddArrays(int[] odd, int[] even) {
		even[0] = odd[0] + odd[8];
		even[1] = odd[1] + odd[2] + odd[4];
		even[2] = odd[2] + odd[1] + odd[3] + odd[5];
		even[3] = odd[3] + odd[2] + odd[6];
		even[4] = odd[4] + odd[1] + odd[5] + odd[7];
		even[5] = odd[5] + odd[2] + odd[4] + odd[8] + odd[6];
		even[6] = odd[6] + odd[3] + odd[5] + odd[9];
		even[7] = odd[7] + odd[4] + odd[8];
		even[8] = odd[8] + odd[0] + odd[5] + odd[7] + odd[9];
		even[9] = odd[9] + odd[6] + odd[8];
	}
}