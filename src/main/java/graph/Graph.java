package graph;

import java.util.LinkedList;

import utils.Common;

public class Graph {
	public int V;
	public LinkedList<Integer> adjancyList[];

	public boolean[] visited;
	public boolean isDirected;

	Graph(int v, boolean isDirected) {
		this(v);
		this.isDirected = isDirected;
	}

	Graph(int v) {
		this.V = v;
		adjancyList = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adjancyList[i] = new LinkedList<>();
		}
		visited = new boolean[v];
		Common.printArray(visited);
	}

	public void addEdge(int source, int dest) {
		adjancyList[source].add(dest);

		// Since graph is undirected, add an edge from dest
		// to src also
		if (!isDirected)
			adjancyList[dest].add(source);
	}

	// A utility function to print the adjacency list
	// representation of graph
	static void printGraph(Graph graph) {
		for (int v = 0; v < graph.V; v++) {
			System.out.println("Adjacency list of vertex " + v);
			for (Integer pCrawl : graph.adjancyList[v]) {
				System.out.print(" -> " + pCrawl);
			}
			System.out.println("\n");
		}
	}
}
