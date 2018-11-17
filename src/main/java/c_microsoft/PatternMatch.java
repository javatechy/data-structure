package c_microsoft;

import java.util.HashMap;
import java.util.Map;

import utils.Common;

/**
 * Check Babylonian theorem for exact sqrt
 * 
 * https://www.geeksforgeeks.org/square-root-of-an-integer/
 *
 */
public class PatternMatch {

	public static void main(String[] args) {
		String[] inputs = { "abc", "xyz", "abb", "dxx" };
		String pat = "pzz";

		String patHash = hash(pat);
		Common.println(patHash);

		for (String input : inputs) {
			if (hash(input).equals(patHash)) {
				Common.println(input);
			}
		}

	}

	static String hash(String str) {
		int count = 0;
		Map<Character, Integer> map = new HashMap<>();
		String hash = "";
		for (int i = 0; i < str.length(); i++) {

			Integer c = map.get(str.charAt(i));

			if (c == null) {
				count++;
				map.put(str.charAt(i), count);
				c = count;
			}
			hash += c;
		}
		return hash;
	}

	/**
	 * O(√ n) Complexity
	 */
	public static int naive(int n) {
		int i = 1;
		int mul = 0;
		while (mul <= n) {
			i++;
			mul = i * i;
		}
		return i - 1;
	}

	/**
	 * Binary Search
	 */
	public static int squareRootBinarySearch(int n) {

		if (n == 1 || n == 0)
			return n;

		int start = 1;
		int end = n;
		int mid = 0;
		while (start <= end) {
			mid = (start + end) / 2;
			// Common.println("mid : "+mid);
			int mul = mid * mid;
			if (mul == n)
				return mid;
			if (mul < n)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return mid;
	}

	/**
	 * Square Root of any number
	 */
	public static float squareRootBabylonian(int n) {
		/*
		 * We are using n itself as initial approximation This can definitely be
		 * improved
		 */
		float x = n;
		float y = 1;

		// e decides the accuracy level
		double e = 0.000001;
		while (x - y > e) {

			x = (x + y) / 2;
			y = n / x;
			Common.println(" x = " + x + " , y = " + y);
		}
		return x;
	}
}
