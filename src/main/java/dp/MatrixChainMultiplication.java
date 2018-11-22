package dp;

import utils.Common;

class Dimension {
	public int row;
	public int col;

	Dimension(int row, int col) {
		this.row = row;
		this.col = col;
	}

	@Override
	public String toString() {
		return "Dimension [row=" + row + ", col=" + col + "]";
	}

}

public class MatrixChainMultiplication {

	public static void main(String args[]) {
		Dimension[] matrices = new Dimension[4];
		matrices[0] = new Dimension(5, 4);
		matrices[1] = new Dimension(4, 6);
		matrices[2] = new Dimension(6, 2);
		matrices[3] = new Dimension(2, 7);
		int maxCost = matrixMultiplyCost(matrices);
	}

	private static int matrixMultiplyCost(Dimension[] matrices) {

		int size = matrices.length;
		int[][] cost = new int[size][size];
		int[][] bracket = new int[size][size];

		int arr[] = buildArray(matrices);

		Common.printArray(arr);
		// Diagonal is already zero
		// Find cost
		for (int d = 1; d < size; d++) {
			for (int i = 0; i < size - d; i++) {
				int j = i + d;
				Common.println("  for i = " + i + " j = " + j);

				if (d == 1) {
					cost[i][j] = multiplyCost(matrices[i], matrices[j]);
					bracket[i][j] =i;
					continue;
				}

				cost[i][j] = Integer.MAX_VALUE;

				for (int k = i; k < j; k++) {
					int multiplyCost = 0;
					int factpr = arr[i] * arr[k+1] * arr[j + 1];
					multiplyCost = cost[i][k] + cost[k + 1][j] + factpr;
					Common.println(" factpr: " + factpr + " for i = " + (i) + " j = " + j + "  k = " + k + " is "
							+ multiplyCost);
					if (multiplyCost < cost[i][j]) {
						cost[i][j] = multiplyCost;
						bracket[i][j] =k;
					}
				}
			}
		}
		Common.print2DArray(cost);
		Common.print2DArray(bracket);
		return 0;
	}

	private static int[] buildArray(Dimension[] matrices) {
		int arr[] = new int[matrices.length + 1];

		int i = 0;
		for (Dimension dim : matrices) {
			arr[i] = dim.row;
			i++;
		}
		arr[i] = matrices[matrices.length - 1].col;
		return arr;
	}

	static int multiplyCost(Dimension d1, Dimension d2) {
		return d1.row * d1.col * d2.col;

	}
}