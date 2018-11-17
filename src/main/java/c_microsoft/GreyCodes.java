package c_microsoft;

/**
 * 
 * Check Babylonian theorem for exact sqrt
 * 
 * https://www.geeksforgeeks.org/square-root-of-an-integer/
 *
 */
public class GreyCodes {

	public static void main(String[] args) {

		int n = 4;
		int totalCom = (int) Math.pow(2, n);
		int num = 0;
		int total = 0;
		for (int i = 0; i < totalCom; i++) {
			String binaryString = Integer.toBinaryString(num);
			while (binaryString.length() < n) {
				binaryString = "0" + binaryString;
			}
			System.out.println(binaryString);
			num++;
			total++;
		}
		System.out.println("Total Printed :" + total);

	}

}
