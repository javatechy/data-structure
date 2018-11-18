package dp;

import utils.Common;

public class BooleanParenthesization {

	public static void main(String args[]) {

		char symbols[] = { 'T', 'T', 'F', 'T' };
		char operators[] = { '|', '&', '^' };
		int n = symbols.length;

		// There are 4 ways
		// ((T|T)&(F^T)), (T|(T&(F^T))), (((T|T)&F)^T) and (T|((T&F)^T))
		Common.println(countParenth(symbols, operators, n));
	}

	// Returns count of all possible parenthesizations that lead to
	// result true for a boolean expression with symbols like true
	// and false and operators like &, | and ^ filled between symbols
	static int countParenth(char symb[], char oper[], int n) {
		int false2DArray[][] = new int[n][n];
		int true2DArray[][] = new int[n][n];

		// Fill diaginal entries first
		// All diagonal entries in T[i][i] are 1 if symbol[i]
		// is T (true). Similarly, all F[i][i] entries are 1 if
		// symbol[i] is F (False)
		for (int i = 0; i < n; i++) {
			false2DArray[i][i] = (symb[i] == 'F') ? 1 : 0;
			true2DArray[i][i] = (symb[i] == 'T') ? 1 : 0;
		}

		printArrays(false2DArray, true2DArray);

		// Now fill T[i][i+1], T[i][i+2], T[i][i+3]... in order
		// And F[i][i+1], F[i][i+2], F[i][i+3]... in order
		for (int gap = 1; gap < n; ++gap) {
			Common.println("----- Updating gap : ---- " + gap);
			for (int i = 0, j = gap; j < n; ++i, ++j) {
				Common.println("i : " + i + " | j=" + j);
				true2DArray[i][j] = false2DArray[i][j] = 0;
				for (int g = 0; g < gap; g++) {
					// Find place of parenthesization using current value
					// of gap
					int k = i + g;
					Common.println("      g=" + g +"      k=" + k);
					// Store Total[i][k] and Total[k+1][j]
					int tik = true2DArray[i][k] + false2DArray[i][k];
					int tkj = true2DArray[k + 1][j] + false2DArray[k + 1][j];

					// Follow the recursive formulas according to the current
					// operator
					if (oper[k] == '&') {
						true2DArray[i][j] += true2DArray[i][k] * true2DArray[k + 1][j];
						false2DArray[i][j] += (tik * tkj - true2DArray[i][k] * true2DArray[k + 1][j]);
					}
					if (oper[k] == '|') {
						false2DArray[i][j] += false2DArray[i][k] * false2DArray[k + 1][j];
						true2DArray[i][j] += (tik * tkj - false2DArray[i][k] * false2DArray[k + 1][j]);
					}
					if (oper[k] == '^') {
						true2DArray[i][j] += false2DArray[i][k] * true2DArray[k + 1][j]
								+ true2DArray[i][k] * false2DArray[k + 1][j];
						false2DArray[i][j] += true2DArray[i][k] * true2DArray[k + 1][j]
								+ false2DArray[i][k] * false2DArray[k + 1][j];
					}
				}
			}
		}

		printArrays(false2DArray, true2DArray);
		return true2DArray[0][n - 1];
	}

	private static void printArrays(int[][] false2DArray, int[][] true2DArray) {
		Common.println("---------------------------------------------------");

		Common.print2DArray(true2DArray);
		Common.println("------F---------");
		Common.print2DArray(false2DArray);
	}

}