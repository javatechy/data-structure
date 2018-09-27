package anonymous;

class Parent {

	public void show() {
		System.out.println("Hellp");
	}

}

class Child extends Parent {

	public void show() {
		System.out.println("in child");
	}

}

public class AnonymousSample {

	public static void main(String arrp[]) {

		Parent a = new Parent();
		a.show();
		Parent b = new Child();
		b.show();

		Parent anon = new Parent() {
			@Override
			public void show() {
				System.out.println("in annonympus child child");
			}
		};
		anon.show();
	}
}
