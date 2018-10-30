package strings;

import utils.Common;

/**
 * from CTCI
 * 
 * @author deepak
 *
 */
public class IsUnique {

	// Driver Program
	public static void main(String[] args) {
		String txt = "ABCD";

		boolean set[] = new boolean[128];

		Common.println(findUnique(txt, set));

	}

	private static boolean findUnique(String txt, boolean[] set) {
		if (txt == null || txt.isEmpty() || txt.length() > 127)
			return false;

		for (int i = 0; i < txt.length(); i++) {
			int character = txt.charAt(i);
			if (set[character]) {
				return false;
			}
			set[character] = true;
		}
		return true;
	}

}