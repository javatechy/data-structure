package graph;

import java.util.ArrayList;
import java.util.List;

public class NodeG {

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
		}
		return null;
	}
}
