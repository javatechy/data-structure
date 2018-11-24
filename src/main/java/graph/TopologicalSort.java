
package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import utils.Common;

public class TopologicalSort {

	public static void main(String arp[]) {
		Graph graph = new Graph(7, true);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(5, 6);

		graph.printGraph(graph);
		Stack<Integer> stack = new Stack<>();
		topologicalSort(graph, 3, stack);
		Common.println(stack);

	}

	private static void topologicalSort(Graph graph, int startVertex, Stack<Integer> stack) {

		if (graph.visited[startVertex])
			return;
		if (hasExporedAllNeghbours(graph, startVertex)) {
			stack.add(startVertex);
		} else {
			for (int adjVer : graph.adjancyList[startVertex]) {
				graph.visited[adjVer] = true;
				topologicalSort(graph, adjVer, stack);
			}
		}
	}

	private static boolean hasExporedAllNeghbours(Graph graph, int ver) {
		for (int adjVer : graph.adjancyList[ver])
			if (!graph.visited[adjVer])
				return false;
		return true;
	}

}