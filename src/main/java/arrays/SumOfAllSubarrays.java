package arrays;

public class SumOfAllSubarrays {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5 };
		int n = arr.length;
		System.out.println("Sum of SubArray : " + SubArraySum(arr, n));
	}

	public static long SubArraySum(int arr[], int n) {
		long result = 0;

		// computing sum of subarray using formula
		for (int i = 0; i < n; i++)
			result += (arr[i] * (i + 1) * (n - i));

		// return all subarray sum
		return result;
	}

}
