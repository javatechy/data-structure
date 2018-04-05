package queue;

import utils.Common;

//CONSTRUCTION: with no initializer
//
//******************PUBLIC OPERATIONS*********************
//void enqueue( obj )      -- Insert obj
//Object dequeue( )      -- Return and remove least recent item
//boolean isEmpty( )     -- Return true if empty; else false

public class QueueOperation {
	// Driver Program
	public static void main(String[] args) {
		MyQueue queue = new MyQueue(5);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		
		Common.print(queue.dequeue());
		queue.enqueue(5);
		Common.print(queue.dequeue());
		Common.print(queue.dequeue());
		Common.print(queue.dequeue());
		Common.print(queue.dequeue());
		Common.print(queue.dequeue());
		// Common.print(queue.dequeue());
	}
}
