package dp;

import utils.Common;

public class LongestBitonicSubSequence {

	static int mat[][];

	public static void main(String args[]) {
		int arr[] = { 1, 11, 2, 10, 4, 5, 2, 1 };

		Common.print(lbs(arr));
	}

	private static int lbs(int[] arr) {
		int len = arr.length;
		int lis[] = LongestIncreasingSubSequence.lis(arr);
		int lds[] = LongestDecreasingSubSequence.ldsReverse(arr);
		Common.printArray(lis);
		Common.printArray(lds);
		int max = lis[0] + lds[0] - 1;
		for (int i = 0; i < len; i++) {
			if (max < (lis[i] + lds[i] - 1)) {
				max = lis[i] + lds[i] - 1;
			}
		}
		return max;
	}

}