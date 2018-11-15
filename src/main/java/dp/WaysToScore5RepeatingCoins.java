package dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import utils.Common;

/**
 * This program will print no of ways and all the ways in which value X can be
 * scored using arr.
 * 
 * @author deepak
 *
 */
public class WaysToScore5RepeatingCoins {

	static Set<String> list = new HashSet<>();

	public static void main(String args[]) {
		int X = 7;
		int arr[] = { 1,  3 };
		countWays(arr, X, 0, "");
		Common.println(list.size());
		list.stream().forEach(System.out::println);
	}

	private static int countWays(int arr[], int n, int pass, String str) {
		if (n < 0)
			return 0;
		if (n == 0) {
			str = str + pass;
			addToSet(str);
			return 1;
		}

		if (pass != 0)
			str = str + (pass);
		int sum = 0;
		for (int i : arr) {
			sum += countWays(arr, n - i, i, str);
		}
		return sum;
	}

	private static void addToSet(String inputString) {
		char tempArray[] = inputString.toCharArray();
		Arrays.sort(tempArray);
		String string = new String(tempArray);
		list.add(string);
	}

}