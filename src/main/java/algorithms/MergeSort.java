package algorithms;

import java.util.Arrays;

import utils.Common;

public class MergeSort {

	// Driver program to test above functions
	public static void main(String[] args) {
		int[] arr = new int[] { 38, 27, 43, 3, 9, 82, 10 };
		mergeSort(arr, 0, arr.length - 1);
		Common.printArray(arr);
	}

	private static void mergeSort(int[] arr, int startIndex, int endIndex) {
		if (startIndex == endIndex)
			return;
		int mid = (startIndex + endIndex) / 2;
		mergeSort(arr, startIndex, mid);
		mergeSort(arr, mid + 1, endIndex);
		merge(arr, startIndex, mid, endIndex);
	}

	private static void merge(int[] arr, int startIndex, int mid, int endIndex) {
		int n1 = mid - startIndex + 1;
		int n2 = endIndex - mid;
		int arr1[] = Arrays.copyOfRange(arr, startIndex, mid + 1);
		int arr2[] = Arrays.copyOfRange(arr, mid + 1, endIndex + 1);
		Common.println("Working on  n1 =" + n1 + " n2 = " + n2);
		Common.printArray(arr1);
		Common.printArray(arr2);
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

	}
}