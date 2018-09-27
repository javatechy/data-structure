package multithreding;

class Counter {
	int count;

	public synchronized void increment() {
		count++;
	}
}

// You can also use lambdas to do the same job.
public class SynchroisedDemo {

	public static void main(String arr[]) throws InterruptedException {
		Counter counter = new Counter();

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++)
				counter.increment();
		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 1000; i++)
				counter.increment();
		});
		t1.start();
		t2.start();
		
		//t1.join(); // This will wait for t to finish
		//t2.join();
		Thread.sleep(10000);
		System.out.println(counter.count);
	}

}
