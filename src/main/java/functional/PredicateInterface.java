package functional;

import java.util.function.Predicate;

public class PredicateInterface {

	public static void main(String[] arr) {
		Predicate<String> predicate = predicateTest();
		System.out.println(predicate.test("deepak"));
		System.out.println(predicate.test("deepak2"));
	}

	private static Predicate<String> predicateTest() {
		return t -> {
			if (t.equals("deepak"))
				return true;
			return false;
		};
	}
}
