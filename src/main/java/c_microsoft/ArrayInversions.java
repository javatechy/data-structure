package c_microsoft;

import java.util.Arrays;

import utils.Common;

/**
 * Count Inversions in an array | Set 1 (Using Merge Sort)
 * 
 * https://www.geeksforgeeks.org/counting-inversions/
 *
 */
public class ArrayInversions {

	public static void main(String[] args) {

		int arr[] = { 2, 4, 1, 3, 5, 0 };

		Common.println(inverstionNaive(arr));

		Common.println(" Inversions : " + inverstionMerge(arr, 0, arr.length - 1));
		Common.printArray(arr);
	}

	/**
	 * O(n2) Complexity
	 */
	public static int inverstionNaive(int[] arr) {

		int len = arr.length;

		int inversionCount = 0;
		for (int i = 0; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) {
				if (arr[i] > arr[j])
					inversionCount++;
			}

		}
		return inversionCount;

	}

	/**
	 * O(nlogn) Using Merge Sort
	 */
	public static int inverstionMerge(int[] arr, int start, int end) {

		int count_inversion = 0;
		if (end > start) {
			int mid = (start + end) / 2;
			count_inversion += inverstionMerge(arr, start, mid);
			count_inversion += inverstionMerge(arr, mid + 1, end);
			count_inversion += merge(arr, start, mid, end);
		}
		return count_inversion;
	}

	/**
	 * O(nlogn)
	 */
	private static int merge(int[] arr, int startIndex, int mid, int endIndex) {
		int inConv = 0;
		int n1 = mid - startIndex + 1;
		int n2 = endIndex - mid;
		int arr1[] = Arrays.copyOfRange(arr, startIndex, mid + 1);
		int arr2[] = Arrays.copyOfRange(arr, mid + 1, endIndex + 1);
		// Common.println("Working on n1 =" + n1 + " n2 = " + n2);
		// Common.printArray(arr1);
		// Common.printArray(arr2);
		int i = 0;
		int j = 0;
		int k = startIndex;

		while (i < n1 && j < n2) {
			// Common.println("i = " + i + " j = " + j + " k = " + k);

			if (arr1[i] <= arr2[j]) {
				arr[k] = arr1[i];
				i++;
				k++;
			} else {
				inConv = inConv + (mid - startIndex);
				arr[k] = arr2[j];
				j++;
				k++;
			}
			Common.printArray(arr);
		}

		while (i < n1) {
			arr[k] = arr1[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = arr2[j];
			j++;
			k++;
		}

		return inConv;
	}

}
