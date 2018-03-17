package sorting;

/**
 *  Example:
*/
class QuickSort {

    public static void main(String[] argv) throws Exception {
        int[] arr = new int[] { 10, 2, 20, 5, 18, 12 };
        //int[] arr = new int[] { 5, 1, 8, 2, 4, 6, 10 };
        int[] sortedArray = quickSort(arr, 0, arr.length - 1);
        printArray("Final Array =>", sortedArray);
    }

    private static int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            print();
            int pivotIndex = partitionLogic(arr, left, right);
            print("\n pivotIndex " + pivotIndex);
            print("\n quickSort(arr, " + left + ", " + pivotIndex + ")");
            quickSort(arr, left, pivotIndex - 1);
            print("\n quickSort(arr, " + (pivotIndex + 1) + ", " + right + ")");
            quickSort(arr, pivotIndex + 1, right);
        }
        return arr;
    }

    private static int partitionLogic(int[] arr, int left, int right) {
        int pivot = arr[right];
        int pIndex = left;
        for (int i = left; i < right; i++) {
            if (arr[i] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[pIndex];
                arr[pIndex] = temp;
                pIndex++;
            }
        }
        arr[right] = arr[pIndex];
        arr[pIndex] = pivot;
        return pIndex;
    }

    public static void print(Object o) {
        System.out.print(o);
    }

    public static void print() {
        System.out.println();
    }

    private static void printArray(String string, int[] sortedArray) {
        System.out.print(string + " => ");
        for (int i = 0; i < sortedArray.length; i++) {
            print(sortedArray[i] + ",");
        }
    }
}
