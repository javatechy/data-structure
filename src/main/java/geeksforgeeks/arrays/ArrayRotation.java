package geeksforgeeks.arrays;

import java.util.stream.IntStream;

/**
 * https://www.geeksforgeeks.org/array-rotation/
 * @author deepak
 *
 */
public class ArrayRotation {

    // Driver program to test above functions
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };

        IntStream.range(0, 2)
            .forEach(t -> {
                leftRotate(arr, 7);
            });
        printArray(arr, 7);
    }

    static void leftRotate(int arr[], int n) {
        int i, temp;
        temp = arr[0];
        for (i = 0; i < n - 1; i++)
            arr[i] = arr[i + 1];
        arr[i] = temp;
    }

    /* utility function to print an array */
    static void printArray(int arr[], int size) {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
    }
}
