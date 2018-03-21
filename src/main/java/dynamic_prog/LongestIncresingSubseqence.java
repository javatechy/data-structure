package dynamic_prog;

/**
 * https://www.geeksforgeeks.org/array-rotation/
 * @author deepak
 *
 */
public class LongestIncresingSubseqence {

    // Driver program to test above functions
    public static void main(String[] args) {
        print("Longest sequence " + longestIncreasingSubsequence(new int[] { 3, 10, 2, 1, 20 }));
        print("Longest sequence " + longestIncreasingSubsequence(new int[] { 50, 3, 10, 7, 40, 80 }));
        print("Longest sequence " + longestIncreasingSubsequence(new int[] { 10, 22, 9, 33, 21, 50, 41, 60, 80 }));

    }

    private static int longestIncreasingSubsequence(int[] arr) {
        int tempArray[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            tempArray[i] = 1;
        printArray(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    int temp = tempArray[j] + 1;
                    if (temp > tempArray[i])
                        tempArray[i] = temp;
                }
            }
            printArray(tempArray);
        }
        int max = tempArray[0];
        for (int i = 1; i < arr.length; i++) {
            if (tempArray[i] > max)
                max = tempArray[i];
        }
        return max;
    }

    /* utility function to print  */
    static void print(Object obj) {
        System.out.println(obj);
    }

    /* utility function to print an array */
    static void printArray(int arr[]) {
        int i;
        System.out.println();
        for (i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
