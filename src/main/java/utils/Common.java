package utils;

public class Common {

	public static void println() {
		println("");

	}

	public static void print(Object x) {
		System.out.print(x);
	}

	public static void println(Object x) {
		System.out.println(x + "\n");
	}

	public static void printArray(int[] arr) {
		println();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " , ");
		}
		println();
	}

}
