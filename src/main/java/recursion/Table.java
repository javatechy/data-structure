package recursion;

import utils.Common;

public class Table {

	public static void main(String args[]) {
		int n = 9;
		printTable(n, 1);
		new Table().fun();

	}

	private static void printTable(int n, int i) {
		if (i == 11)
			return;
		Common.println(n * i);
		printTable(n, i + 1);
	}

	static int b = 10;

	private void fun() {
		int a = 5;
		a = b;
		Common.print("valu of a " + a);

	}

}