package general;

import java.util.stream.*;
import java.util.*;

/**
Smallest element repeated exactly ‘k’ times (not limited to small range)
Given an array of size n, the goal is to find out the smallest number that is repeated exactly ‘k’ times where k > 0?
And

Examples:

Input : a[] = {2, 1, 3, 1, 2, 2}
        k = 3
Output : 2

Input : a[] = {3\, 1, 5, 5} 
        k = 2
Output : 3
Explanation: As 3 is smaller than 5. 
So 3 should be printed.
*/
class SmallestElementRepeatedKTimes {

    public static void main(String[] argv) throws Exception {
        int[] arr = new int[] { 2, 1, 3, 1, 2, 2 };
        print("HELLO");
        Map<Integer, Integer> map = new TreeMap<>();
        IntStream.range(0, arr.length)
            .forEach(t -> {
                int count = 0;
                if (map.get(arr[t]) == null)
                    count = 1;
                else
                    count = map.get(arr[t]) + 1;
                map.put(arr[t], count);
            });
        map.forEach((k, v) -> print("Key : " + k + "AND value" + v));

        print("ANS => " + map.values()
            .stream()
            .filter(t -> (t == 2))
            .findFirst()
            .get());
        // print(count);
    }

    public static void print(Object o) {
        System.out.println(o);
    }
}