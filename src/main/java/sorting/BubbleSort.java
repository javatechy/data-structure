package sorting;

/**
 *  Example:
First Pass:
( 5 1 4 2 8 ) –> ( 1 5 4 2 8 ), Here, algorithm compares the first two elements, and swaps since 5 > 1.
( 1 5 4 2 8 ) –>  ( 1 4 5 2 8 ), Swap since 5 > 4
( 1 4 5 2 8 ) –>  ( 1 4 2 5 8 ), Swap since 5 > 2
( 1 4 2 5 8 ) –> ( 1 4 2 5 8 ), Now, since these elements are already in order (8 > 5), algorithm does not swap them.

Second Pass:
( 1 4 2 5 8 ) –> ( 1 4 2 5 8 )
( 1 4 2 5 8 ) –> ( 1 2 4 5 8 ), Swap since 4 > 2
( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
( 1 2 4 5 8 ) –>  ( 1 2 4 5 8 )
 and so on
  
  O(n^2) time even if the array is sorted. It can be optimized by stopping the algorithm if inner loop didn’t cause any swap.
  
*/
class BubbleSort {

    public static void main(String[] argv) throws Exception {
        // int[] arr = new int[] { 10, 2, 20, 5, 18, 12 };
        int[] arr = new int[] { 5, 1, 8, 2, 4 };
        int[] sortedArray = bubbleSort(arr);
        printArray(sortedArray);
    }

    private static void printArray(int[] sortedArray) {
        for (int i = 0; i < sortedArray.length; i++) {
            print(sortedArray[i]);
        }
    }

    private static int[] bubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            print("\nFor Array  i  = " + i + "\n");
            printArray(arr);

        }
        return arr;
    }

    public static void print(Object o) {
        System.out.print(o);
    }
}