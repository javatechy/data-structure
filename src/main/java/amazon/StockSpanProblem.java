package amazon;

import java.util.Stack;

import utils.Common;

/**
 * https://www.geeksforgeeks.org/the-stock-span-problem/
 * 
 * @author deepak
 *
 */
public class StockSpanProblem {

	public static void main(String a[]) {

		int arr[] = { 10, 11, 100, 80, 60, 70, 60, 75, 85 };

		Common.printArray(calculateSpanNavieWay(arr));

		Common.printArray(calculateSpan(arr));

	}

	// O(n2)
	static int[] calculateSpanNavieWay(int[] arr) {
		int n = arr.length;
		int[] newArr = new int[n];
		for (int i = 0; i < n; i++) {
			int count = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] < arr[i])
					count++;
			}
			newArr[i] = count + 1;
		}
		return newArr;
	}

	static int[] calculateSpan(int price[]) {
		int n = price.length;
		int output[] = new int[n];
		Stack<Integer> stack = new Stack<>();
		stack.push(0);

		output[0] = 1;

		for (int i = 1; i < n; i++) {

			Common.println("Compairing: " + price[stack.peek()] + "&& " + price[i]);
			while (!stack.empty() && price[stack.peek()] <= price[i])
				stack.pop();

			if (stack.empty())
				output[i] = i + 1;
			else
				output[i] = i - stack.peek();

			stack.push(i);
		}

		return output;
	}

}
