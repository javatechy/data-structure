package dp;

import utils.Common;

public class UglyNumber {

	public static void main(String args[]) {
		int n = 150;
		Common.println(findUgly(n));

	}

	private static int findUgly(int n) {

		int ugly[] = new int[n];

		int index_3 = 0, index_5 = 0, index_2 = 0;

		int next_2 = 2;
		int next_3 = 3;
		int next_5 = 5;

		ugly[0] = 1;

		for (int i = 1; i < n; i++) {

			int ugly_num = Common.min(next_2, next_3, next_5);

			ugly[i] = ugly_num;

			if (ugly_num == next_2) {
				index_2++;
				next_2 = ugly[index_2] * 2;
			}

			if (ugly_num == next_3) {
				index_3++;
				next_3 = ugly[index_3] * 3;
			}
			if (ugly_num == next_5) {
				index_5++;
				next_5 = ugly[index_5] * 5;
			}

			Common.println(i + " | " + next_2 + " | " + next_3 + " | " + next_5 + " |*| " + index_2
					+ " | " + index_3 + " | " + index_5 + " | "+ ugly_num + " | ");
		}
		return ugly[n - 1];
	}

}