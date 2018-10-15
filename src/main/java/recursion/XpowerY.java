package recursion;

public class XpowerY {

	public static void main(String args[]) throws Exception {

		double result = power(2, 3);
		System.out.println("Result " + result);

		result = power(6, 3);
		System.out.println("Result " + result);

		// Cases
		
		result = power(0, 0);
		System.out.println("Result " + result);

		result = power(1, 100000000);
		System.out.println("Result " + result);

		result = power(0, -1);
		System.out.println("Result " + result);

	}

	private static double power(int x, int y) throws Exception {
		// Skipping calulation for x=1
		if (x == 1 && y > 0)
			return 1;

		if(x==0 && y==0 )
			System.out.println("undefined");
		
		// Skipping calulation for x=0
		if (x == 0 && y > 0)
			return 0;

		// Skipping calulation for y=0
		if (y == 0) {
			return 1.0;
		}
		if (y < 0) {
			// Negative power case
			if (x == 0) {
				throw new Exception("Raise 0 to the power :-ve num");
			}
			// If -ve power making it postive
			return 1 / power(x, -y);
		}

		double temp = power(x, y / 2);

		if (y % 2 == 0) {
			return temp * temp;
		} else { // odd case
			return x * temp * temp;
		}
	}
}
