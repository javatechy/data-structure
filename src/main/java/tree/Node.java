package tree;

public class Node<T> {
	T data;
	Node<T> left;
	Node<T> right;
	int level;

	public Node(T data) {
		this.data = data;
		left = null;
		right = null;
	}
}
