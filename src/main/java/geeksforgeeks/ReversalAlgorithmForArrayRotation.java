
//package geeksforgeeks;

import java.util.stream.*;
import java.util.*;

/**
Reversal algorithm for array rotation
Write a function rotate(arr[], d, n) that rotates arr[] of size n by d elements.

Example:

Input:  arr[] = [1, 2, 3, 4, 5, 6, 7]
            d = 2
Output: arr[] = [3, 4, 5, 6, 7, 1, 2] 
*/
class ReversalAlgorithmForArrayRotation {

    public static void main(String[] argv) throws Exception {
        int[] arr = new int[] { 1, 2, 3, 4, 5, 6 };
        print("HELLO");
        int d = 2;
        int length = arr.length;

        for (int dTemp = 0; dTemp < d; dTemp++) {
            int last = length - dTemp - 1;
            int temp = arr[dTemp];
            arr[dTemp] = arr[last];
            arr[last] = temp;
            print("temp " + dTemp + "---> " + last + "\n");
	        IntStream.range(0, length)
	            .forEach(i -> print("\n"+ i + " =>"+ arr[i]));
	        System.out.println();
			
        }

        IntStream.range(0, length)
            .forEach(i -> print(arr[i]));
        System.out.println();

        // print(count);
    }

    public static void print(Object o) {
        System.out.print(o);
    }
}