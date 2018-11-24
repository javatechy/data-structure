package c_microsoft;

import utils.Common;

public class TinyUrl {

	static int n = 12345;

	public static void main(String[] args) {
		TinyUrl t = new TinyUrl();
		String shorturl = t.idToShortURL(n);
		Common.println("Generated short url is " + shorturl);
		Common.println("Id from url is " + t.shortURLtoID(shorturl));
	}

	// Function to generate a short url from intger ID
	String idToShortURL(long n) {
		// Map to store 62 possible characters
		char map[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

		String shorturl = "";

		// Convert given integer id to a base 62 number
		while (n != 0) {
			// use above map to store actual character
			// in short url
			shorturl += map[(int) (n % 62)];
			n = n / 62;
		}

		// Reverse shortURL to complete base conversion
		shorturl = new StringBuffer(shorturl).reverse().toString();

		return shorturl;
	}

	// Function to get integer ID back from a short url

	long shortURLtoID(String shortURL) {
		long id = 0; // initialize result

		// A simple base conversion logic
		for (int i = 0; i < shortURL.length(); i++) {
			if ('a' <= shortURL.charAt(i) && shortURL.charAt(i) <= 'z')
				id = id * 62 + shortURL.charAt(i) - 'a';
			if ('A' <= shortURL.charAt(i) && shortURL.charAt(i) <= 'Z')
				id = id * 62 + shortURL.charAt(i) - 'A' + 26;
			if ('0' <= shortURL.charAt(i) && shortURL.charAt(i) <= '9')
				id = id * 62 + shortURL.charAt(i) - '0' + 52;
		}
		return id;
	}
}