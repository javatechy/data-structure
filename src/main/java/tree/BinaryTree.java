package tree;

public class BinaryTree {
	private NodeBT root;

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new NodeBT(1);
		bt.root.left = new NodeBT(2);
		bt.root.right = new NodeBT(3);
		
		insert(bt.root,30);
		
		
	}

	private static void insert(NodeBT root, int i) {
		
		NodeBT pointer = root;
		
		while(true) {
			
			
			
		}
	}
}
