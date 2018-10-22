package arrays;

/**
 * https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 * 
 * @author deepak
 *
 */
public class KadaneAlgorith {

	// Driver program to test above functions
	public static void main(String[] args) {

		int ar[] = new int[] { -2, -1 };

		int sum = new KadaneAlgorith().maxContigeousSum(ar);
		System.out.println("Max sume: " + sum);
	}

	int maxContigeousSum(int arr[]) {
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i : arr) {
			sum += i;
			max = Math.max(max, sum);
			if (sum < 0) {
				sum = 0;
			}
		}
		return max;
	}

	/**
	 * Cases TOCHECK : {-1} {-2,-1}
	 * 
	 * @param arr
	 * @return
	 */
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

}
