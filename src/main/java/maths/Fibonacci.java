package maths;

import java.util.stream.IntStream;

public class Fibonacci {

    public static void main(String a[]) {
        int n = 20;
        print("SUM -> " + fibonacciRecursion(n));
        IntStream.range(1, n)
            .forEach(n1 -> print(fibonacciRecursion(n1)));
        print("WITHOUT RECURTSION - Print  "+n +" finbonacci Numbers");

        fibonacciPlain(n);
    }

    private static void fibonacciPlain(int n) {
        print("1, 1");
        int prev1 = 1;
        int prev2 = 1;
        int sum = 1;
        for (int k = 2; k < n; k++) {
            sum = prev1 + prev2;
            System.out.print("," + sum);
            prev1 = prev2;
            prev2 = sum;

        }

    }

    static int fibonacciRecursion(int n) {
        if (n <= 1)
            return n;
        return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
    }

    static void print(Object obj) {
        System.out.println(obj);
    }

}
