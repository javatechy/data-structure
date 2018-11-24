package c_microsoft;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import utils.Common;

/**
 * 
 * https://leetcode.com/accounts/login/?next=/problems/meeting-rooms-ii/
 *
 * [[0, 30],[5, 10],[15, 20]]
 * 
 * Ans : 2
 * 
 */
public class MettingRoom {
	public static void main(String arr[]) {

		Interval[] intervals = { Interval.build(0, 30), Interval.build(12, 60), Interval.build(5, 10),
				Interval.build(35, 45) };

		int rooms = minMeetingRooms(intervals);
		Common.println("rooms: " + rooms);

	}

	public static int minMeetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length == 0)
			return 0;

		Arrays.sort(intervals);

		Arrays.stream(intervals).forEach(System.out::println);

		PriorityQueue<Integer> queue = new PriorityQueue<>();
		int count = 1;
		queue.offer(intervals[0].end);

		for (int i = 1; i < intervals.length; i++) {
			Common.println("Compairing  : intervals[" + i + "].start: " + intervals[i].start + " | " + queue.peek());
			if (intervals[i].start < queue.peek()) {
				count++;
				Common.println("count is now : " + count);
			} else {
				Common.println("removing  : " + queue.poll());
			}
			Common.println("adding  : " + intervals[i].end);

			queue.offer(intervals[i].end);
		}

		return count;
	}

	static class Interval implements Comparable<Interval> {
		int start;
		int end;

		public static Interval build(int start, int end) {
			Interval interval = new Interval();
			interval.start = start;
			interval.end = end;
			return interval;
		}

		@Override
		public int compareTo(Interval o) {
			return this.start - o.start;
		}

		@Override
		public String toString() {
			return "Interval [start=" + start + ", end=" + end + "]";
		}

	}
}
