package effectivejava;

/**
 * ITEM -6 EFECTIVE JAVA 3rd Edition
 * 
 * @author deepak
 *
 */
public class PremitiveVsNonPrimitive {

	public static void main(String arr[]) {
		testNonPremitive();
		testMix();
		testPremitive();
	}

	private static void testMix() {
		long startTime = System.currentTimeMillis();
		Long sum = 0L;
		for (long i = 0l; i < Integer.MAX_VALUE; i++) {
			sum += i;
		}
		System.out.println(sum);
		long endTime = System.currentTimeMillis();
		double difference = (double) (endTime - startTime) / 1000;
		System.out.println("Total TIme Taken in mix  type " + difference);
	}

	private static void testPremitive() {
		long startTime = System.currentTimeMillis();

		long sum = 0L;
		for (long i = 0l; i < Integer.MAX_VALUE; i++) {
			sum += i;
		}
		System.out.println(sum);
		long endTime = System.currentTimeMillis();
		double difference = (double) (endTime - startTime) / 1000;
		System.out.println("Total TIme Taken in testPremitive  type " + difference);

	}

	private static void testNonPremitive() {
		long startTime = System.currentTimeMillis();
		Long sum = 0L;
		for (Long i = 0l; i < Integer.MAX_VALUE; i++) {
			sum += i;
		}
		System.out.println(sum);
		long endTime = System.currentTimeMillis();
		double difference = (double) (endTime - startTime) / 1000;
		System.out.println("Total TIme Taken in testNonPremitive  type " + difference);

	}
}
