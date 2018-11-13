package c_microsoft;

import utils.Common;

public class BinaryRepersentation {

	public static void main(String[] args) {

		bitwise(4);

		Common.println("Right  Shifting");

		Common.println(3 >> 1);

		Common.println(8 >> 1);

		Common.println("Left  Shifting");

		Common.println(3 << 1);

		Common.println(8 << 1);

	}

	private static void binary(int num) {
		Common.println(num);
		if (num == 0)
			return;

		binary(num / 2);
		Common.print(num % 2);
	}

	private static void bitwise(int num) {
		Common.println(num);
		if (num == 0)
			return;

		binary(num >> 1);
		Common.print(num & 1); // for odd number =1 and even =1
	}

}
