package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import utils.Common;

public class DetectCyclicGraph {

	public static void main(String arp[]) {
		Graph graph = new Graph(4, true);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
	// graph.addEdge(2, 0);
		// graph.addEdge(2, 3);
		 graph.addEdge(3, 3);

		graph.printGraph(graph);

		if (findCycleByColors(graph)) {
			Common.println("Its a cycle from VERTEX : ");
		} else {
			Common.println("No Cycle Found ");
		}
	}

	private static boolean findCycleByColors(Graph graph) {
		Set<Integer> whiteSet = new HashSet<>();
		Set<Integer> greySet = new HashSet<>();
		Set<Integer> blackSet = new HashSet<>();
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < graph.V; i++) {
			whiteSet.add(i);
		}
		while (!whiteSet.isEmpty()) {
			int vertex = whiteSet.iterator().next();
			Common.println(vertex);
			if (dfs(whiteSet, greySet, blackSet, map, graph, vertex)) {
				Common.println("dfs cycle : ");
				return true;
			}

		}
		return false;
	}

	private static boolean dfs(Set<Integer> whiteSet, Set<Integer> greySet, Set<Integer> blackSet,
			Map<Integer, Integer> map, Graph graph, int vertex) {

		Common.println("dfs called : for : " +vertex);
		moveVertx(whiteSet, greySet, vertex);
		for (int child : graph.adjancyList[vertex]) {
			if (blackSet.contains(child))
				continue;

			if (greySet.contains(child)) {
				// its a cycle
				return true;
			}

			if (dfs(whiteSet, greySet, blackSet, map, graph, child)) {
				return true;
			}

		}

		moveVertx(greySet, blackSet, vertex);
		return false;
	}

	private static void moveVertx(Set<Integer> source, Set<Integer> dest, int ele) {
		source.remove(ele);
		dest.add(ele);
	}

	private static boolean findCycle(Graph graph) {
		// Mark all the vertices as not visited and
		// not part of recursion stack
		boolean[] visited = new boolean[graph.V];
		boolean[] recStack = new boolean[graph.V];

		// Call the recursive helper function to
		// detect cycle in different DFS trees
		for (int i = 0; i < graph.V; i++)
			if (isCyclicUtil(graph, i, visited, recStack))
				return true;

		return false;
	}

	private static boolean isCyclicUtil(Graph graph, int i, boolean[] visited, boolean[] recStack) {

		Common.println("Working on " + i);
		Common.printArray(visited);
		Common.printArray(recStack);
		// Mark the current node as visited and
		// part of recursion stack
		if (recStack[i])
			return true;

		if (visited[i])
			return false;

		visited[i] = true;

		recStack[i] = true;
		List<Integer> children = graph.adjancyList[i];

		for (Integer c : children)
			if (isCyclicUtil(graph, c, visited, recStack))
				return true;

		recStack[i] = false;

		return false;
	}

}