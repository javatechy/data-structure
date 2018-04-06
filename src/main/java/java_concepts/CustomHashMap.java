package java_concepts;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CustomHashMap<K, V> {
	List<K> bucket;

	CustomHashMap(int size) {
		bucket = new ArrayList<>();
	}

	public Set<K> keySet() {
		return null;
	}

	public List<V> values() {
		return null;
	}

}

class MyEntry<K, V> {
	K key;
	V value;
	MyEntry<K, V> next;

	MyEntry(K key, V value, MyEntry<K, V> next) {
		this.key = key;
		this.value = value;
		this.next = next;
	}
}
