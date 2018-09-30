package arrays;

import utils.Common;

// Java implementation of left rotation of 
//an array K number of times 
class CountRotations {
	// Fills temp[] with two copies of arr[]
	static void preprocess(int arr[], int n, int temp[]) {
		// Store arr[] elements at i and i + n
		for (int i = 0; i < n; i++)
			temp[i] = temp[i + n] = arr[i];
	}

	// Function to left rotate an array k time
	static void leftRotate(int arr[], int n, int k, int temp[]) {
		// Starting position of array after k
		// rotations in temp[] will be k % n
		int start = k % n;

		Common.println("k%n : " + start );
		// Print array after k rotations
		for (int i = start; i < start + n; i++)
			System.out.print(temp[i] + " ");

		System.out.print("\n");
	}

	// Driver program
	public static void main(String[] args) {
		int arr[] = { 1, 3, 5, 7, 9 };
		int n = arr.length;

		int temp[] = new int[2 * n];
		preprocess(arr, n, temp);

		int k = 2;
		leftRotate(arr, n, k, temp);

		k = 3;
		leftRotate(arr, n, k, temp);

		k = 14;
		leftRotate(arr, n, k, temp);
	}
}
