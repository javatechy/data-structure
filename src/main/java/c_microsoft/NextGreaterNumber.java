package c_microsoft;

import java.util.Arrays;

import utils.Common;

public class NextGreaterNumber {

	public static void main(String args[]) {
		int[] num = { 2, 1, 8, 7, 6, 5 };
		findNextHight(num);
	}

	private static void findNextHight(int[] ar) {
		int i;

		int n = ar.length;
		// I) Start from the right most digit
		// and find the first digit that is smaller
		// than the digit next to it.
		for (i = n - 1; i > 0; i--) {
			if (ar[i] > ar[i - 1]) {
				break;
			}
		}

		Common.println("Not possible" + i + " and  " + ar[i]);
		// If no such digit is found, then all
		// digits are in descending order means
		// there cannot be a greater number with
		// same set of digits
		if (i == 0) {
			Common.println("Not possible");
		} else {
			
			int x = ar[i - 1], min = i;
			Common.println(" X" + x);

			// II) Find the smallest digit on right
			// side of (i-1)'th digit that is greater
			// than number[i-1]
			for (int j = i + 1; j < n; j++) {
				if (ar[j] > x && ar[j] < ar[min]) {
					min = j;
				}
			}

			// III) Swap the above found smallest
			// digit with number[i-1]
			Common.printArray(ar);
			Common.swap(ar, i - 1, min);

			// IV) Sort the digits after (i-1)
			// in ascending order
			Common.printArray(ar);
			Arrays.sort(ar, i, n);
			Common.printArray(ar);
			Common.print("Next number with same" + " set of digits is ");
			for (i = 0; i < n; i++)
				Common.print(ar[i]);
		}
	}
}
