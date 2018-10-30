package strings;

import utils.Common;

/**
 * from CTCI
 * 
 * URLify: Write a method to replace all spaces in a string with '%20'. You may
 * assume that the string has sufficient space at the end to hold the additional
 * characters, and that you are given the "true" length of the string. (Note: if
 * implementing in Java, please use a character array so that you can perform
 * this operation in place.)
 * 
 * EXAMPLE Input: "Mr John Smith ", 13 Output: "Mr%20John%20Smith"
 * 
 * @author deepak
 *
 */
public class Urlify {

	// Driver Program
	public static void main(String[] args) {
		String txt = "Mr John Smith ";

		Common.println(replaceSpaces(txt));

	}

	// If no spaces at the end exists
	private static String replaceSpaces(String txt) {

		int spaces = 0;

		for (int i = 0; i < txt.length(); i++) {
			if (txt.charAt(i) == ' ')
				spaces++;
		}

		int totalCount = txt.length() + spaces * 2;

		char newString[] = new char[totalCount];
		int newIndex = 0;
		for (int index = 0; index < txt.length(); index++, newIndex++) {
			if (txt.charAt(index) == ' ') {
				newString[newIndex] = '%';
				newString[newIndex + 1] = '2';
				newString[newIndex + 2] = '0';
				newIndex += 2;
				continue;
			}
			newString[newIndex] = txt.charAt(index);
		}

		return String.valueOf(newString);
	}


}