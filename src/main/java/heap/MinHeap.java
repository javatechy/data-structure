package heap;

import java.util.Arrays;

import utils.Common;

public class MinHeap {// Java program for implementation of Heap Sort

	private static int[] heap;
	private int currentIndex;
	private int capacity;

	public MinHeap(int size) {
		heap = new int[size];
		this.currentIndex = 0;
		this.capacity = size;
	}

	// Driver program
	public static void main(String args[]) {
		int arr[] = { 12, 43, 2, 21, 34, 11, 1, 23 };
		MinHeap min = new MinHeap(3);
		for (int ele : arr)
			min.add(ele);
		Common.printArray(heap);
		Common.println(min.peek());
		Common.println(min.peek());
		Common.println(min.peek());
		Common.println(min.peek());
	}

	// find top/ min element
	public int peek() {
		if (currentIndex == 0)
			throw new RuntimeException("Size is Zero");
		int element = heap[0];
		heap[0] = heap[currentIndex - 1];
		currentIndex--;
		heapifyDown();
		return element;
	}

	// In case of deleting an element
	private void heapifyDown() {
		int index = 0;
		while (hasLeftChild(index)) {
			int smallChildIndex = getLeftChildIndex(index);
			if (hasRightChild(smallChildIndex) && getRightChild(index) < getLeftChild(index)) {
				smallChildIndex = getRightChildIndex(index);
			}
			if (heap[index] < heap[smallChildIndex]) {
				break;
			}
			Common.swap(heap, index, smallChildIndex);
			index = smallChildIndex;
		}

	}

	private void ensureExtraCapacity() {
		if (currentIndex + 1 == capacity) {
			int newCapacity = (int) (capacity * 1.5);
			heap = Arrays.copyOf(heap, newCapacity);
			capacity = newCapacity;
		}
	}

	public void add(int item) {
		ensureExtraCapacity();
		heap[currentIndex] = item;
		currentIndex++;
		heapifyUp();
	}

	private void heapifyUp() {
		int index = currentIndex - 1;

		while (hasParent(index) && parent(index) > heap[index]) {
			Common.swap(heap, getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}

	// extract Min
	public int poll() {
		return heap[0];
	}

	// Util Methods

	private int getLeftChildIndex(int i) {
		return 2 * i + 1;
	}

	private int getRightChildIndex(int i) {
		return 2 * i + 2;
	}

	private int getLeftChild(int i) {
		return heap[getLeftChildIndex(i)];
	}

	private int getRightChild(int i) {
		return heap[getRightChildIndex(i)];
	}

	private int getParentIndex(int childIndex) {
		return (childIndex - 1) / 2;
	}

	private int parent(int index) {
		return heap[getParentIndex(index)];
	}

	private boolean hasParent(int childIndex) {
		return getParentIndex(childIndex) >= 0;
	}

	private boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < currentIndex;
	}

	private boolean hasRightChild(int index) {
		return getLeftChildIndex(index) < currentIndex;
	}

}
