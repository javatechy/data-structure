package c_microsoft;

import java.util.Map;
import java.util.TreeMap;

import utils.Common;

/**
 * 
 * https://www.geeksforgeeks.org/find-recurring-sequence-fraction/
 *
 * Input : Numerator = 8, Denominator = 3
 * 
 * Output : Recurring sequence is 6
 * 
 * Explanation : 8/3 = 2.66666666.......
 */
public class RecurringSequence {

	public static void main(String[] args) {

		// Common.println(findRecurringSeq(8, 3));
		Common.println(findRecurringSeq(50, 22));

	}

	private static String findRecurringSeq(int numr, int denr) {

		String res = "";

		Map<Integer, Integer> mp = new TreeMap<>();

		int rem = numr % denr;
		// 2
		Common.println("Adding in map : key: " + rem + " value: " + res.length());
		
		while ((rem != 0) && (!mp.containsKey(rem))) {
			Common.println("Adding in map : key: " + rem + " value: " + res.length());
			mp.put(rem, res.length());

			rem = rem * 10;

			Common.println("REM : " + rem);

			int res_Part = rem / denr;

			res += Integer.toString(res_Part);

			rem = rem % denr;

		}

		return (rem == 0) ? "" : res.substring(mp.get(rem));

	}

}
