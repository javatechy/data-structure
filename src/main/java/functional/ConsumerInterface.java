package functional;

import java.util.function.Consumer;

public class ConsumerInterface {

	public static void main(String[] arr) {
		Consumer<Object> consumer = (s) -> {
			System.out.println(s);
		};
		consumer.accept(2);
		consumer.accept("HELLO");
		consumer.accept("DEEPAK");
	}
}
