package multithreding;

class Hi implements Runnable {
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("hi");
			MultiThreadDemo.sleep(100);
		}
	}
}

class Hello extends Thread {
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Hello");
			MultiThreadDemo.sleep(100);
		}
	}
}

// You can also use lambdas to do the same job.
public class MultiThreadDemo {

	public static void main(String arr[]) throws InterruptedException {
		Runnable hi = new Hi();
		Thread t = new Thread(hi);
		Hello hello = new Hello();

		
		t.start();

		// This sleep will add a delay of 10 ms at the starting, hence will be printed
		// one by one.
		sleep(10);
		hello.start();
		System.out.println("hi is alive : " + t.isAlive());
		t.join();
		hello.join();
		System.out.println("hi is alive : " + t.isAlive()); // t is not alive after join()
		System.out.println("BYe"); // it will be printed randomly in the midle of Hi and Hello . If you are not using join()
		
		
	}

	public static void sleep(int a) {
		try {
			Thread.sleep(a);
		} catch (InterruptedException e) {
			System.out.println("hInterruptedException");
		}
	}
}
