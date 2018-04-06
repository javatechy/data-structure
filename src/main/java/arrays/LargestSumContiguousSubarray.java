package arrays;

/**
Largest Sum Contiguous Subarray
Write an efficient C program to find the sum of contiguous subarray 
within a one-dimensional array of numbers which has the largest sum.

//Kadane's Algo
*/
class LargestSumContiguousSubarray {

    public static void main(String[] argv) throws Exception {
        int[] arr = new int[] { -2, -3, -1, 5, 1, -2, -1, -5, -3 };
        int maxGlobal = 0;
        int maxCurrent = 0;
        for (int i = 0; i < arr.length; i++) {
            maxCurrent = max(maxGlobal, maxCurrent + arr[i]);
            if (maxCurrent < 0) {
                maxCurrent = 0;
            }
            if (maxGlobal < maxCurrent) {
                maxGlobal = maxCurrent;
            }
        }
        print("\nMax So Far" + maxGlobal + "\nMax Ending " + maxCurrent);
    }

    private static int max(int maxGlobal, int arraySum) {
        if (maxGlobal > arraySum) {
            return maxGlobal;
        }
        return arraySum;
    }

    public static void print(Object o) {
        System.out.println(o);
    }
}