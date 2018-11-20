package strings;

import java.util.ArrayList;
import java.util.List;

import utils.Common;

public class BinaryPermutation {

	static List<String> list = new ArrayList<>();

	public static void main(String args[]) {
		// allPer("", 3);
		int count = allPerWithoutConsective("", 3);
		Common.println("Count : " + count);
	}

	// all perms with 0 and 1 of length n
	static void allPer(String str, int n) {
		if (str.length() > n) {
			return;
		}
		if (str.length() == n) {
			Common.println(str);
			return;
		}
		allPer(str + "0", n);
		allPer(str + "1", n);
	}

	static int allPerWithoutConsective(String str, int n) {
		int length = str.length();
		if (length > n) {
			return 0;
		}
		if (length >= 2 && str.charAt(length - 1) == '1' && str.charAt(length - 2) == '1') {
			// Common.println("ni1 " + str.charAt(length - 1) + " | " + str.charAt(length -
			// 2));
			return 0;
		}
		if (str.length() == n) {
			Common.println(str);
			return 1;
		}
		return allPerWithoutConsective(str + "0", n) + allPerWithoutConsective(str + "1", n);
	}

}
