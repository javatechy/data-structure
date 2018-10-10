package dp;

import utils.Common;

/**
 * Longest Even Length Substring such that Sum of First and Second Half is same
 * 
 * https://www.geeksforgeeks.org/longest-even-length-substring-sum-first-second-half/
 * 
 * @author deepak
 *
 */
public class SubstringSumFirstAndSecondHalf {

	public static void main(String args[]) {

		// String str = "9430723";
		String str = "142124";

		int arr[] = Common.strToIntArray(str);
		Common.printArray(arr);
		iterativeSolution(arr);

		recursive(str);

	}

	// O(n^3)
	private static int iterativeSolution(int[] arr) {
		int size = arr.length;
		int countLen = 0;
		for (int i = 0; i < size; i++) {

			for (int j = i + 1; j < size; j++) {

				Common.println("i: " + i + " j: " + j);
				int mid = (i + j) / 2;
				// Common.println(" mid: " + mid);
				int sum1 = arr[i];
				int sum2 = arr[j];
				for (int k = i + 1; k <= mid; k++) {
					sum1 = sum1 + arr[k];
				}

				for (int k = mid + 1; k <= j - 1; k++) {
					sum2 = sum2 + arr[k];
				}

				// Common.println(" sum1: " + sum1 + " sum2: " + sum2);
				if (sum1 == sum2) {
					countLen = j - i + 1;
					Common.println("Found a match");
				}
			}
		}
		Common.println("TOtoal Len " + countLen);
		return countLen;
	}

	// DP
	private static int recursive(String str) {
		{
			int n = str.length();
			int maxlen = 0; // Initialize result

			// A 2D table where sum[i][j] stores
			// sum of digits from str[i] to str[j].
			// Only filled entries are the entries
			// where j >= i
			int sum[][] = new int[n][n];

			// Fill the diagonal values for
			// substrings of length 1
			for (int i = 0; i < n; i++)
				sum[i][i] = str.charAt(i) - '0';

			Common.printArray(sum);
			// Fill entries for substrings of
			// length 2 to n
			for (int len = 2; len <= n; len++) {
				// Pick i and j for current substring
				for (int i = 0; i < n - len + 1; i++) {
					int j = i + len - 1;
					int k = len / 2;

					// Calculate value of sum[i][j]
					sum[i][j] = sum[i][j - k] + sum[j - k + 1][j];

					// Update result if 'len' is even,
					// left and right sums are same
					// and len is more than maxlen
					if (len % 2 == 0 && sum[i][j - k] == sum[(j - k + 1)][j] && len > maxlen)
						maxlen = len;
				}
				Common.printArray(sum);
			}

			Common.printArray(sum);
			return maxlen;
		}
	}

}
