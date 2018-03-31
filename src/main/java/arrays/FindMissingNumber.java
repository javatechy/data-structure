package arrays;

/**
 * https://www.geeksforgeeks.org/array-rotation/
 * 
 * @author deepak
 *
 */
public class FindMissingNumber {

	// Driver program to test above functions
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12 };
		int n = 12;
		int sum = (n * (n + 1)) / 2;
		for (int i = 0; i < arr.length; i++)
			sum -= arr[i];
		print(sum);
		printArray(arr);
	}

	/* utility function to print an array */
	static void print(Object onject) {
		System.out.println(onject);
	}

	/* utility function to print an array */
	static void printArray(int arr[]) {
		int i;
		System.out.println();
		for (i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
}
