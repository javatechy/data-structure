package dp;

import c_microsoft.LargestRectangularAreaHistogram;

public class MaximumRectangleSizeMatrix {

	static int mat[][];

	public static void main(String args[]) {
//		@// @formatter:off
		int arr[][] = { { 0, 0, 1, 1, 1 }, 
						{ 1, 1, 1, 1, 1 }, 
						{ 0, 1, 1, 1, 1 }, 
						{ 1, 0, 1, 1, 1 } 
					 };
// @formatter:on
		int result = maxSize(arr);
		System.out.print(result);
	}

	private static int maxSize(int[][] arr) {

		int rlen = arr.length;
		int clen = arr[0].length;
		int maxVal = 0;

		int dpArray[] = new int[clen];
		for (int r = 0; r < rlen; r++) {
			int area = LargestRectangularAreaHistogram.getMaxArea(addRow(dpArray, arr[r]));
			if (maxVal < area)
				maxVal = area;

		}
		return maxVal;
	}

	private static int[] addRow(int[] dpArray, int[] is) {
		for (int i = 0; i < is.length; i++) {
			if (is[i] == 1) {
				dpArray[i] += is[i];
			}
		}

		return dpArray;
	}

}