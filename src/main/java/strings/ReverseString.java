package strings;

import java.util.Stack;

import utils.Common;

public class ReverseString {

	// Driver Program
	public static void main(String[] args) {
		String ch = "ab^c";
		Common.println();
		reverseRecursion(ch);
		Common.println();
		reverseStack(ch);
		Common.println();
		reverseWithoutChangingSpecialCharacters(ch);
	}

	private static void reverseRecursion(String ch) {
		if (ch.length() == 0)
			return;
		System.out.print(ch.charAt(ch.length() - 1));
		reverseRecursion(ch.substring(0, ch.length() - 1));
	}

	private static void reverseWithoutChangingSpecialCharacters(String str) {
		int left = 0;
		int right = str.length() - 1;
		char[] strArr = str.toCharArray();
		while (left != right) {
			if (Character.isLetter(strArr[left]) && Character.isLetter(strArr[right])) {
				char c = strArr[left];
				strArr[left] = strArr[right];
				strArr[right] = c;
				left++;
				right--;
			}
			if (!Character.isLetter((strArr[left]))) {
				left++;
			}
			if (!Character.isLetter((strArr[right]))) {
				right--;
			}
		}
		Common.println(String.copyValueOf(strArr));

	}

	private static void reverseStack(String ch) {
		Stack<Character> stack = new Stack<>();

		for (Character c : ch.toCharArray())
			stack.push(c);

		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}

	}
}