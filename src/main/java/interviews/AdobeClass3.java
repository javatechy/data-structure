package interviews;

import java.util.Scanner;

/**
Largest Sum Contiguous Subarray
Pair Sum
*/
class AdobeClass3 {

    public static void main(String[] argv) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int input[] = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }
        int sum = sc.nextInt();
        /*int input[] = { 11, 18, 21, 28, 31, 38, 40, 55, 60, 62 };
        int n = input.length;
        int sum = 66;
        
        */
        print("treult => " + subArraySum(input, n, sum));
    }

    public static void print(Object o) {
        System.out.print(o);
    }

    static boolean subArraySum(int arr[], int a, int sum) {
        int l, r;
        sort(arr, 0, a - 1);
        l = 0;
        r = a - 1;
        while (l < r) {
            if (arr[l] + arr[r] == sum)
                return true;
            else if (arr[l] + arr[r] < sum)
                l++;
            else
                r--;
        }
        return false;
    }

    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    static void sort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

}