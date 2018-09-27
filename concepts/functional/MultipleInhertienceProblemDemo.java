package functional;


interface Demo1 {
	default void show() {
		System.out.println("in demo1 show()");
	}
}

interface Demo2 {
	default void show() {
		System.out.println("in demo2 show()");
	}

}

class DemoMulti implements Demo1, Demo2 {
	public void show() {
		Demo1.super.show();
		System.out.println("M in show()");
	}

}

public class MultipleInhertienceProblemDemo {

	public static void main(String arrp[]) {
		Demo1 demo = new DemoMulti();
		demo.show();
	}

}
