package queue;

public class CircularQueue {
	private int[] arr;
	int head = -1;
	int tail = -1;

	/** Initialize your data structure here. Set the size of the queue to be k. */
	public CircularQueue(int k) {
		arr = new int[k];
		tail = k - 1;
	}

	/**
	 * Insert an element into the circular queue. Return true if the operation is
	 * successful.
	 */
	public boolean enQueue(int value) {
		if (head == -1) {
			arr[tail] = value;
			tail++;
			head++;
			return true;
		}
		if ((tail == arr.length - 1 && head == 0) || (tail == head - 1))
			return false;
		tail++;
		arr[tail] = value;
		return true;
	}

	/**
	 * Delete an element from the circular queue. Return true if the operation is
	 * successful.
	 */
	public boolean deQueue() {
		if (head == tail)
			return false;
		tail--;
		return true;
	}

	/** Get the front item from the queue. */
	public int Front() {
		return arr[head];
	}

	/** Get the last item from the queue. */
	public int Rear() {
		return arr[tail];
	}

	/** Checks whether the circular queue is empty or not. */
	public boolean isEmpty() {
		if (head == tail)
			return true;
		return false;
	}

	/** Checks whether the circular queue is full or not. */
	public boolean isFull() {
		if (tail == head - 1)
			return true;
		return false;
	}

}
