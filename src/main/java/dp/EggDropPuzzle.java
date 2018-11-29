package dp;

import static utils.Common.max;
import static utils.Common.print2DArray;
import static utils.Common.println;

public class EggDropPuzzle {
	volatile static int changes;

	public static void main(String arr[]) {
		println("No of Changes  Needed to convert string are " + eggDropDp(3, 100));
	}

	private static int eggDropDp(int neggs, int kfloors) {
		/*
		 * A 2D table where entry eggFloor[i][j] will represent minimum number of trials
		 * needed for i eggs and j floors.
		 */
		int eggFloor[][] = new int[neggs + 1][kfloors + 1];
		int res;
		int i, j, x;

		// We need one trial for one floor and0 trials for 0 floors
		for (i = 1; i <= neggs; i++) {
			eggFloor[i][1] = 1;
			eggFloor[i][0] = 0;
		}
		print2DArray(eggFloor, "  ");
		println();
		// We always need j trials for one egg and j floors.
		for (j = 1; j <= kfloors; j++)
			eggFloor[1][j] = j;
		print2DArray(eggFloor, "  ");
		println();
		// Fill rest of the entries in table using optimal substructure
		// property
		for (i = 2; i <= neggs; i++) {
			for (j = 2; j <= kfloors; j++) {
				eggFloor[i][j] = Integer.MAX_VALUE;
				for (x = 1; x <= j; x++) {
					res = 1 + max(eggFloor[i - 1][x - 1], eggFloor[i][j - x]);
					if (res < eggFloor[i][j])
						eggFloor[i][j] = res;
				}
				print2DArray(eggFloor, "  ");
				println();
			}
		}

		// eggFloor[n][k] holds the result
		return eggFloor[neggs][kfloors];
	}

}
