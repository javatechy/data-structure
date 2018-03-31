package functional;

import java.util.function.Supplier;

public class SupplierInterface {

	public static void main(String[] arr) {
		Supplier<Integer> supplier = () -> {
			return (int) (Math.random() * 100);
		};

		System.out.println(supplier.get());
		System.out.println(supplier.get());
		System.out.println(supplier.get());
		System.out.println(supplier.get());
	}
}
