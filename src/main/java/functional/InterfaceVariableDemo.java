package functional;

interface DemoVar {
	int a = 10;

	default void show() {
		System.out.println("in demo2 show()");
	}
}

class DemoVarImpl implements DemoVar {

	public void show() {
		// a = 11; Error cannot change
		System.out.println("in demo2 show()");
	}
}

public class InterfaceVariableDemo {

	public static void main(String arrp[]) {
		DemoVar demo = new DemoVarImpl();
		demo.show();
	}

}
