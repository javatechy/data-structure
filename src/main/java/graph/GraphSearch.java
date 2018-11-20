package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import utils.Common;

public class GraphSearch {

	public static void main(String arp[]) {
		NodeG root = init();
		bfs(root);
		root = init();
		dfs(root);
	}

	private static NodeG init() {
		NodeG root = new NodeG(1, 3, 4, 5, 6);
		NodeG node4 = root.getNode(root, 4);
		node4.addChildren(9);
		node4.addChildren(30, 6, 7);
		NodeG node9 = root.getNode(root, 9);
		return root;
	}

	/**
	 * It is done using recursion.
	 */
	public static void bfs(NodeG root) {
		if (root == null)
			return;
		Common.print(" " + root.data);
		root.isVisited = true;
		if (root.children != null) {
			for (NodeG child : root.children) {
				bfs(child);
			}
		}
	}

	/**
	 * It is done using queue implementation.
	 */
	public static void dfs(NodeG root) {
		Common.println();
		Queue<NodeG> queue = new LinkedList<>();
		queue.add(root);
		Common.print(root.data);
		root.isVisited = true;
		while (!queue.isEmpty()) {
			NodeG node = queue.remove();
			for (NodeG child : node.children) {
				if (child.isVisited == false) {
					Common.print(child.data);
					child.isVisited = true;
					queue.add(child);
				}

			}
		}
	}

}

class NodeG {

	public int data;

	public boolean isVisited;

	public List<NodeG> children = new ArrayList<>();

	public NodeG(int data) {
		this.data = data;
	}

	public NodeG(int data, int... children) {
		this.data = data;
		this.addChildren(children);
	}

	public void addChildren(int... children) {
		for (int child : children) {
			this.children.add(new NodeG(child));
		}
	}

	public NodeG getNode(NodeG node, int data) {
		if (node.children == null) {
			return null;
		}
		for (NodeG child : node.children) {
			if (child.data == data)
				return child;
			else
				return getNode(child, data);
		}
		return null;
	}
}
