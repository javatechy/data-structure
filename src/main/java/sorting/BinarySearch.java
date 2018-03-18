package sorting;

/**
 *  array is sorted and therefor time complexity is O(Log n).
*/
class BinarySearch {

    public static void main(String[] argv) throws Exception {
        int[] arr = new int[] { 2, 3, 5, 8, 10, 12, 12, 12, 21, 22, 24 };
        int itemToBeSearched = 12;
        print(binarySearch(arr, itemToBeSearched));
        print("LAST OCCURENCE =>" + binarySearchLastOccurence(arr, itemToBeSearched));
        print("FIRST OCCURENCE => " + binarySearchFirstOccurence(arr, itemToBeSearched));
    }

    private static int binarySearchFirstOccurence(int[] arr, int itemToBeSearched) {
        int start = 0;
        int end = arr.length - 1;
        int result = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == itemToBeSearched) {
                result = mid;
                end = mid - 1;
            } else if (arr[mid] < itemToBeSearched) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }

    private static int binarySearchLastOccurence(int[] arr, int itemToBeSearched) {
        int start = 0;
        int end = arr.length - 1;
        int result = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == itemToBeSearched) {
                result = mid;
                start = mid + 1;
            } else if (arr[mid] > itemToBeSearched) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    private static boolean binarySearch(int[] arr, int itemToBeSearched) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == itemToBeSearched) {
                print("found at " + mid);
                return true;
            } else if (arr[mid] < itemToBeSearched) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        print("NOT found ");
        return false;
    }

    public static void print(Object o) {
        System.out.println(o);
    }
}