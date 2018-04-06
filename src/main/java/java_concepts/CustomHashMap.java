package java_concepts;

public class CustomHashMap {
	
	
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
