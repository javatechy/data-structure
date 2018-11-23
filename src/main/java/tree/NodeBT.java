package tree;

public class NodeBT {
	public int data;
	public NodeBT left;
	public NodeBT right;

	public NodeBT(int data) {
		this.data = data;
		left = null;
		right = null;
	}

	@Override
	public String toString() {
		return "NodeBT [data=" + data + "]";
	}
	
}
