package functional;

import java.util.function.Function;

public class FunctionalInterface {

	public static void main(String[] arr) {
		Function<String, Integer> functional = (s) -> {
			return Integer.parseInt(s);
		};
		System.out.println(functional.apply("2"));
		System.out.println(functional.apply("2.2"));
	}
}
