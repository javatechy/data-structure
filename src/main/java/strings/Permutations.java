package strings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import utils.Common;

public class Permutations {

	static List<String> list = new ArrayList<>();

	public static void main(String args[]) {
		String str = "ABCD";
		// permute(str, 0, str.length() - 1);
		permute2(str);
	}


	private static void permute2(String str) {
		if (str == null || str.length() == 0)
			return;

		String sub = str.charAt(0) + "";
		String char2 = str.charAt(1) + "";

		Queue<String> queue1 = new LinkedList<>();
		queue1.add(sub + char2);
		queue1.add(char2 + sub);

		Queue<String> queue2 = new LinkedList<>();
		for (int i = 2; i < str.length(); i++) {
			String toAdd = "" + str.charAt(i);
			while (!queue1.isEmpty()) {
				String ele = queue1.remove();
				for (int j = 0; j <= ele.length(); j++) {
					queue2.add(addToThisPostion(ele, j, toAdd));
				}
			}
			queue1 = queue2;
			queue2 = new LinkedList<>();
		}

		Common.println("SIZE  : " + queue1.size());
		// while (!queue1.isEmpty()) {
		// Common.print(queue1.remove() + " , ");
		// }
	}

	private static String addToThisPostion(String ele, int j, String toAdd) {
		String string = ele.substring(0, j) + toAdd + ele.substring(j, ele.length());
		return string;
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
