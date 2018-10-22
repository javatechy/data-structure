package interviews;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

/**
 * We are only interested in the substrings that follow the following properties
 * - The length of a substring lies between K and L - The number of unique
 * characters in the substring do not exceed M
 * 
 * Constraints 2 <= N <= 100000 2 <= K <= L <= 26, L < N 2 <= M <= 26
 * 
 * Input The first line contains an integer N. The second line contains three
 * space separated integers, K L M. The third line contains the string of length
 * N.
 * 
 * Sample Input #00 5 2 4 26 abcde
 * 
 * Sample Output #00 1
 * 
 * Explanation #00 All substring of length 2, 3 or 4 in abcde have only one
 * occurrence. And number of character in substring is clearly less than 26
 * hence answer is 1
 * 
 * Sample Input #01 6 2 3 4 ababab
 * 
 * Sample Output #01 3
 * 
 * Explanation #02 Size 2 we have 'ab': count is 3, 'ba' count is 2 Size 3 we
 * have 'aba': count is 2, 'bab' count is 2 Clearly most often substring is 'ab'
 * and hence answer is 3
 *
 */
public class ConstrainedSubstring {

	public static void main(String[] args) {

		String str = "abcde";

		int K = 2;
		int L = 4;
		int M = 26;

		String string = str;

		int count = getMaxOccurrences(string, K, L, M);
		System.out.println(count);
	}

	public static int getMaxOccurrences(String str, int min, int max, int unique) {
		int length = str.length();
		Map<String, Integer> substrCount = new HashMap<String, Integer>();

		for (int c = 0; c < length; c++) {
			for (int i = 2; i <= length - c; i++) {
				String sub = str.substring(c, c + i);
				if (sub.length() < min || sub.length() > max) {
					continue;
				}
				int distinct = countDistinct(sub);
				if (distinct < 2 || distinct > unique) {
					continue;
				}
				if (substrCount.containsKey(sub)) {
					substrCount.put(sub, substrCount.get(sub) + 1);
				} else {
					substrCount.put(sub, 1);
				}
			}
		}

		Set<String> count = rank(substrCount);
		return Integer.valueOf(count.iterator().next().substring(0, 6));
	}

	private static int countDistinct(String sub) {
		int distinct = 0;
		Set<Character> chars = new HashSet<Character>();
		for (Character character : sub.toLowerCase().toCharArray()) {
			if (chars.add(character)) {
				distinct++;
			}
		}
		return distinct;
	}

	private static Set<String> rank(Map<String, Integer> substrCount) {
		Set<String> count = new TreeSet<String>(new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
		for (Entry<String, Integer> entry : substrCount.entrySet()) {
			int zeroes = 6 - String.valueOf(entry.getValue()).length();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < zeroes; i++) {
				sb.append("0");
			}
			sb.append(entry.getValue());
			count.add(sb.toString() + entry.getKey());
		}
		return count;
	}
}