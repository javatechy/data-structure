package c_microsoft;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

import utils.Common;

/**
 * https://www.geeksforgeeks.org/print-all-jumping-numbers-smaller-than-or-equal-to-a-given-value/
 *
 */
public class JumpingNumbers {

	public static void main(String[] args) {
		int num = 105;

		int m = findLastDigit(198, 2);
		Common.println("-------------------------------------------" + m);

		jumping(num);
	}

	private static void jumping(int x) {
		Queue<Integer> queue = new LinkedList<>();
		Common.println(0);

		IntStream.rangeClosed(1, 9).forEach(queue::add);

		while (!queue.isEmpty()) {
			int num = queue.remove();
			println("--------------------------------------------");
			int digits = countNoOfDigits(num) - 1;
			println("digits: " + digits);

			if (num > x)
				break;
			Common.println(num);

			int lastDigit = findLastDigit(num, digits);

			if (lastDigit < 10) {
				// lastDigit = num;
				digits = 1;
			}
			println("lastDigit: " + lastDigit);
			int higher = higher(lastDigit);
			int low = low(lastDigit);

			println("higher: " + higher);
			println("low: " + low);

			int lowNum = num * (int) Math.pow(10, digits) + low;

			int highNum = num * (int) Math.pow(10, digits) + higher;

			if (low < 0) {
				queue.add(highNum);
				continue;
			}
			if (higher == -1) {
				queue.add(lowNum);
				continue;
			}
			queue.add(lowNum);
			println("Adding hig and low nums : " + highNum + " low: " + lowNum);
			queue.add(highNum);
		}

	}

	private static void println(String string) {
		// Common.println(string);

	}

	private static int findLastDigit(int num, int digits) {
		while (digits > 0) {
			num = num % 10;
			digits--;
		}
		return num;
	}

	private static int countNoOfDigits(int num) {
		int count = 0;
		while (num != 0) {
			num /= 10;
			count++;
		}
		return count;
	}

	private static int higher(int n) {
		if (n == 9) {
			return -1;
		}
		return n + 1;

	}

	private static int low(int n) {
		if (n == 0) {
			return -1;
		}
		return n - 1;
	}

}
