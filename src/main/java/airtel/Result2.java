package airtel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.Common;

class Result2 {

	/*
	 * Complete the 'waysToChooseSum' function below.
	 *
	 * The function is expected to return a LONG_INTEGER_ARRAY. The function accepts
	 * following parameters: 1. LONG_INTEGER a 2. LONG_INTEGER b
	 */

	static int maxValue = -1;

	public static List<Long> waysToChooseSum(long a, long b) {
		// Write your code here

		int[] arr = new int[100];


		for (; a <= b; a++) {
			int value = 1;
			int sumDigit = getSum((int) a);

			if (arr[sumDigit] == 0) {
				arr[sumDigit] = value;
			} else {
				arr[sumDigit] = ++value;
			}

			if (value > maxValue) {
				maxValue = value;
			}

		}

		long count = arr[maxValue];
		// .println("Max Value " + maxValue + "\ncount : " + count);
		ArrayList<Long> arrayList = new ArrayList<>();
		arrayList.add((long) maxValue);
		arrayList.add(count);
		return arrayList;
	}

	static int getSum(int no) {
		return no == 0 ? 0 : no % 10 + getSum(no / 10);
	}

	public static void main(String arr[]) {
		List<Long> result = Result2.waysToChooseSum(1, 5);
		Common.print(result);
	}

}