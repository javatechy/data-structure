package c_microsoft;

import utils.Common;

/**
 * 
 * Check Babylonian theorem for exact sqrt
 * 
 * https://www.geeksforgeeks.org/program-to-add-two-binary-strings/
 *
 */
public class SumBinary {

	public static void main(String[] args) {

		int a[] = { 1, 1, 1, 1, 1, 1 };
		int b[] = { 1 };
		int alen = a.length - 1;
		int blen = b.length - 1;

		String str = "";
		int carry = 0;
		while (alen >= 0 || blen >= 0) {

			int first = 0;
			int sec = 0;
			if (alen >= 0)
				first = Integer.parseInt("" + a[alen]);
			if (blen >= 0)
				sec = Integer.parseInt("" + b[blen]);

			int sum = findSum(first, sec, carry);
			carry = findCarry(first, sec, carry);
			Common.println(" a: " + first + " |  b: " + sec + " |  carry: " + carry + " |  sum: " + sum);
			str += sum;
			alen--;
			blen--;
		}

		if (carry == 1)
			str += 1;
		Common.println(new StringBuffer(str).reverse().toString());
	}

	static int findCarry(int a, int b, int c) {
		return (a + b + c) / 2;
	}

	static int findSum(int a, int b, int c) {
		int sum = (a + b + c);

		switch (sum) {
		case 1:
			return sum;
		case 2:
			return 0;
		case 3:
			return 1;
		}
		return -1;
	}

}
