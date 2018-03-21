package dynamic_prog;

/**
 * https://www.geeksforgeeks.org/array-rotation/
 * @author deepak
 *
 */
public class LongestCommonSubseqence {

    // Driver program to test above functions
    public static void main(String[] args) {
        print("Longest common sequence " + longestIncreasingSubsequence("ABCD".toCharArray(), "ABCF".toCharArray()));
    }

    private static int longestIncreasingSubsequence(char[] firstArr, char[] secondArr) {
        int flen = firstArr.length;
        int slen = secondArr.length;
        int row = slen + 1;
        int col = flen + 1;
        int mat[][] = new int[row][col];
        intializeMatrix(row, col, mat);
        printArray("========", mat);
        for (int r = 0; r <= row; r++) {
            for (int c = 0; c <= col; c++) {
                print("r=>" + r + " | c => " + c);
                if (r == 0 || c == 0) {
                    mat[r][c] = 0;
                } else if (secondArr[r - 1] == firstArr[c - 1]) {
                    mat[r][c] = mat[r - 1][c - 1] + 1;
                } else {
                    int max = findMax(mat[r - 1][c], mat[r][c - 1]);
                    print("max => " + max + " secondArr[r - 1]" + secondArr[r - 1] + " firstArr[c - 1] =>" + firstArr[c - 1]);
                    mat[r][c] = max;
                }
                printArray("========", mat);
            }
        }

        return 0;
    }

    private static int findMax(int i, int j) {
        if (i > j)
            return i;
        return j;
    }

    private static void intializeMatrix(int flen, int slen, int[][] mat) {
        for (int i = 0; i < flen; i++) {
            for (int j = 0; j < slen; j++) {
                mat[i][j] = 0;
            }
        }
    }

    /* utility function to print  */
    static void print(Object obj) {
        System.out.println(obj);
    }

    /* utility function to print an array */
    static void printArray(int arr[]) {
        int i;
        System.out.println();
        for (i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    private static void printArray(String string, int[][] arr) {
        System.out.print(string + " => \n");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }
}
