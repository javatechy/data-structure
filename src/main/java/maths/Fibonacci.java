package maths;

public class Fibonacci {
    static int[] lookup;

    public static void main(String a[]) {
        int n = 50;
        lookup = new int[n + 1];
        long startTime = System.currentTimeMillis();
        int fibonacciRecursionSum = fibonacciRecursion(n);
        long endTime = System.currentTimeMillis();
        print("SUM -> " + fibonacciRecursionSum + " in " + (endTime - startTime));
        startTime = System.currentTimeMillis();
        fibonacciRecursionSum = fibonacciDynamicProgramming(n);
        endTime = System.currentTimeMillis();
        print("SUM(DP) -> " + fibonacciRecursionSum + " in " + (endTime - startTime));
        //IntStream.range(1, n)
        //    .forEach(n1 -> print(fibonacciRecursion(n1)));
        print("WITHOUT RECURTSION - Print  " + n + " finbonacci Numbers");
        // fibonacciPlain(n);
        
    }

    private static int fibonacciDynamicProgramming(int n) {
        print("\n n= " + n);
        if (n <= 1)
            return n;
        if (lookup[n] != 0)
            return n;
        return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
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
