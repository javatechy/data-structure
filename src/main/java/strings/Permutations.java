package strings;

import utils.Common;

public class Permutations {

	public static void main(String args[]) {
		String str = "ABC";
		permute(str, 0, str.length() - 1);
	}

	private static void permute(String str, int l, int r) {
		Common.println("Permute Called for  " + str + " l : " + l + " & r : " + r);
		if (l == r)
			System.out.println(str);
		else {
			for (int i = l; i <= r; i++) {
				Common.println("           First swap  " + str + " l : " + l + " & i : " + i);
				str = swap(str, l, i);
				permute(str, l + 1, r);
				Common.println("           Second swap  " + str + " l : " + l + " & i : " + i);
				str = swap(str, l, i);
			}
		}
	}

	public static String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}
}
