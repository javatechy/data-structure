package c_microsoft;

import utils.Common;

public class EvalBooleanExp {

	public static void main(String[] args) {

		String str = "1A0B1";

		char[] arr = str.toCharArray();

		for (int i = 2; i < arr.length; i += 2) {

			char a = arr[i - 2];
			char b = arr[i];
			char operator = arr[i - 1];

			switch (operator) {
			case 'A':
				arr[i] = (char) (a & b);
				break;
			case 'B':
				arr[i] = (char) (a | b);
				break;
			case 'C':
				arr[i] = (char) (a ^ b);
				break;
			}
		}

		Common.println(arr[arr.length - 1]);
	}

}
