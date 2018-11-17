package c_microsoft;

import java.util.HashMap;
import java.util.Map;

public class LongestUniqueSubstring {

	public static void main(String[] args) {

		String str = "GEEKSFORGEEKS";
		System.out.println("The input string is " + str);
		int len = longestUniqueSubsttr(str);
		System.out.println("The length of " + "the longest non repeating character is " + len);
	}

	private static int longestUniqueSubsttr(String str) {
		Map<Character, Boolean> map = new HashMap<>();
		int maxLen = 0;
		int tmp = 0;
		for (int i = 0; i < str.length(); i++) {
			if (map.get(str.charAt(i)) != null) {
				map.clear();
				tmp = 0;
			} else {
				map.put(str.charAt(i), true);
				tmp++;
			}

			if (maxLen < tmp)
				maxLen = tmp;
		}
		return maxLen;

	}

}
