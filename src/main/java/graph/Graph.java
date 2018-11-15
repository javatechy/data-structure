package graph;

import java.util.LinkedList;

public class Graph {
	public int V;
	public LinkedList<Integer> adjancyList[];

	Graph(int v) {
		this.V = v;
		adjancyList = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adjancyList[i] = new LinkedList<>();
		}
	}

	public void addEdge(int source, int dest) {
		adjancyList[source].add(dest);
	}
}
