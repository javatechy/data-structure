
package c_microsoft;

import java.util.HashMap;
import java.util.Map;

import utils.Common;

public class LRUCache {

	Map<Integer, DLinkedNode> map;
	DLinkedNode head = null;
	DLinkedNode end = null;
	int totalSize;
	int capacity;

	public LRUCache(int capacity) {
		map = new HashMap<>();
		this.capacity = capacity;

	}

	public void addNode(int element) {
		DLinkedNode dlink = new DLinkedNode(element);
		if (head == null) {
			dlink.pre = null;
			dlink.next = null;
			end = dlink;
			head = dlink;
			totalSize++;
			map.put(element, dlink);
			return;
		}

		if (totalSize >= capacity) {
			// Capacity Full && present in map
			if (map.get(element) != null) {
				head = head.next;
				DLinkedNode node = map.get(element);
				node.pre = end;
				end.next = node;
			} else {
				// Capacity Full && not present in map
				map.remove(head.data);
				head =head.next;
				head.pre =null;
						
				addNewElementToDLL(element, dlink);
			}
			return;
		} else
			addNewElementToDLL(element, dlink);

	}

	private void addNewElementToDLL(int element, DLinkedNode dlink) {
		DLinkedNode prev = end;
		end.next = dlink;
		dlink.pre = prev;
		end = dlink;
		totalSize++;
		map.put(element, dlink);
	}

	public void removeFromHashMap(int element) {
		DLinkedNode node = map.get(element);

		if (node != null) {
			DLinkedNode pre = node.pre;
			DLinkedNode next = node.next;

			if (next == null && pre == null) {
				head = null;
			} else if (next == null) // last node
				node.pre = null;
			else if (pre == null) // head node
				node = node.next;
			else {// middle Node
				pre = next;
				next.pre = pre;
			}
			map.remove(element);
		}

	}

	public void printLRU() {
		if (head == null) {
			Common.println("Head is null");
			return;
		}
		DLinkedNode node = head;

		while (node != null) {
			Common.print(node.data + " -> ");
			node = node.next;
		}
		Common.println();

	}

	public static void main(String arpp[]) {
		int arr[] = { 1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5 };
		LRUCache cache = new LRUCache(3);

		for (int a : arr) {
			Common.println("LRU Cache adding " + a);
			cache.addNode(a);
			cache.printLRU();
			Common.println(cache.map);
		}
	}

	class DLinkedNode {
		int data;
		DLinkedNode pre;
		DLinkedNode next;

		DLinkedNode(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "DLinkedNode [data=" + data + "]";
		}

	}
}