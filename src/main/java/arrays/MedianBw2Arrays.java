package arrays;

import utils.Common;

public class MedianBw2Arrays {

	public static void main(String args[]) {
		double median = new MedianBw2Arrays().findMedianSortedArrays(new int[] {1,2},
				new int[] { 3,4});
		Common.println("Median : " + median);
	}

	public double findMedianSortedArrays(int[] num1, int[] num2) {

		if (num1 == null || num2 == null) {
			return -1;
		}

		int len1 = num1.length;
		int len2 = num2.length;
		if (len1 == 0)
			return findMedian(num2);

		if (len2 == 0)
			return findMedian(num1);

		int i = 0, j = 0, k = 0;

		int merge[] = new int[len1 + len2];

		Common.println("Len1 : " + len1);
		Common.println("Len2 : " + len2);

		Common.printArray(merge);
		Common.printArray(num1);
		Common.printArray(num2);
		while (i < len1 && j < len2) {
			// Common.println("Compairing " + num1[i] + " and " + num2[i]);
			Common.println("i : " + i + " j =" + j + " k=" + k);
			if (num1[i] < num2[j]) {
				merge[k] = num1[i];
				i++;
			} else {
				merge[k] = num2[j];
				j++;
			}
			k++;
		}
		Common.println("i : " + i + " j =" + j + " k=" + k);

		if (j < len2 && i == len1) {
			for (int m = j; m < len2; m++) {
				merge[k] = num2[m];
				j++;
				k++;
			}

		}

		if (i < len1 && j == len2) {
			for (int m = i; m < len1; m++) {
				merge[k] = num1[m];
				i++;
				k++;
			}
		}
		Common.printArray(merge);
		return findMedian(merge);

	}

	private double findMedian(int[] arr) {
		if (arr.length == 0)
			return -1;
		int n = arr.length;

		// even
		int mid = n / 2;

		if (n%2 == 0) {
			return (double)(arr[mid - 1] + arr[mid]) / 2;
		} else {
			return arr[mid];
		}
	}

}
