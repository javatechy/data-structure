package arrays;

/**
 * Print 2d array in spiral form
 */
class SpiralArray {

	public static void main(String[] argv) {
		int arr[][] = { { 1, 2, 3, 4 }, { 2, 4, 5, 8 }, { 12, 4, 11, 5 }, { 12, 13, 14, 15 } };
		int LEFT = 0;
		int RIGHT = 3;// c-1
		int TOP = 0;
		int BOTTOM = 3;// r-1
		int dir = 0;

		while (LEFT < RIGHT && TOP < BOTTOM) {
			if (dir == 0) {
				for (int i = LEFT; i <= RIGHT; i++) {
					print(arr[TOP][i]);
				}
			}
			dir++;
			TOP++;
			if (dir == 1) {
				for (int i = TOP; i <= RIGHT; i++) {
					print(arr[i][RIGHT]);
				}
			}
			dir++;
			RIGHT--;
			if (dir == 2) {
				for (int i = RIGHT; i >= LEFT; i--) {
					print(arr[BOTTOM][i]);
				}
			}

			dir++;
			BOTTOM--;
			if (dir == 3) {
				for (int i = BOTTOM; i >= TOP; i--) {
					print(arr[i][LEFT]);
				}
			}
			LEFT++;
			dir = 0;
		}
		// printArray("Final Array =>", arr);
	}

	public static void print(Object o) {
		System.out.println(o);
	}

	public static void print() {
		System.out.println();
	}

}
