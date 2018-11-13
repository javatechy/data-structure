package strings;

import utils.Common;

public class FirstUniqueString {

	// Driver Program
	public static void main(String[] args) {
		String ch = "geeksforgeeks";
		Common.println();
		char c = firstUniqueCharacter(ch);
		Common.println(c);
	}

	private static char firstUniqueCharacter(String ch) {
		int[] chars = new int[127];
		ch.chars().forEach(t -> chars[t]++);
		Common.printArray(chars);

		for (int i = 0; i < ch.length(); i++) {
			if (chars[ch.charAt(i)] == 1)
				return ch.charAt(i);
		}
		return '-';
	}

}