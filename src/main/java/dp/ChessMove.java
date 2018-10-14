package dp;

import static utils.Common.intialize2DMatrix;
import static utils.Common.min;
import static utils.Common.print2DArray;
import static utils.Common.println;

import utils.Common;

public class ChessMove {

	static int mat[][] = new int[8][8];

	public static void main(String args[]) {

		int source_row = 0;
		int source_col = 0;

		int dest_row = 0;
		int dest_col = 0;

		int min = findKingMinPath(dest_row, dest_col);

		Common.println("Min Path : " + min);
	}

	private static int findKingMinPath(int des_r, int des_c) {

		if (des_r == 0 && des_c == 0) {
			return 0;
		}

		if (des_r > 0 || des_c > 0) {
			return 1;
		}

		int rc_1 = findKingMinPath(des_r, des_c - 1);
		int r_1c = findKingMinPath(des_r - 1, des_c);
		int r_1c_1 = findKingMinPath(des_r - 1, des_c - 1);
		return Common.min(rc_1, r_1c, r_1c_1);

	}

}