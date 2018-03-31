package arrays;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://www.geeksforgeeks.org/array-rotation/
 * 
 * @author deepak
 *
 */
public class SmallestGreaterElements {

	// Driver program to test above functions
	public static void main(String[] args) {
		int arr[] = { 11, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12 };
		findSmallestGreaterElements(arr);
		printArray(arr);
	}

	private static void findSmallestGreaterElements(int[] arr) {
		Set<Integer> aee = IntStream.of(arr).boxed().sorted().collect(Collectors.toSet());
		aee.stream().forEach(System.out::println);
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
