package arrays;

import java.util.stream.IntStream;

import utils.Common;

/**
 * https://www.geeksforgeeks.org/array-rotation/
 * 
 * @author deepak
 *
 */

public class ArrayRotation {

	// Driver program to test above functions
	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };

		int d = 4;

		// methodByO_dxN(arr, d);
		rotate(arr, d);
		// rotate(arr, d);
		Common.printArray(arr);
	}

	/**
	 * Attempt 2 on 19 OCT 2018
	 **/
	private static void rotate(int[] arr, int d) {
		int len = arr.length;
		int gcd = gcd(len, d);

		int j, k = 0;

		for (int i = 0; i < d; i++) {
			j = i;
			int temp = arr[i];
			while (true) {
				k = j + d;
				if (k >= len) {
					break;
				}
				arr[j] = arr[k];
				j = k;
			}

			arr[j] = temp;
			Common.printArray(arr);
		}

		Common.print(d);
	}

	private static void methodByJuggling(int[] arr, int no_of_pos) {
		int i, j, k, temp;
		int n = arr.length;
		int gcd = gcd(no_of_pos, n);
		Common.print(gcd);
		for (i = 0; i < gcd; i++) {
			temp = arr[i];
			j = i;
			while (true) {
				k = j + no_of_pos;
				if (k >= n) {
					k = k - n;
				}
				if (k == i)
					break;
				arr[j] = arr[k];
				j = k;
			}
			arr[j] = temp;
		}
	}

	/* Fuction to get gcd of a and b */
	static int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

	@SuppressWarnings("unused")
	private static void methodByO_dxN(int[] arr, int d) {
		IntStream.range(0, d).forEach(t -> {
			leftRotate(arr, 7);
		});
	}

	static void leftRotate(int arr[], int n) {
		int i, temp;
		temp = arr[0];
		for (i = 0; i < n - 1; i++)
			arr[i] = arr[i + 1];
		arr[i] = temp;
	}
}
