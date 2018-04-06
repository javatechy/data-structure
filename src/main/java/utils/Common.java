package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Common {

	/**
	 * New Line
	 */
	public static void println() {
		System.out.println();
	}

	public static void print(Object x) {
		System.out.print(x);
	}

	public static void println(Object x) {
		System.out.println(x + "\n");
	}

	/**
	 * Print 1D array
	 */
	public static void printArray(int[] arr) {
		/// println();
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1)
				System.out.print(arr[i]);
			else
				System.out.print(arr[i] + " , ");
		}
		println();
	}

	/**
	 * Print 2D array
	 */
	public static void printArray(int[][] arr) {
		System.out.print(" ");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++)
				System.out.print(arr[i][j] + " ");
			println();
		}
	}

	/**
	 * Arrays to List
	 */
	public static <T> List<T> arrayToList(T[] array) {
		return new ArrayList<>(Arrays.asList(array));

	}
}
