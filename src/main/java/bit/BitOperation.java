package bit;

import utils.Common;

public class BitOperation {

	public static void main(String[] args) {

		Common.println("Right  Shifting(Divided by 2)");

		Common.println(3 >> 1);

		Common.println(8 >> 1);

		Common.println(8 >> 2);

		Common.println(8 >> 3);

		Common.println("Left  Shifting(Multiplied by 2)");

		Common.println(3 << 1);

		Common.println(8 << 1);

		Common.println(1 << 1);

		Common.println("& Operation (Multiplied by 2)");

		Common.println(3 & 1);

		Common.println(5 & 1);

		Common.println(4 & 1);

	}

}
