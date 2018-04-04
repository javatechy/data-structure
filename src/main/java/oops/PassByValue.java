package oops;

import static utils.Common.*;

class Dog {
	private String name;

	public Dog(String string) {
		this.name = string;
	}

	public String getName() {
		return name;
	}
}

public class PassByValue {
	public static void main(String[] args) {
		Dog aDog = new Dog("Max");
		
		// we pass the object to foo
		println("===== CALLING foo() - name set to Max ======");
		
		foo(aDog);
		
		println("===== after foo()  ======");
		// aDog variable is still pointing to the "Max" dog when foo(...) returns
		println("aDog.getName().equals(\"Max\") => " + aDog.getName().equals("Max")); // true, java passes by value
		println(" aDog.getName().equals(\"Fifi\") =>" + aDog.getName().equals("Fifi")); // false
	}

	public static void foo(Dog d) {
		println("d.getName().equals(\"Max\") => " + d.getName().equals("Max")); // true
		println("change d inside of foo() to point to a new Dog instance \"Fifi\"");
		d = new Dog("Fifi");
		println("d.getName().equals(\"Fifi\") => " + d.getName().equals("Fifi")); // true
	}
}
