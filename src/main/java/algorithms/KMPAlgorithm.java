package algorithms;

/**
 * https://www.geeksforgeeks.org/array-rotation/
 * 
 * @author deepak
 *
 */
public class KMPAlgorithm {

	// Driver program to test above functions
	public static void main(String[] args) {

		String str = "ACABAACAADAABAABA";
		String match = "ABABABAB";

		int index = new KMPAlgorithm().knuthMorrisPratt(str, match);

		System.out.println("FOund at index : " + index);
	}

	int knuthMorrisPratt(String text, String pattern) {
		if (text == null || pattern == null || text.length() < pattern.length()) {
			return -1;
		}
		if (pattern.length() == 0) {
			return 0;
		}
		int[] lcp = computeLongestCommonPrefixArray(pattern);
		printArray(lcp, lcp.length);
		int i = 0, j = 0;
		while (i < text.length() && j != pattern.length()) {
			if (text.charAt(i) == pattern.charAt(j)) {
				j++;
			} else {
				if (j > 0) {
					j = lcp[j - 1];
					continue;
				}
			}
			i++;
		}
		return (i - j) <= (text.length() - pattern.length()) ? (i - j) : -1;
	}

	int[] computeLongestCommonPrefixArray(String pattern) {
		int[] lcp = new int[pattern.length()];
		int len = 0, i = 1;
		while (i < pattern.length()) {
			if (pattern.charAt(i) == pattern.charAt(len)) {
				len++;
				lcp[i] = len;
				i++;
			} else {
				if (len != 0) {
					len = lcp[len - 1];
				} else {
					lcp[i] = 0;
					i++;
				}
			}
		}
		return lcp;
	}

	/* utility function to print an array */
	static void printArray(int arr[], int size) {
		int i;
		System.out.println();
		for (i = 0; i < size; i++)
			System.out.print(arr[i] + " ");
	}
}
