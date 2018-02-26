package geeksforgeeks;

/**
Largest Sum Contiguous Subarray
Write an efficient C program to find the sum of contiguous subarray 
within a one-dimensional array of numbers which has the largest sum.

//Kadane's Algo
*/
class LargestSumContiguousSubarray {

    public static void main(String[] argv) throws Exception {
        int[] arr = new int[] {-2,-3,-1,-5,-1,-2,-1,-5,-3};
        int maxSoFar = 0; 
		int maxEndingHere = 0 ;
		int startIndex = 0 ;
		int endIndex = 0; 
		for(int i =0 ; i<arr.length;i++){
			maxEndingHere = maxEndingHere + arr[i];
			if(maxEndingHere<0) {
				maxEndingHere = 0;
			}
			if(maxSoFar< maxEndingHere){
				maxSoFar = maxEndingHere;
			}
		}
        print("\nMax So Far"+ maxSoFar + "\nMax Ending "+ maxEndingHere);
    }

    public static void print(Object o) {
        System.out.println(o);
    }
}