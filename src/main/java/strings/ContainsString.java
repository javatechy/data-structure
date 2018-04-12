package strings;

import static utils.Common.printArray;
import static utils.Common.println;

public class ContainsString {

	// Driver Program
	public static void main(String[] args) {
		String txt = "ABABDABACDABABCABAB";
		String pat = "ABABCABAB"; // ABABCABAB
		ContainsString containsString = new ContainsString();
		containsString.KMPSearch(pat, txt);
		// containsString.computeLPSArray2(pat);
	}

	void KMPSearch(String pat, String txt) {
		int patLen = pat.length();
		int txtLen = txt.length();

		// create lps[] that will hold the longest
		// prefix suffix values for pattern
		int lps[] = new int[patLen];
		int j = 0; // index for pat[]

		// Preprocess the pattern (calculate lps[]
		// array)
		// computeLPSArray2(pat, patLen, lps);
		lps = computeLPSArray(pat);
		printArray(lps);
		int i = 0; // index for txt[]
		while (i < txtLen) {
			if (pat.charAt(j) == txt.charAt(i)) {
				j++;
				i++;
			}
			if (j == patLen) {
				System.out.println("Found pattern " + "at index " + (i - j));
				j = lps[j - 1];
			}

			// mismatch after j matches
			else if (i < txtLen && pat.charAt(j) != txt.charAt(i)) {
				// Do not match lps[0..lps[j-1]] characters,
				// they will match anyway
				if (j != 0)
					j = lps[j - 1];
				else
					i = i + 1;
			}
		}
	}

	void computeLPSArray2(String pat, int patLen, int lps[]) {
		// length of the previous longest prefix suffix
		int j = 0;
		int i = 1;
		lps[0] = 0; // lps[0] is always 0

		// the loop calculates lps[i] for i = 1 to M-1
		while (i < patLen) {
			if (pat.charAt(i) == pat.charAt(j)) {
				j++;
				lps[i] = j;
				i++;
			} else // (pat[i] != pat[len])
			{
				// This is tricky. Consider the example.
				// AAACAAAA and i = 7. The idea is similar
				// to search step.
				if (j != 0) {
					j = lps[j - 1];

					// Also, note that we do not increment
					// i here
				} else // if (len == 0)
				{
					lps[i] = j;
					i++;
				}
			}
		}
	}

	int[] computeLPSArray(String pat) {

		int patLen = pat.length();
		char[] patArray = pat.toCharArray();

		int[] lps = new int[patLen];
		int j = 0;
		int i = 1;

		while (i < patLen) {
			println("i : " + i + " j => " + j + "");
			println("comparting i : " + patArray[i] + " j => " + patArray[j] + "");
			if (patArray[j] == patArray[i]) {
				j++;
				lps[i] = j;
				i++;
			} else {
				println("j ius now " + j);
				if (j != 0)
					j = lps[j - 1];
				else {
					lps[i] = j;
					i++;

				}
			}
			printArray(lps);
		}

		printArray(lps);
		return lps;
	}
}