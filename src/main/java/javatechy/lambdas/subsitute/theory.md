Lambdas - An option to anonymous classes
-----

Lambdas are not just syntactical sugar in java. They do few other things as well.
Lambdas functions can be passed to any other fuction just as an arguement.Java 8 is a big step forward in making the world's most popular language adopt
the functional style of programming. 
To support a functional programming style,
writing a clean functional style code was not possible without the use of an
anonymous inner class boilerplate. With the introduction of Lambda expressions,
functions have become first class citizens and they can be passed around just
like any other variable.

Let's understand this with an example:

Consider an interface with one method notifyMe():

```java
interface Notifier {
	void notifyMe();
}
```

There are 3 ways of providing the implementation:
Prior to Java 8:
* **variable** -- By creating a new class which implements Notifier interface
```java
class EmailNotifier implements Notifier{
	@Override
	public void notifyMe() {
		System.out.println("I m in EmailNotifier notifying your for the mails");
	}
}
```
and then call it like this:

```java
Notifier emailNotifier = new EmailNotifier();
emailNotifier.notifyMe();
```
	
* **By creating an anonymous class** -- :

```java
Notifier emailNotifierAc = new Notifier() {
	@Override
	public void notifyMe() {
		System.out.println("I m anonymous class and notifying you");
	}
};
```

* **By using lambdas** -- 	

```java
Notifier emailNotifierFi = ()-> System.out.println("I m lambda and notifying you");
emailNotifierFi.notifyMe();
```

lets see how many class files are generatered after compilation if all the 3 cases are merged into one class (assuming the class name is DifferenceFinder.java):

<p align="center">
  <img src="https://github.com/javatechy/java8/blob/master/src/main/java/javatechy/lambdas/subsitute/output.PNG" alt="output" height="320"/>
</p>
