package trie;

import utils.Common;

/**
 * Great for word validation problems
 * 
 * @author deepak
 *
 */

// Java implementation of search and insert operations
// on Trie
public class Trie {

	// Driver
	public static void main(String args[]) {
		// Input keys (use only 'a' through 'z' and lower case)
		String keys[] = { "the", "a", "thmm", "there", "thpanswer", "any", "by", "bye", "their","tyh" };

		TrieNode root = new TrieNode();

		for (String key : keys) {
			insert(root, key);
		}
		print(root);
		Common.println();

		String searchKey = "t";
		TrieNode node = search(root, searchKey);

		print(node, searchKey);

		Common.println(node.children.size());
	}

	private static TrieNode search(TrieNode root, String key) {
		TrieNode node = root;
		for (char character : key.toCharArray()) {
			if (node.children.get(character) == null)
				break;
			node = node.children.get(character);
		}

		return node;
	}

	private static void insert(TrieNode root, String key) {
		TrieNode node = root;
		for (char character : key.toCharArray()) {
			if (node.children.get(character) == null) {
				node.children.put(character, new TrieNode());
			}
			if (node.children.get(character) != null) {
				node = node.children.get(character);
			}
		}
		node.isCompleteWord = true;
	}

	public static void print(TrieNode root) {
		if (root == null) {
			return;
		}

		if (root.isCompleteWord)
			Common.println();

		TrieNode node = root;
		node.children.forEach((key, child) -> {
			Common.print(key + " , ");
			print(child);
		});

	}

	public static void print(TrieNode root, String prefix) {
		if (root == null) {
			return;
		}

		if (root.isCompleteWord)
			Common.println(prefix);

		TrieNode node = root;
		node.children.forEach((key, child) -> {
			print(child, prefix + key);
		});

	}
}
