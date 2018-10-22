package dp;

import java.util.ArrayList;
import java.util.List;

import utils.Common;

/**
 * https://leetcode.com/problems/pascals-triangle/submissions/
 */
public class PascalTriangle {

	public static void main(String args[]) {
		int N = 10;
		pascalTriangleArray(N);
	}

	public static List<List<Integer>> pascalTriangleArray(int N) {
		List<List<Integer>> list = new ArrayList<>();

		int[] first = { 1 };

		list.add(Common.arrayToList(first));

		if (N == 0)
			return list;
		if (N < 1)
			return new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			int[] second = new int[i + 1];
			second[0] = 1;
			for (int j = 1; j < first.length; j++) {
				int element = first[j] + first[j - 1];
				second[j] = element;
			}
			second[i] = 1;
			// Common.printArray(first);
			Common.printArray(second);
			List<Integer> intList = Common.arrayToList(second);
			list.add(intList);
			first = second;
		}
		list.forEach(t -> Common.print(t));
		return list;
	}

	public static int[][] getPascalTriangle(int N) {
		int mat[][] = new int[N][N];

		for (int r = 0; r < N; r++) {
			mat[r][r] = 1;
			mat[r][0] = 1;
		}

		for (int r = 2; r < N; r++) {
			for (int c = 1; c < r; c++) {
				mat[r][c] = mat[r - 1][c - 1] + mat[r - 1][c];
			}
		}
		Common.print2DArray(mat, " ");
		return mat;
	}
}
