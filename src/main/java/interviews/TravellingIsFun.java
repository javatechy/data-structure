package interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.Common;

/**
 * Swiggy
 */
public class TravellingIsFun {

	public static void main(String args[]) {

		int origin[] = { 1, 2, 3 };
		int dest[] = { 4, 5, 6 };

		int[] result = new TravellingIsFun().connectedCities(6, 1, new int[] { 1, 2, 4, 6 }, new int[] { 3, 3, 3, 4 });

		Common.printArray(result);
	}

	static int[] connectedCities(int num, int g, int[] originCities, int[] destinationCities) {

		int[] result = new int[destinationCities.length];
		for (int i = 0; i < originCities.length; i++) {
			result[i] = 0;
			int origin = originCities[i];
			int dest = destinationCities[i];
			if (origin == dest) {
				result[i] = 1;
				continue;
			}
			if (origin <= g || dest <= g) {
				continue;
			}
			int m = origin;
			int n = dest;

			for (int j = g + 1; j < origin; ++j) {
				if (origin % j == 0) {
					m = j;
					break;
				}
			}
			for (int j = g + 1; j < dest; ++j) {
				if (dest % j == 0) {
					n = j;
					break;
				}
			}
			if (m * n <= num) {
				result[i] = 1;
			}
		}
		return result;
	}

}