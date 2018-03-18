package generla;

/**
 *  Print 2d array in spiral form
*/
class QuickSort {

    public static void main(String[] argv) throws Exception {
        int arr[][] = { { 1, 2, 3, 4 }, { 2, 4, 5, 8 }, { 12, 4, 11, 5 }, { 12, 13, 14, 15 } };
        int LEFT = 0;
        int RIGHT = 3;
        int TOP = 0;
        int BOTTOM = 3;

        printArray("Final Array =>", arr);
    }

    public static void print(Object o) {
        System.out.print(o);
    }

    public static void print() {
        System.out.println();
    }

    private static void printArray(String string, int[][] arr) {
        System.out.print(string + " => ");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                print(arr[i][j]);

            }
            print();
        }
    }
}
