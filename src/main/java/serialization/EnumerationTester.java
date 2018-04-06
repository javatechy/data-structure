package serialization;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import static utils.Common.*;

/**
 * The Enumeration interface defines the methods by which you can enumerate
 * (obtain one at a time) the elements in a collection of objects.
 * 
 * This legacy interface has been superseded by Iterator. Although not
 * deprecated, Enumeration is considered obsolete for new code. However, it is
 * used by several methods defined by the legacy classes such as Vector and
 * Properties, is used by several other API classes, and is currently in
 * widespread use in application code.
 * 
 * @author deepak
 *
 */
public class EnumerationTester {
	public static void main(String args[]) {
		// Example Vector class implements Enumerator.
		List<String> list = Arrays.asList("Sunday", "Monday", "Helelo");
		EnumeratorImpl enumerator = new EnumeratorImpl(list);
		println(" Enumerator Example");
		while (enumerator.hasMoreElements()) {
			println(enumerator.nextElement());
		}

		println(" Iterator Example");

		IteratorImpl iterator = new IteratorImpl(list);
		while (iterator.hasNext()) {
			println(iterator.next());
		}

		println(" ListIterator Example");

		ListIteratorImpl listIterator = new ListIteratorImpl(list);
		while (listIterator.hasNext()) {
			println(listIterator.next());
			listIterator.add("New Method");
		}
	}
}

class EnumeratorImpl implements Enumeration<String> {
	int index = 0;
	List<String> list = null;

	public EnumeratorImpl(List<String> list) {
		this.list = list;
	}

	@Override
	public boolean hasMoreElements() {
		return !(index == list.size());
	}

	@Override
	public String nextElement() {
		String value = list.get(index);
		index++;
		return value;
	}

}

class IteratorImpl implements Iterator<String> {
	int index = 0;
	List<String> list = null;

	public IteratorImpl(List<String> list) {
		this.list = list;
	}

	@Override
	public boolean hasNext() {
		return !(index == list.size());
	}

	@Override
	public String next() {
		String value = list.get(index);
		index++;
		return value;
	}

}

class ListIteratorImpl implements ListIterator<String> {
	int index = 0;
	List<String> list = null;

	public ListIteratorImpl(List<String> list) {
		this.list = list;
	}

	@Override
	public boolean hasNext() {
		return !(index == list.size());
	}

	@Override
	public String next() {
		String value = list.get(index);
		index++;
		return value;
	}

	@Override
	public boolean hasPrevious() {
		return Objects.nonNull(list.get(index - 1));
	}

	@Override
	public String previous() {
		return list.get(index - 1);
	}

	@Override
	public int nextIndex() {
		return index + 1;
	}

	@Override
	public int previousIndex() {
		return index - 1;
	}

	@Override
	public void remove() {
		list.remove(index);
	}

	@Override
	public void set(String e) {
		list.add(e);

	}

	@Override
	public void add(String e) {
		list.add(e);
	}
}
