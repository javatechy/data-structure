package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import utils.Common;

/**
 * Given a string, write a function to check if it is a permutation of a
 * palindrome. A palindrome is a word or phrase that is the same forwards and
 * backwards. A permutation is a rearrangement of letters. The palindrome does
 * not need to be limited to just dictionary words.
 * 
 * EXAMPLE Input: Tact Coa
 * 
 * Output: True (permutations: "taco cat'; "atco eta·; etc.)
 * 
 * @author deepak
 *
 */
public class PalindromePermutation {

	public static void main(String args[]) {

		String first = "ab";

		boolean res = usingHashTable(first);

		Common.println(res);
	}

	private static boolean usingHashTable(String first) {

		if (first == null || first.length() == 0)
			return false;

		Map<Character, Integer> hashTable = new HashMap<>();

		for (int i = 0; i < first.length(); i++) {
			int value = Optional.ofNullable(hashTable.get(first.charAt(i))).isPresent() ? hashTable.get(first.charAt(i))
					: 0;
			hashTable.put(first.charAt(i), ++value);
		}

		hashTable.keySet().forEach(k -> Common.println(k + " : " + hashTable.get(k)));
		boolean isOddOccuredOnce = false;

		for (Entry<Character, Integer> character : hashTable.entrySet()) {

			if (character.getValue() == 1 && !isOddOccuredOnce && first.length() % 2 == 1) {
				isOddOccuredOnce = true;
				continue;
			}

			if (character.getValue() % 2 == 1) {
				return false;
			}

		}
		return true;
	}
}
