package algorithms;

import utils.Common;

/**
 * 
 * Rabin-Karp Algorithm for Pattern Searching
 * 
 * Input: txt[] = "THIS IS A TEST TEXT" pat[] = "TEST" Output: Pattern found at
 * index 10
 * 
 * Input: txt[] = "AABAACAADAABAABA" pat[] = "AABA"
 * 
 * @author deepak
 *
 */
public class RabinKarpAlgorithm {

	// d is the number of characters in the input alphabet
	public final static int NO_OF_CHARS = 256;

	public static void main(String[] args) {

		String str = "geeksforgeeks";
		String pattern = "for";
		Common.println(naive(str, pattern));

		// For hashing
		int prime = 101; // A prime number
		search(str, pattern, prime);

	}

	/**
	 * Time Complexity: O((n – m + 1) × m) ≈O(n × m).
	 * 
	 * Space Complexity: O(1).
	 */
	static int naive(String str, String pattern) {

		int slen = str.length();
		int plen = pattern.length();

		for (int i = 0; i <= slen - plen; i++) {
			int j = 0;
			int m = i;
			while (j < plen && pattern.charAt(j) == str.charAt(m)) {
				m++;
				j++;
			}
			if (j == plen) {
				return i;
			}
		}

		return -1;
	}

	static void search(String txt, String pat, int q) {
		int patLen = pat.length();
		int txtLen = txt.length();
		int i, j;
		int pat_hash = 0; // hash value for pattern
		int txt_hash = 0; // hash value for txt
		int hashValue = 1;

		// The value of h would be "pow(d, M-1)%q"
		for (i = 0; i < patLen - 1; i++)
			hashValue = (hashValue * NO_OF_CHARS) % q;

		// Calculate the hash value of pattern and first
		// window of text
		for (i = 0; i < patLen; i++) {
			pat_hash = (NO_OF_CHARS * pat_hash + pat.charAt(i)) % q;
			txt_hash = (NO_OF_CHARS * txt_hash + txt.charAt(i)) % q;
		}

		// Slide the pattern over text one by one
		for (i = 0; i <= (txtLen - patLen); i++) {
			// Check the hash values of current window of text
			// and pattern. If the hash values match then only
			// check for characters on by one
			if (pat_hash == txt_hash) {
				/* Check for characters one by one */
				for (j = 0; j < patLen; j++) {
					if (txt.charAt(i + j) != pat.charAt(j))
						break;
				}

				// if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1]
				if (j == patLen)
					System.out.println("Pattern found at index " + i);
			}

			// Calculate hash value for next window of text: Remove
			// leading digit, add trailing digit
			if (i < txtLen - patLen) {
				txt_hash = (NO_OF_CHARS * (txt_hash - txt.charAt(i) * hashValue) + txt.charAt(i + patLen)) % q;
				// We might get negative value of t, converting it
				// to positive
				if (txt_hash < 0)
					txt_hash = (txt_hash + q);
			}
		}
	}
}
