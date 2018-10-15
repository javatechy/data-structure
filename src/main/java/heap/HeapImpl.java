package heap;

public class HeapImpl {

	private static double findXpowerY(int x, int y) {
		if (x == 1 && y > 0)
			return 1;

		if (x == 0 && y > 0)
			return 0;

		if (y == 0) {
			return 1.0;
		}
		if (y < 0) {
			// Negative power.
			if (x == 0) {
				throw new IllegalArgumentException("Raise 0 to the power of a -ve num");
			}
			return 1 / findXpowerY(x, -y);
		}
		int result = 1;

		while (y > 0) {
			if (y % 2 == 1)
				result = result * x;
			x = x * x;
			y = y / 2;
		}

		return result;
	}

}
