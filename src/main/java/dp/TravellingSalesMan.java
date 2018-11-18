package dp;

public class TravellingSalesMan {

	public static void main(String args[]) {
		//@// @formatter:off
				int arr[][] = {//  0  1    2    3   4   5
					/** 0 **/	{ 0, 10,  75,  94, 67, 40 }, 
					/** 1 **/	{ -1, 0,  35,  50, 90, 44 }, 
					/** 2 **/	{ -1, -1,  0,  80, 80, 23 }, 
					/** 3 **/	{ -1, -1, -1,  0 , 88, 12 }, 
					/** 4 **/	{ -1, -1, -1, -1 ,  0, 12 }, 
					/** 5 **/	{ -1, -1, -1, -1 , -1,  0 }, 
							};
				
		// @formatter:on

				
	}

	private static int travellingNaive(int[][] arr, int s, int d) {
		if (s == d)
			return 0;
		if (s == d - 1) {
			return arr[s][d];
		}
		int min = arr[s][d];
		for (int i = s + 1; i < d; i++) {

			int dist = travellingNaive(arr, s, i) + travellingNaive(arr, i, d);
			if (dist < min)
				min = dist;
		}
		return min;
	}

}