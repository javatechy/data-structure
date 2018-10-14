package graph;

import java.util.LinkedList;
import java.util.Queue;

import utils.Common;

public class Islands {

	static boolean visited[][] = new boolean[6][6];

	public static void main(String arp[]) {
		//@// @formatter:off
		int mat[][] = {//  0  1    2    3   4   5
			/** 0 **/	{  1, 1,   0,   0,  0,  0 }, 
			/** 1 **/	{  0, 1,   0,   0,  1,  0 }, 
			/** 2 **/	{  1, 0,   0,   1,  1,  0 }, 
			/** 3 **/	{  0, 0,   0,   0,  0,  0 }, 
			/** 4 **/	{  1, 0,   1,   0,  1,  0 } 
					};
		// @formatter:on

		int mat2[][] = { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 0, 1 } };
		Common.print2DArray(mat2, " ");
		int islands = findIslands(mat2, mat.length, mat2[0].length);
		Common.println("Totoal islands : " + islands);
	}

	private static int findIslands(int[][] mat, int row, int col) {
		int count = 0;
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				count += dfs(mat, r, c);
			}
		}
		return count;

	}

	private static int dfs(int[][] mat, int r, int c) {
		int maxR = mat.length; // 6
		int maxC = mat[0].length; // 6

		if (visited[r][c])
			return 0;
		if (mat[r][c] == 0)
			return 0;

		Queue<RC> queue = new LinkedList<>();
		queue.add(new RC(r, c));

		while (!queue.isEmpty()) {
			RC rc = queue.remove();
			int row = rc.r;
			int col = rc.c;
			Common.println("R = " + row + " ::: C = " + col);
			if (visited[row][col])
				continue;
			visited[row][col] = true;
			addNeighbours(mat, maxR, maxC, queue, row, col);
		}

		return 1;
	}

	private static void addNeighbours(int[][] mat, int maxR, int maxC, Queue<RC> queue, int row, int col) {
		int rowComn[] = { -1, -1, -1, 0, 1, 1, 1, 0 };
		int colComn[] = { -1, 0, 1, 1, 1, 0, -1, -1 };
		for (int i = 0; i < rowComn.length; i++) {
			int newRow = row + rowComn[i];
			int newCol = col + colComn[i];
			if (newCol >= 0 && newRow >= 0 && newRow < maxR && newCol < maxC && mat[newRow][newCol] == 1
					&& !visited[newRow][newCol]) {
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
	}

}
