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

	public static int[] strToIntArray(String str) {
		int[] arr = new int[str.length()];
		int i = 0;
		for (char c : str.toCharArray()) {
			arr[i] = Integer.parseInt(c + "");
			i++;
		}
		return arr;
	}

	public static void println(Object x) {
		System.out.println(x + "\n");
	}

	/**
	 * Print 2D array with speperator
	 */
	public static void printArray(int[] arr) {
		printArray(arr, " , ");
	}

	/**
	 * Print 1D array
	 */
	public static void printArray(int[] arr, String sepeartor) {
		/// println();
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1)
				System.out.print(arr[i]);
			else
				System.out.print(arr[i] + sepeartor);
		}
		println();
	}

	/**
	 * Print 2D array
	 */
	public static void printArray(int[][] arr) {
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++)
				System.out.print(arr[i][j] + " ");
			println();
		}
	}

	public static void print2DArray(String string, int[][] arr) {
		System.out.print(string + " => \n");
		print2DArray(arr, " ");
	}

	public static void print2DArray(int[][] arr, String seperator) {
		println();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++)
				System.out.print(arr[i][j] + seperator);
			System.out.println();
		}
	}
	
	public static void print2DArray(boolean[][] arr, String seperator) {
		println();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++)
				System.out.print(arr[i][j] + seperator);
			System.out.println();
		}
	}

	/**
	 * Arrays to List
	 */
	public static <T> List<T> arrayToList(T[] array) {
		return new ArrayList<>(Arrays.asList(array));

	}

	public static int max(int... arr) {
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max)
				max = arr[i];
		}
		return max;
	}

	public static int min(int... arr) {
		int min = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min)
				min = arr[i];
		}
		return min;
	}

	public static void intialize2DMatrix(int[][] mat, int value) {
		for (int i = 0; i < mat.length; i++)
			Arrays.fill(mat[i], value);
	}
}
