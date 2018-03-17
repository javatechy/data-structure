package sorting;

/**
 *  Example:
  
*/
class MergeSort {

    public static void main(String[] argv) throws Exception {
        // int[] arr = new int[] { 10, 2, 20, 5, 18, 12 };
        int[] arr = new int[] { 5, 1, 8, 2, 4 };
        int[] sortedArray = mergeSort(arr);
        printArray(sortedArray);
    }

    private static void printArray(int[] sortedArray) {
        for (int i = 0; i < sortedArray.length; i++) {
            print(sortedArray[i]);
        }
    }

    private static int[] mergeSort(int[] arr) {
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