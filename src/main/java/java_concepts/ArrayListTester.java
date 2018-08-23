package java_concepts;

import java.util.ArrayList;

public class ArrayListTester {
	public static void main(String args[]) {// create an empty array list
		ArrayList<String> color_list = new ArrayList<String>();

		// use add() method to add values in the list
		color_list.add("White");
		color_list.add("Black");
		color_list.add("Red");

		// create an empty array sample with an initial capacity
		ArrayList<String> sample = new ArrayList<String>();

		// use add() method to add values in the list
		sample.add("White");
		sample.add("Red");

		// remove all elements from second list if it exists in first list
		color_list.removeAll(sample);

		System.out.println("First List :" + color_list);
		System.out.println("Second List :" + sample);
	}
}