package interviews;

import java.util.Iterator;
import java.util.LinkedList;

import utils.Common;

/**
 * Swiggy
 */
public class TravellingIsFun2 {

	public static void main(String args[]) {

		int origin[] = { 1, 2, 3 };
		int dest[] = { 4, 5, 6 };

		int[] result = new TravellingIsFun2().connectedCities(6, 1, new int[] { 1, 2, 4, 6 }, new int[] { 3, 3, 3, 4 });

		Common.printArray(result);
	}

	static int[] connectedCities(int n, int g, int[] originCities, int[] destinationCities) {
		int q = originCities.length;

		LinkedList adj[] = gcd(g, n);

		int[] arr = new int[q];
		Common.printArray(adj);
		int p = 0;
		for (int l = 0; l < q; l++) {
			Integer s = originCities[l];
			Integer e = destinationCities[l];

			boolean visited[] = new boolean[n + 1];
			LinkedList<Integer> queue = new LinkedList<Integer>();

			visited[s] = true;
			queue.add(s);
			Iterator<Integer> i;
			boolean done = false;
			while (queue.size() != 0) {
				s = queue.poll();
				int k;
				i = adj[s].listIterator();
				while (i.hasNext()) {
					k = i.next();
					if (k == e) {
						done = true;
					}

					if (!visited[k]) {
						visited[k] = true;
						queue.add(k);
					}

				}
			}

			if (done)
				arr[p++] = 1;
			else
				arr[p++] = 0;

		}

		return arr;
	}

	static LinkedList<Integer>[] gcd(int g, int n) {

		LinkedList<Integer> adj[] = new LinkedList[n + 1];
		for (int i = 0; i <= n; ++i) {
			adj[i] = new LinkedList<Integer>();
		}

		for (int i = g + 1; i <= n; i++) {
			int x = 2;
			int p = i;
			while (i * x <= n) {
				int q = i * x;
				adj[p].add(q);
				adj[q].add(p);
				x++;
			}
		}
		return adj;
	}

}