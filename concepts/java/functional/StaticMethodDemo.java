package functional;

interface DemoStatic {
	int a =10;
	static void show() {
		System.out.println("in demo2 show()");
	}

}

public class StaticMethodDemo {

	public static void main(String arrp[]) {
		DemoStatic.show();
	}

}
