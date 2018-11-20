package c_microsoft;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import utils.Common;

/**
 * https://www.geeksforgeeks.org/find-a-tour-that-visits-all-stations/
 */
public class PetrolPumpTour {

	public static void main(String[] args) {
		int petrol[] = { 4, 6, 7, 4 };
		int distance[] = { 6, 5, 3, 5 };

		int startPoint = circulatPetrolPump(petrol, distance);

		Common.println(startPoint);
	}

	private static int circulatPetrolPump(int[] petrol, int[] distance) {
		int stations = petrol.length;

		int petrolSum = Arrays.stream(petrol).sum();
		int distSum = Arrays.stream(distance).sum();

		if (distSum > petrolSum)
			return -1;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);

		int start = 0;
		int distan_petrol = 0;

		boolean isPassedOnce = false;
		while (!queue.isEmpty()) {
			int currentStation = queue.remove();

			if (start == currentStation && isPassedOnce)
				break;

			distan_petrol = distan_petrol + (petrol[currentStation] - distance[currentStation]);
			System.out.println(" currentStation: " + currentStation + " petrol[] " + petrol[currentStation] + "   "
					+ " distance[] : " + distance[currentStation] + "  distan_petrol:  " + distan_petrol);

			// distan_petrol = distan_petrol - distance[currentStation];
			isPassedOnce = true;
			int nextStation = getNextStation(currentStation, stations);
			if (distan_petrol < 0) {
				start = nextStation;
				distan_petrol = 0;
				isPassedOnce = false;
				queue.add(start);
			} else {
				queue.add(nextStation);
			}

		}
		return petrol[start];
	}

	static int getNextStation(int currentStation, int stations) {
		return (currentStation + 1) % stations;
	}

}
