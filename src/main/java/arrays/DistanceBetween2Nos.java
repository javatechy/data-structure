package arrays;

import utils.Common;

/**
 * https://www.geeksforgeeks.org/find-the-minimum-distance-between-two-numbers/
 * 
 * @author deepak
 *
 */
public class DistanceBetween2Nos {

	// Driver program to test above functions
	public static void main(String[] args) {

		Common.println(diff_betwen(new int[] { 1, 2 }, 1, 2));

		Common.println(diff_betwen(new int[] { 2, 5, 3, 5, 4, 4, 2, 3 }, 3, 2));

		Common.println(diff_betwen(new int[] { 3, 4, 5 }, 3, 5));

		Common.println(diff_betwen(new int[] { 3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3 }, 3, 6));
	}

	private static int diff_betwen(int[] arr, int x, int y) {
		int prev = 0;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == x || arr[i] == y) {
				prev = i; // y
				Common.println("First ELELMENT : " + prev);
				break;
			}
		}

		for (int i = prev; i < arr.length; i++) {
			if (arr[i] == x || arr[i] == y) {
				if (arr[prev] == arr[i]) { // y
					prev = i;
				} else {// x
					int dist = i - prev;
					if (dist < min)
						min = dist;
					prev = i;
				}
			}
		}
		Common.println("min distance" + min);
		return min;

	}
}
