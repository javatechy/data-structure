package dp;

import java.util.LinkedList;
import java.util.Queue;

import utils.Common;

public class ChessMove {

	static boolean visted[][];

	public static void main(String args[]) {

		int source_row = 0;
		int source_col = 0;
		int dest_row = 7;
		int dest_col = 6;

		visted = new boolean[dest_row + 1][dest_col + 1];
		int min = findKingMinPath(source_row, source_col, dest_row, dest_col);

		// Common.print2DArray(visted, " ");
		Common.println("Min Path : " + min);
	}

	private static int findKingMinPath(int srcRow, int srcCol, int desRow, int desCol) {

		Queue<Cell> queue = new LinkedList<>();
		queue.add(new Cell(srcRow, srcCol, 0));

		int possibleRows[] = { -2, -2, -1, -1, 1, 1, 2, 2 };
		int possibleCols[] = { -1, 1, -2, 2, -2, 2, -1, 1 };

		while (!queue.isEmpty()) {
			Cell cell = queue.remove();
			int row = cell.r;
			int col = cell.c;
			visted[row][col] = true;
			// Common.println("------- ");
			//Common.print2DArray(visted, " ");
			if (row == desRow && col == desCol) {
				return cell.dist;
			}
			for (int i = 0; i < possibleRows.length; i++) {
				isPossible(possibleRows[i], possibleCols[i], row, col, queue, desRow, desCol, cell.dist);
			}

		}
		return -1;
	}

	private static void isPossible(int i, int j, int row, int col, Queue<Cell> queue, int desRow, int desCol,
			int distance) {
		int newRow = row + i;
		int newCol = col + j;
		if (newRow >= 0 && newCol >= 0 && newRow <= desRow && newCol <= desCol && !visted[newRow][newCol]) {
			//Common.println("R: " + newRow + "  |  C: " + newCol);
			queue.add(new Cell(newRow, newCol, distance + 1));
		}

	}

	static class Cell {
		public int r;
		public int c;
		public int dist;

		Cell(int r, int c, int distance) {
			this.r = r;
			this.c = c;
			this.dist = distance;
		}
	}

}