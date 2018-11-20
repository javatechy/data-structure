package dp;

import java.util.Arrays;

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
		matrices[0] = new Dimension(2, 3);
		matrices[1] = new Dimension(3, 6);
		matrices[2] = new Dimension(6, 4);
		matrices[3] = new Dimension(4, 5);
		int maxCost = matrixMultiplyCost(matrices);
	}

	private static int matrixMultiplyCost(Dimension[] matrices) {

		int size = matrices.length;
		int[][] cost = new int[size][size];

		int arr[] = buildArray(matrices);

		Common.printArray(arr);
		// Diagonal is already zero
		// Find cost
		for (int k = 1; k < size; k++) {
			for (int i = 0; i < size - k; i++) {
				int j = i + k;
				if (k == 1) {
					cost[i][j] = multiplyCost(matrices[i], matrices[j]);
					continue;
				}
				cost[i][j] = Integer.MAX_VALUE;

				for (int p = i + 1; p < j; p++) {
					int multiplyCost = cost[i][p] + cost[p + 1][j] + arr[i] * arr[p] * arr[j];
					Common.println(" costing: " + multiplyCost + " for i = " + i + " j = " + j + "  p = " + p + " is "
							+ multiplyCost);
					if (multiplyCost < cost[i][j]) {
						cost[i][j] = multiplyCost;
					}
				}
			}
		}
		Common.print2DArray(cost);
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