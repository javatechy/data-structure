package strings;

//sub-strings of a given string 
import java.util.Map;
import java.util.TreeMap;

/**
 * https://www.geeksforgeeks.org/find-number-distinct-palindromic-sub-strings-given-string/
 * 
 * @author deepak
 *
 */
public class SubStringPallindrome {
	static void palindromeSubStrs(String str) {

		TreeMap<String, Integer> palMap = new TreeMap<>();
		int n = str.length();

		int[][] R = new int[2][n + 1];

		str = "@" + str + "#";

		for (int j = 0; j <= 1; j++) {
			int rp = 0;
			R[j][0] = 0;

			int i = 1;
			while (i <= n) {
				while (str.charAt(i - rp - 1) == str.charAt(i + j + rp))
					rp++;
				R[j][i] = rp;
				int k = 1;
				while ((R[j][i - k] != rp - k) && (k < rp)) {
					R[j][i + k] = Math.min(R[j][i - k], rp - k);
					k++;
				}
				rp = Math.max(rp - k, 0);
				i += k;
			}
		}

		str = str.substring(1, str.length() - 1);

		palMap.put(str.substring(0, 1), 1);
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= 1; j++)
				for (int rp = R[j][i]; rp > 0; rp--)
					palMap.put(str.substring(i - rp - 1, i - rp - 1 + 2 * rp + j), 1);
			palMap.put(str.substring(i, i + 1), 1);
		}

		for (Map.Entry<String, Integer> entry : palMap.entrySet())
			System.out.println(entry.getKey());
	}

	// Driver program
	public static void main(String args[]) {
		palindromeSubStrs("abaaa");
	}
}
// This co