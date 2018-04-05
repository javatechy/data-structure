package strings;

import java.util.Arrays;

import static utils.Common.*;

public class ContainsString {

	// Driver Program
	public static void main(String[] args) {
		findContains("eeepa", "deepak");
		findEquals("edeakp", "deepak");
	}

	private static void findEquals(String str, String main) {
		int[] arr = new int[26];
		Arrays.fill(arr, 0);
		for (char c : main.toCharArray()) {
			arr[c - 'a']++;
		}
		printArray(arr);

		boolean result = true;
		for (char c : str.toCharArray()) {
			if (arr[c - 'a'] >= 1) {
				arr[c - 'a']--;
			} else {
				result = false;
			}
		}
		print(result);
	}

	// Take an array of length 26
	//
	private static void findContains(String str, String main) {
		int[] arr = new int[26];
		Arrays.fill(arr, 0);
		for (char c : main.toCharArray()) {
			arr[c - 'a']++;
		}
		printArray(arr);
		int[] arr2 = new int[26];
		Arrays.fill(arr2, 0);
		for (char c : str.toCharArray()) {
			arr2[c - 'a']++;
		}
		boolean res = true;
		for (int i = 0; i < arr.length; i++) {
			if (arr2[i] == 0) {
				continue;
			}
			if (arr2[i] == arr[i]) {
				res = true;
			} else {
				res = false;
			}
		}
		printArray(arr2);
		print(res);
	}
}