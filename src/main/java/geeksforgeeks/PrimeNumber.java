package geeksforgeeks;

/**
 * Prime Number
*/
class PrimeNumber {

    public static void main(String[] argv) throws Exception {

        int checkPrime = 170;
        print(isPrime(checkPrime));
        print(toBinary(170));
    }

    private static String toBinary(int binary) {
        String str = "";
        while (binary != 0) {
            str += binary % 2;
            binary = binary / 2;
        }
        return new StringBuilder(str).reverse()
            .toString();
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void print(Object o) {
        System.out.println(o);
    }
}