package graph;

import java.util.LinkedList;
import java.util.Queue;

//import utils.Common;

public class RottenOrange {

	static boolean visited[][] = new boolean[6][6];

	public static void main(String arp[]) {
		happyCase();

		int[][] mat = invalidCase();
		int cycles = countCyclesForRottenOranges(mat, mat.length, mat[0].length);

		System.out.println(cycles);

	}

	private static int[][] invalidCase() {
		int mat[][] = { { 2, 1, 0, 2, 1 }, { 0, 0, 1, 2, 1 }, { 1, 0, 0, 2, 1 } };
		return mat;
	}

	private static int[][] happyCase() {
		//@// @formatter:off
		int mat[][] = {//  0  1    2    3   4   5
			/** 0 **/	{  2, 1,   0,   2,  1 }, 
			/** 1 **/	{  1, 0,   1,   2,  1 }, 
			/** 2 **/	{  1, 0,   0,   2,  1 }
					};
		// @formatter:on
		return mat;
	}

	private static int countCyclesForRottenOranges(int[][] mat, int rowCount, int colCount) {
		Queue<RC> queue = new LinkedList<>();
		for (int r = 0; r < rowCount; r++) {
			for (int c = 0; c < colCount; c++) {
				if (mat[r][c] == 2)
					queue.add(new RC(r, c));
			}
		}

		int cycles = 0;
		while (!queue.isEmpty()) {

			int rottenCount = queue.size();
			System.out.println("\n----------------------\n Cycle No : " + cycles);
			queue.stream().forEach(t -> System.out.println(t));
			cycles++;
			while (rottenCount > 0) {
				RC rowCol = queue.remove();
				addNeighbours(mat, rowCount, colCount, queue, rowCol.r, rowCol.c);
				rottenCount--;
			}

		}

		if (!isValid(mat, rowCount, colCount))
			return -1;
		return cycles - 1;
	}

	private static boolean isValid(int[][] mat, int rowCount, int colCount) {
		for (int r = 0; r < rowCount; r++) {
			for (int c = 0; c < colCount; c++) {
				if (mat[r][c] == 1)
					return false;
			}
		}
		return true;
	}

	private static boolean isValid(int[][] mat) {
		return false;
	}

	private static void addNeighbours(int[][] mat, int maxR, int maxC, Queue<RC> queue, int row, int col) {
		int rowComn[] = { -1, 1, 0, 0 };
		int colComn[] = { 0, 0, -1, 1 };
		for (int i = 0; i < rowComn.length; i++) {
			int newRow = row + rowComn[i];
			int newCol = col + colComn[i];
			if (newCol >= 0 && newRow >= 0 && newRow < maxR && newCol < maxC && mat[newRow][newCol] == 1) {
				mat[newRow][newCol] = 2;
				queue.add(new RC(newRow, newCol));
			}
		}
	}

	static class RC {
		public int r;
		public int c;

		RC(int r, int c) {

			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "[" + r + "," + c + "]";
		}
	}

}
