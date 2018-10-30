package strings;

import utils.Common;

/**
 * from CTCI
 * 
 * There are three types of edits that can be performed on strings: insert a
 * character, remove a character, or replace a character. Given two strings,
 * write a function to check if they are one edit (or zero edits) away.
 * 
 * EXAMPLE
 * 
 * pale, ple -> true
 * 
 * pales, pale -> true
 * 
 * pale, bale -> true
 * 
 * pale, bae -> false
 *
 */
public class OneAway {

	public static void main(String[] args) {
		// 1
		Common.println(replaceSpaces("pale", "ale"));
		Common.println(replaceSpaces("ale", "pale"));
		Common.println(replaceSpaces("pale", "bae"));

		// 2
		Common.println(editString("pale", "ale"));
		Common.println(editString("ale", "pale"));
		Common.println(editString("pale", "bae"));

	}

	private static boolean editString(String first, String second) {
		if (Math.abs(first.length() - second.length()) > 1) {
			return false;
		}
		/* Get shorter and longer string. */
		String sl = first.length() < second.length() ? first : second;
		String s2 = first.length() < second.length() ? second : first;

		int indexl = 0;
		int index2 = 0;
		boolean foundDifference = false;
		while (index2 < s2.length() && indexl < sl.length()) {
			if (sl.charAt(indexl) != s2.charAt(index2)) {
				/* Ensure that this is the first difference found. */
				if (foundDifference)
					return false;
				foundDifference = true;

				if (sl.length() == s2.length()) {// On replace, move shorter pointer
					indexl++;
				}
			} else {
				indexl++; // If matching, move shorter pointer
			}
			index2++; // Always move pointer for longer string
		}
		return true;
	}

	private static boolean replaceSpaces(String first, String second) {
		if (first.length() == second.length()) {
			return replace(first, second);
		} else if (first.length() + 1 == second.length()) {
			return addCharacter(second, first);
		} else if (first.length() == second.length() + 1) {
			return addCharacter(first, second);
		}
		return false;
	}

	private static boolean addCharacter(String first, String second) {
		boolean replaced = false;
		int flen = 0;
		int secLen = second.length();
		for (int i = 0; i < secLen; i++, flen++) {
			if (second.charAt(i) != first.charAt(flen) && !replaced) {
				flen++;
				replaced = true;
				continue;
			}

			if (second.charAt(i) != first.charAt(flen) && replaced) {
				return false;
			}
		}

		return true;
	}

	private static boolean replace(String first, String second) {
		boolean replaced = false;
		int firstLen = first.length();
		for (int i = 0; i < firstLen; i++) {
			if (first.charAt(i) != second.charAt(i) && !replaced) {
				replaced = true;
				continue;
			}

			if (first.charAt(i) != second.charAt(i) && replaced) {
				return false;
			}
		}
		return true;
	}

}