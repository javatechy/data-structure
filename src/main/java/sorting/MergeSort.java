package sorting;

/**
 *  Example:
*/
class MergeSort {

    public static void main(String[] argv) throws Exception {
        // int[] arr = new int[] { 10, 2, 20, 5, 18, 12 };
        int[] arr = new int[] { 5, 1, 8, 2, 4, 6, 10 };
        int[] sortedArray = splitAndMerge(arr, 0, arr.length - 1);
        printArray("Final Array =>", sortedArray);
    }

    private static int[] splitAndMerge(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            print("\n\n splitAndMerge(arr, " + left + ", " + mid + ")");
            splitAndMerge(arr, left, mid);
            print("\n--------------------calling post mid");
            print("\n\n splitAndMerge(arr, " + (mid + 1) + ", " + right + ")");

            splitAndMerge(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
        return arr;
    }

    private static int[] merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int leftArr[] = new int[n1];
        int rightArr[] = new int[n2];
        for (int i = 0; i < n1; i++)
            leftArr[i] = arr[left + i];

        for (int j = 0; j < n2; ++j)
            rightArr[j] = arr[mid + 1 + j];

        // print("\n\nleft =>" + left + " || mid => " + mid + " || right => " + right);
        printArray("\narray L", leftArr);
        printArray("\narray R", rightArr);

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
        return arr;
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
