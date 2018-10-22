package interviews;

import java.util.HashSet;
import java.util.Set;

public class MostOftenSubstring {
	
	public static void main(String[] args) {

		String str = "ababab";

		int K = 2;
		int L = 3;
		int M = 4;

		String string = str;

		int count = getMaxOccurrences(string, K, L, M);
		System.out.println(count);
	}
	static TrieNode root;
	static Set distinctCharacters = new HashSet();

	public static int getMaxOccurrences(String str, int min, int max, int unique) {
		if (str == null)
			return 0;
		int n = str.length();
		if (n == 0) {
			return 0;
		}
		if (min < 0 || max < 0 || unique <= 0) {
			return 0;
		}
		int maxFrequency = 1;
		root = new TrieNode();
		for (int i = 0; i < n; ++i) {
			for (int j = min; j <= max && j <= n; ++j) {
				String substring = str.substring(i, j);
				// return -1 if distincts more than m
				int currentFrequency = insertIntoTrie(substring, unique);
				if (currentFrequency == -1)
					break;
				maxFrequency = (currentFrequency > maxFrequency) ? currentFrequency : maxFrequency;
			}
			min += 1;
			max += 1;
		}
		return maxFrequency;
	}

	public static int insertIntoTrie(String word, int m) {
		distinctCharacters.clear();
		TrieNode parent = root;
		for (char c : word.toCharArray()) {
			distinctCharacters.add(c);
			if (distinctCharacters.size() > m) {
				return -1;
			}
			int i = c - 'a';
			if (parent.next[i] == null)
				parent.next[i] = new TrieNode();
			parent = parent.next[i];
		}
		if (parent.word != null) {
			parent.frequency += 1;
		} else {
			parent.word = word;
			parent.frequency = 1;
		}
		return parent.frequency;
	}

	static class TrieNode {
		TrieNode[] next = new TrieNode[26];
		String word;
		int frequency = 0;
	}
}