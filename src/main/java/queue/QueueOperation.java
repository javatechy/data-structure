package queue;

import utils.Common;

//CONSTRUCTION: with no initializer
//
//******************PUBLIC OPERATIONS*********************
//void enQueue( obj )      -- Insert obj
//Object deQueue( )      -- Return and remove least recent item
//boolean isEmpty( )     -- Return true if empty; else false

public class QueueOperation {
	// Driver Program
	public static void main(String[] args) {
		CircularQueue circularQueue = new CircularQueue(3); // set the size to be 3
		Common.println(circularQueue.enQueue(1)); // return true
		Common.println(circularQueue.enQueue(2)); // return true
		Common.println(circularQueue.enQueue(3)); // return true
		Common.println(circularQueue.enQueue(4)); // return false, the queue is full
		Common.println(circularQueue.Rear()); // return 3
		Common.println(circularQueue.isFull()); // return true
		Common.println(circularQueue.deQueue()); // return true
		Common.println(circularQueue.enQueue(4)); // return true
		Common.println(circularQueue.Rear()); // return 4
		
	}
}
