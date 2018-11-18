package c_microsoft;

import java.util.PriorityQueue;

import utils.Common;

public class RunningMedian {

	public static void main(String[] args) {
		int[] arr = { 5, 15, 1, 3 };
		getMedian(arr);

	}

	public static double[] getMedian(int[] arr) {
		// Max Heap
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
		// Min Head
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		double[] medians = new double[arr.length];

		for (int i = 0; i < arr.length; i++) {
			int number = arr[i];
			addNumber(number, maxHeap, minHeap);
			rebalance(maxHeap, minHeap);
			medians[i] = getMedian(maxHeap, minHeap);
			Common.println(medians[i]);
		}
		return medians;

	}

	private static void addNumber(int number, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {

		if (maxHeap.isEmpty() || number < maxHeap.peek()) {
			maxHeap.add(number);
		} else {
			minHeap.add(number);
		}
	}

	private static void rebalance(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
		PriorityQueue<Integer> bigHeap = maxHeap.size() > minHeap.size() ? maxHeap : minHeap;
		PriorityQueue<Integer> smallHeap = minHeap.size() < maxHeap.size() ? minHeap : maxHeap;

		if (bigHeap.size() - smallHeap.size() >= 2) {
			smallHeap.add(bigHeap.poll());
		}

	}

	private static double getMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
		PriorityQueue<Integer> bigHeap = maxHeap.size() > minHeap.size() ? maxHeap : minHeap;
		PriorityQueue<Integer> smallHeap = minHeap.size() < maxHeap.size() ? minHeap : maxHeap;
		if (bigHeap.size() == smallHeap.size()) {
			// average
			return ((double) bigHeap.peek() + smallHeap.peek()) / 2;
		} else {
			return bigHeap.peek();
		}
	}

}
