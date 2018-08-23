package airtel;

import static utils.Common.println;

public class ProducerConsumer {
	private static final int SIZE_OF_ELEMENTS = 10;

	public static void main(String[] args) {
		println("Inititalizing data ");
		IntializedData initData = new IntializedData(SIZE_OF_ELEMENTS);
		println("Inititalizing producer ");
		Producer producer = new Producer(initData);
		println("Inititalizing consumer ");
		Consumer consumer = new Consumer(initData);
		producer.start();
		consumer.start();
	}
}

class IntializedData {
	private int value;
	private boolean available = false;
	public int max;

	IntializedData(int max) {
		this.max = max;
	}

	public synchronized int retrive() {
		if (available == false) {
			try {
				wait();
			} catch (InterruptedException e) {

			}
		}
		available = false;
		notifyAll();
		return value;
	}

	public synchronized void add(int val) {
		if (available == true) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		this.value = val;
		available = true;
		notifyAll();
	}
}

class Consumer extends Thread {
	private IntializedData intializerData;

	public Consumer(IntializedData c) {
		intializerData = c;
	}

	public void run() {
		int value = 0;
		for (int i = 0; i < intializerData.max; i++) {
			value = intializerData.retrive();
			println("Consuming Number : " + value);
		}
	}
}

class Producer extends Thread {
	private IntializedData intializerData;

	public Producer(IntializedData c) {
		intializerData = c;
	}

	public void run() {
		for (int i = 0; i < intializerData.max; i++) {
			intializerData.add(i);
			println("Producing number : " + i);
			try {
				sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}
