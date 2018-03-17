package sorting;

/**
 *  array is sorted and therefor time complexity is O(Log n).
*/
class BinarySearch {

    public static void main(String[] argv) throws Exception {
        int[] arr = new int[] { 2, 3, 5, 8, 10, 12, 21, 22, 24 };
        int itemToBeSearched = 240;
        print(binarySearch(arr, itemToBeSearched));
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