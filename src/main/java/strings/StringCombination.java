package strings;

import utils.Common;

public class StringCombination {

	public static void main(String args[]) {

		int[] arr = { 1, 2, 2, 1 };

		findPosbilites(arr);

	}

	private static void findPosbilites(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {

			Integer nextNum = arr[i + 1];
			int newNumber = arr[i] * 10 + nextNum;
			if (newNumber > 26 || arr[i] == -1)
				continue;
			int newArr[] = makeNewCopy(arr, (i + 1), arr.length - 1);
			newArr[i] = newNumber;
			Common.printArray(newArr);
			findPosbilites(newArr);
		}

	}

	private static int[] makeNewCopy(int[] arr, int elementToRemove, int newArrayLen) {

		int[] newArr = new int[newArrayLen];
		int i = 0;
		for (; i < elementToRemove; i++) {
			newArr[i] = arr[i];
		}
		for (int j = elementToRemove + 1; j < arr.length; j++) {
			newArr[i] = arr[j];
			i++;
		}
		return newArr;
	}

}
