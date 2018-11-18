package trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Great for word validation problems
 * 
 * @author deepak
 *
 */

// Java implementation of search and insert operations
// on Trie
public class TrieNode {
	public Map<Character, TrieNode> children;
	public boolean isCompleteWord;

	TrieNode() {
		children = new HashMap<>();
	}
}
