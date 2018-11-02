package airtel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.Common;

class Result {

	/*
	 * Complete the 'waysToChooseSum' function below.
	 *
	 * The function is expected to return a LONG_INTEGER_ARRAY. The function accepts
	 * following parameters: 1. LONG_INTEGER a 2. LONG_INTEGER b
	 */

	static int maxValue = -1;

	public static List<Long> waysToChooseSum(long a, long b) {
		// Write your code here

		Map<Long, Integer> map = new HashMap<>();
		
		for (; a <= b; a++) {

			Long sumDigit = getSum(a);
			if (map.get(sumDigit) == null) {
				map.put(sumDigit, 1);
				continue;
			}

			int value = map.get(sumDigit);
			map.put(sumDigit, ++value);
		}

		map.forEach((k, v) -> Common.println("k:" + k + " :: v :" + v));


		for (Map.Entry<Long, Integer> entry : map.entrySet()) {
			if (entry.getValue() > maxValue) {
				maxValue = entry.getValue();
			}
		}
		long count = map.values().parallelStream().filter(value -> value == maxValue).count();
		Common.println("Max Value " + maxValue + "\ncount  : " + count);
		ArrayList<Long> arrayList = new ArrayList<>();
		arrayList.add((long)maxValue);
		arrayList.add(count);
		return arrayList;
	}

	static long getSum(long n) {
		long sum;
		/* Single line that calculates sum */
		for (sum = 0; n > 0; sum += n % 10, n /= 10)
			;
		return sum;
	}

	public static void main(String arr[]) {
		List<Long> result = Result.waysToChooseSum(113, 129);
		Common.print(result);
	}

}