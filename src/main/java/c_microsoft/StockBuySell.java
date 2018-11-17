package c_microsoft;

import utils.Common;

public class StockBuySell {

	public static void main(String a[]) {

		int arr[] = { 100, 180, 260, 310, 40, 535, 695 };

		int i = 0;
		boolean foundMin = false;
		boolean foundMax = false;
		int minIndex = -1;
		int maxIndex = -1;
		while (i < arr.length - 1) {

			if (!foundMin && arr[i] < arr[i + 1]) {
				minIndex = i;
				foundMin = true;

			}

			if (foundMin && arr[i] > arr[i + 1]) {
				maxIndex = i;
				foundMax = true;
			}
			if (i + 1 == arr.length - 1) {
				maxIndex = i+1;
				foundMax = true;
			}

			if (foundMin && foundMax) {
				Common.println(arr[minIndex] + " : " + arr[maxIndex]);
				foundMin = false;
				foundMax = false;
			}
			i++;
		}
		
	}

}
