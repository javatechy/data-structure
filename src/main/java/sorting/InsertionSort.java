package sorting;

/**
  Time Complexity: O(n*n)
    Auxiliary Space: O(1)
*/
class InsertionSort {

    public static void main(String[] argv) throws Exception {
        // int[] arr = new int[] { 10, 2, 20, 5, 18, 12 };
        int[] arr = new int[] { 12, 11, 13, 5, 6 };
        int[] sortedArray = insertionSort(arr);
        printArray(sortedArray);
    }

    private static void printArray(int[] sortedArray) {
        for (int i = 0; i < sortedArray.length; i++) {
            print(sortedArray[i]);
        }
    }

    private static int[] insertionSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
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