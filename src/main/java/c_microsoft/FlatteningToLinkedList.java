package c_microsoft;

import linkedlist.LinkedList;
import linkedlist.NodeLL;

/**
 * https://www.geeksforgeeks.org/flattening-a-linked-list/
 *
 */
public class FlatteningToLinkedList {

	public static void main(String[] args) {
		
	}

	public static NodeFLat convert(NodeFLat head, int... arr) {

		NodeFLat pointer = head;
		for (int i = 1; i < arr.length; i++) {
		//	NodeFLat newNode = new NodeFLat(2);
		//	pointer.down = newNode;
		//	pointer = newNode;
		}
		return head;
	}

	class NodeFLat extends NodeLL {
		public NodeFLat(int data) {
			super(data);
		}

		public NodeFLat down;
	}
}
