package graph;

import java.util.LinkedList;
import java.util.Queue;

import utils.Common;

public class BfsGraph {

	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		Common.println("  ---------- ---------- ----------BFS --- ---------- -----------------");
		bfs(g, 2);

		boolean[] isVisted = new boolean[g.V];
		Common.println(" ---------- ---------- ---------- DFS -------- ---------- ---------- ------------");
		dfs(g, isVisted, 2);
	}

	/**
	 * Time Complexity: O(V+E) where V is number of vertices in the graph and E is
	 * number of edges in the graph.
	 */
	private static void bfs(Graph graph, int startVertex) {
		boolean[] isVisted = new boolean[graph.V];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(startVertex);
		while (!queue.isEmpty()) {
			Common.printArray(isVisted);
			int vertex = queue.remove();
			Common.println(vertex);
			isVisted[vertex] = true;
			LinkedList<Integer> adjancyList = graph.adjancyList[vertex];

			for (Integer vertexEle : adjancyList) {
				if (!isVisted[vertexEle])
					queue.add(vertexEle);
			}
		}
	}

	/**
	 * Time Complexity: O(V+E) where V is number of vertices in the graph and E is
	 * number of edges in the graph.
	 */

	private static void dfs(Graph graph, boolean[] isVisted, int startVertex) {
		// Common.printArray(isVisted);
		Common.println(startVertex);
		isVisted[startVertex] = true;
		LinkedList<Integer> adjancyList = graph.adjancyList[startVertex];

		for (Integer vertexEle : adjancyList) {
			if (!isVisted[vertexEle])
				dfs(graph, isVisted, vertexEle);
		}
	}

}
