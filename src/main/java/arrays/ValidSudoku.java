package arrays;

import utils.Common;

public class ValidSudoku {

	public static void main(String args[]) {
	// @// @formatter:off
		char board[][] = { 
				{ '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, 
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' }, 
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, 
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' }, 
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, 
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' }, 
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, 
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
                };
		
 
		// @formatter:on
		Common.println(toInt(board[0][0]));
		Common.println(isValidSudoku(board));
	}

	public static boolean isValidSudoku(char[][] board) {
		if (board == null || board.length != 9 || board[0].length != 9)
			return false;
		// check each column
		for (int i = 0; i < 9; i++) {
			boolean[] m = new boolean[9];
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					if (m[toInt(board[i][j])]) {
						return false;
					}
					m[toInt(board[i][j])] = true;
				}
			}
		}

		// check each row
		for (int j = 0; j < 9; j++) {
			boolean[] m = new boolean[9];
			for (int i = 0; i < 9; i++) {
				if (board[i][j] != '.') {
					if (m[toInt(board[i][j])]) {
						return false;
					}
					m[toInt(board[i][j])] = true;
				}
			}
		}

		// check each 3*3 matrix
		for (int block = 0; block < 9; block++) {
			boolean[] m = new boolean[9];
			for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
				for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
					Common.println("i = " + i + " j= " + j);
					if (board[i][j] != '.') {
						if (m[toInt(board[i][j])]) {
							return false;
						}
						m[toInt(board[i][j])] = true;
					}
				}
				Common.println("--------");
			}
			Common.println("--------------------------");
		}

		return true;
	}

	private static int toInt(char charter) {
		return (int) (charter - '1');
	}

}
