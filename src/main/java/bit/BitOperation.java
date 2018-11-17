package bit;

import utils.Common;

public class BitOperation {

	public static void main(String[] args) {

		xorOperation();
		// Integer to binary form
		System.out.println(Integer.toBinaryString(12));

		// Integer to octal form
		System.out.println(Integer.toBinaryString(12));

		rightShift();

		leftShift();

		andOperation();

	}

	private static void xorOperation() {
		Common.println("XOR Operation (Multiplied by 2)");

		Common.println(9 ^ ~8);
		Common.println(7 ^ ~6);
		
	}

	private static void andOperation() {
		Common.println("& Operation (Multiplied by 2)");

		Common.println(3 & 1);

		Common.println(5 & 1);

		Common.println(4 & 1);
	}

	private static void leftShift() {
		Common.println("Left  Shifting(Multiplied by 2)");

		Common.println(3 << 1);

		Common.println(8 << 1);

		Common.println(1 << 1);
	}

	private static void rightShift() {
		Common.println("Right  Shifting(Divided by 2)");

		Common.println(3 >> 1);

		Common.println(8 >> 1);

		Common.println(8 >> 2);

		Common.println(8 >> 3);
	}

}
