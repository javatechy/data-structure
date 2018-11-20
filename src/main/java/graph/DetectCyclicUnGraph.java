package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import utils.Common;

public class DetectCyclicUnGraph {

	public static void main(String arp[]) {
		Graph graph = new Graph(4);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);

		graph.printGraph(graph);

		if (findCycle(graph)) {
			Common.println("Its a cycle from VERTEX : ");
		} else {
			Common.println("No Cycle Found ");
		}
	}

	private static boolean findCycle(Graph graph) {
		for (int i = 0; i < graph.V; i++) {
			if (!graph.visited[i] && bfs(graph, i)) {
				return true;
			}
		}
		return false;
	}

	private static boolean bfs(Graph graph, int vertex) {

		Queue<Integer> queue = new LinkedList<>();

		Map<Integer, Integer> parent = new HashMap<>();

		parent.put(vertex, -1);
		queue.add(vertex);
		graph.visited[vertex] = true;
		while (!queue.isEmpty()) {
			int ver = queue.remove();

			Common.println("This ver : " + ver);
			for (int child : graph.adjancyList[ver]) {
				if (!graph.visited[child]) {
					graph.visited[child] = true;
					queue.add(child);
					parent.put(child, ver);
				} else if (parent.get(ver) != child) { // if visited
					Common.println("This Is the reason");
					Common.println(parent);
					return true;
				}

			}
		}
		return false;
	}

}