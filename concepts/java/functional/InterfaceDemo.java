package functional;

@FunctionalInterface
interface Abc {
	void show();
}

public class InterfaceDemo {

	public static void main(String arrp[]) {
		Abc obj = () -> {
			System.out.println("Hello ");
		};
		obj.show();

		Abc obj2 = () -> System.out.println("Hello ");
		obj2.show();
	}

}
