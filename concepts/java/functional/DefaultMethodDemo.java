package functional;

interface Demo {
	void show();

	default void sayHellp() {
		System.out.println("Saying hello");
	}

}

class DemoImpl implements Demo {
	public void show() {

		System.out.println("M in show()");
	}

	public void sayHellp() {
		System.out.println(" in herrtied Saying hello");
	}

}

public class DefaultMethodDemo {

	public static void main(String arrp[]) {
		Demo demo = new DemoImpl();
		demo.show();
		demo.sayHellp();
	}

}
