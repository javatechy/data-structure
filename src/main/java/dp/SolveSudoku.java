package dp;

import utils.Common;

public class SolveSudoku {

	public static void main(String args[]) {

		//@// @formatter:off
		int[][] board = new int[][] 
			    { 
			            {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
			            {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
			            {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
			            {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
			            {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
			            {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
			            {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
			            {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
			            {0, 0, 5, 2, 0, 6, 3, 0, 0} 
			    }; 
		// @formatter:on
		if (solveSudoku(board)) {
			Common.print2DArray(board);
		} else {
			System.out.println("No solution");
		}
	}

	private static boolean solveSudoku(int[][] board) {

		boolean isComplete = true;

		int row = 0;
		int col = 0;
		int size = board.length;
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				if (board[r][c] == 0) {
					row = r;
					col = c;
					isComplete = false;
					break;
				}
			}
			// Get out of outer loop if not complete
			if (!isComplete)
				break;
		}
		if (isComplete) {
			return true;
		}

		Common.println("Row : " + row + "   Col :" + col);

		for (int num = 1; num <= 9; num++) {
			if (isSudokuValid(board, row, col, num)) {
				board[row][col] = num;
				if (solveSudoku(board)) {
					return true;
				} else {
					board[row][col] = 0;
				}
			}
		}

		return false;
	}

	private static boolean isSudokuValid(int[][] board, int row, int col, int num) {
		// Checked Row wise
		int len = board.length;
		for (int i = 0; i < len; i++) {
			if (board[row][i] == num || board[i][col] == num)
				return false;
		}

		// checking row col 3X3
		int sqrt = (int) Math.sqrt(len);

		int rowStart = row - row % sqrt;
		int colStart = col - col % sqrt;

		int rowMax = row + sqrt;
		int colMax = col + sqrt;

		for (int r = rowStart; r < rowMax; r++) {

			for (int c = colStart; c < colMax; c++) {
				if (board[row][col] == num)
					return false;
			}
		}
		return true;
	}
}
