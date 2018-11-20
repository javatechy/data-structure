package c_microsoft;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

import utils.Common;

/**
 * https://www.geeksforgeeks.org/power-set/
 * 
 * S = {a, b, c} then P(s) = {{}, {a}, {b}, {c}, {a,b}, {a, c}, {b, c}, {a, b,
 * c}}.
 *
 */
public class PowerSet {

	public static void main(String[] args) {
		char[] s = { 'a', 'b', 'c' ,'c' };
		int len = s.length;
		printSets(s, len);
	}

	private static void printSets(char[] s, int len) {

		int totalSets = (int) Math.pow(2, len);

		for (int i = 0; i < totalSets; i++) {
			String binaryString = String.format("%3s", Integer.toBinaryString(i)).replace(' ', '0');

			for (int j = 0; j < binaryString.length(); j++) {
				if (binaryString.charAt(j) == '1')
					Common.print(s[j]);
			}
			Common.println();
		}
	}
}
