package interviews;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.Common;

/**
 * Swiggy
 */
public class MostFrequestSubstring {

	public static void main(String args[]) {

		String str = "ababab";
		Common.println(subStrings(str, 2, 3, 4));
	}

	public static int subStrings(String str, int min, int max, int unique) {
		int n = str.length();
		List<String> subs = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				String substring = str.substring(i, j);
				subs.add(substring);
			}
		}

		List<String> newSubs = new ArrayList<>();
		for (String substring : subs) {
			if (substring.length() >= min && substring.length() <= max && getUnique(substring) <= unique
					&& getUnique(substring) >= 2) {
				newSubs.add(substring);
			}
		}

		int freq = 0;
		for (String substring : newSubs) {
			int newFrq = Collections.frequency(newSubs, substring);
			if (newFrq > freq)
				freq = newFrq;
		}
		return freq;
	}

	private static int getUnique(String substring) {
		String lowerCase = substring.toLowerCase();
		char characters[] = lowerCase.toCharArray();
		int countOfUniqueChars = substring.length();
		for (int i = 0; i < characters.length; i++) {
			if (i != lowerCase.indexOf(characters[i])) {
				countOfUniqueChars--;
			}
		}
		return countOfUniqueChars;
	}

}