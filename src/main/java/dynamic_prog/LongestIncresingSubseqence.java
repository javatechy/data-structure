package dynamic_prog;

import static utils.Common.*;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/array-rotation/
 * 
 * @author deepak
 *
 */
public class LongestIncresingSubseqence {

	private static final String SEPEARTOR = "   ";

	// Driver program to test above functions
	public static void main(String[] args) {
		println("\nLongest sequence " + longestIncreasingSubsequence(new int[] { 3, 10, 2, 1, 20 }));
		println("\nLongest sequence " + longestIncreasingSubsequence(new int[] { 50, 3, 10, 7, 40, 80 }));
		println("\nLongest sequence " + longestIncreasingSubsequence(new int[] { 10, 22, 9, 33, 21, 50, 41, 60, 80 }));

	}

	private static int longestIncreasingSubsequence(int[] arr) {
		int tempArray[] = new int[arr.length];
		Arrays.fill(tempArray, 1);
		printArray(arr, "  ");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					int temp = tempArray[j] + 1;
					if (temp > tempArray[i]) {
						tempArray[i] = temp;
						// print(arr[j] + " , "); // To print the whole sequence
					}
				}
			}
			printArray(tempArray, SEPEARTOR);
		}
		// print sequenct
		int max = tempArray[0];
		print(arr[0] + ", ");
		for (int i = 1; i < arr.length; i++) {
			if (tempArray[i] > max) {
				max = tempArray[i];
				print(arr[i] + " , ");
			}
		}
		return max;
	}

}
