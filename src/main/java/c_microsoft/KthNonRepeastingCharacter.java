package c_microsoft;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import utils.Common;

/**
 * https://www.geeksforgeeks.org/kth-non-repeating-character/
 */
public class KthNonRepeastingCharacter {

	public static void main(String[] args) {
		String str = "geeksforgeeks";
		int k = 3;
		char index = getKthNonRepeating(str, k);
		Common.println(index);

	}

	private static char getKthNonRepeating(String str, int k) {
		Map<Character, Integer> map = new LinkedHashMap<>();

		for (int i = 0; i < str.length(); i++) {
			if (!map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), 1);
				continue;
			}
			map.computeIfPresent(str.charAt(i), (p, v) -> v + 1);
		}
		return map.entrySet().stream().filter(p -> map.get(p.getKey()) == 1).map(t -> t.getKey())
				.collect(Collectors.toList()).get(k - 1);
	}
	
	
	

}
