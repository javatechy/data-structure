package c_microsoft;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import utils.Common;

/**
 * https://www.geeksforgeeks.org/find-first-non-repeating-character-stream-characters/
 *
 */
public class PrimeFactors {

	public static void main(String[] args) {
		int n = 315;

		List<Integer> factors = new LinkedList<>();
		primeFactors(factors, n);
		Common.println(factors);

	}

	public static void primeFactors(List<Integer> factors, int n) {
		// Print the number of 2s that divide n
		while (n % 2 == 0) {
			factors.add(2);
			n /= 2;
		}

		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			while (n % i == 0) {
				factors.add(i);
				n /= i;
			}
		}

		if (n > 2)
			factors.add(n);
	}

}
