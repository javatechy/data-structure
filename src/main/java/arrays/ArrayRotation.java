package arrays;

import java.util.stream.IntStream;

import utils.Common;

/**
 * https://www.geeksforgeeks.org/array-rotation/
 * @author deepak
 *
 */
public class ArrayRotation {

    // Driver program to test above functions
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };

        int d = 4;
        
        // methodByO_dxN(arr, d);
        methodByJuggling(arr, d);
        printArray(arr, arr.length);
    }

    private static void methodByJuggling(int[] arr, int d) {
        int i, j, k, temp;
        int n = arr.length;
        int gcd = gcd(d, n);
        Common.print(gcd);
        for (i = 0; i < gcd; i++) {
            temp = arr[i];
            j = i;
            while (true) {
                k = j + d;
                if (k >= n) {
                    k = k - n;
                }
                if (k == i)
                    break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
            printArray(arr, arr.length);
        }
    }

    /*Fuction to get gcd of a and b*/
    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    @SuppressWarnings("unused")
    private static void methodByO_dxN(int[] arr, int d) {
        IntStream.range(0, d)
            .forEach(t -> {
                leftRotate(arr, 7);
            });
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
        System.out.println();
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
    }
}
