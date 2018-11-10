package airtel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.Common;
import java.io.*;
import java.util.*;

class Result4 {

	public static void main(String[] args) {

		List<String> result = solve(4, 5, new int[] { 2, 3, 5, 6 }, new int[] { 5, 4, 3, 2 });
		Common.print(result);

	}

	static List<Integer> temp = new ArrayList<>();

	public static ArrayList<Integer> solve(int N, long M, int[] price, int[] id) {

		return findResult(N, M, price, id);
	}

	private static ArrayList<Integer> findResult(int N, long M, int[] price, int[] id,index) {
		
		if (M == 0) {
			temp.add(index);
			return true;
		}

		boolean result = false;
		for (int i = 0; i < price.length; i++) {
			result = result || solve(N, M - price[i], price, id , index);
		}
		return result;
	}
}