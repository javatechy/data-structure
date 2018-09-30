package algorithms;

/**
 * https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 * 
 * @author deepak
 *
 */
public class KadaneAlgorith {

	// Driver program to test above functions
	public static void main(String[] args) {

		int ar[] = new int[] { -2, -3, 4, -1, -2, 1, 5, -3 };

		int sum = new KadaneAlgorith().kadane(ar);
		System.out.println("Max sume: " + sum);
	}

	int kadane(int arr[]) {
		int max = 0;
		int inter_max = 0;

		for (int i = 0; i < arr.length; i++) {
			inter_max = inter_max + arr[i];
			if (inter_max < 0)
				inter_max = 0;
			if (inter_max > max) {
				max = inter_max;
			}
		}

		return max;

	}

	/* utility function to print an array */
	static void printArray(int arr[], int size) {
		int i;
		System.out.println();
		for (i = 0; i < size; i++)
			System.out.print(arr[i] + " ");
	}
}
