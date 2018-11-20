package dp;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import utils.Common;

/**
 * This program will print no of ways and all the ways in which value X can be
 * scored using arr.
 * 
 * @author deepak
 *
 */
public class PrintAllWaysToScoreNumber {

	static Set<String> set = new TreeSet<>();

	public static void main(String args[]) {
		int X = 5;
		int arr[] = { 2, 3, 5, 6 };
		countWays(arr, X, 0, "");
		Common.println(set.size());
		set.stream().forEach(System.out::println);
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
		for (int ele : arr) {
			sum += countWays(arr, n - ele, ele, str);
		}
		return sum;
	}

	private static void addToSet(String inputString) {
		char tempArray[] = inputString.toCharArray();
		Arrays.sort(tempArray);
		String string = new String(tempArray);
		set.add(string);
	}

}