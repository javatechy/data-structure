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
* **By creating a new class which implements Notifier interface** :
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
	
* **By creating an anonymous class** -- : The compiler generates a class file for each anonymous inner class and the generated class needs to be loaded and at startup.
```java
Notifier emailNotifierAc = new Notifier() {
	@Override
	public void notifyMe() {
		System.out.println("I m anonymous class and notifying you");
	}
};
```
Let's rewrite the above implementation using lambdas.

* **By using lambdas** In this case, there is no need to define the type or declare a new class here . You can directly pass the function .	

```java
Notifier emailNotifierFi = ()-> System.out.println("I m lambda and notifying you");
emailNotifierFi.notifyMe();
```

lets see how many class files are generated after compilation if all the 3 cases are merged into one class (assuming the class name is DifferenceFinder.java):

<p align="center">
  <img src="https://github.com/javatechy/java8/blob/master/src/main/java/javatechy/lambdas/subsitute/output.PNG" alt="output" height="320"/>
</p>

Only one class DifferenceFinder$1.class is generated for case 2 but we were expecting 2 inner class generation here -one for anonymouse inner class
and another class for 


You can directly pass the function	
Lambda implementation is based on InvokeDynamic instruction, introduced in Java 7.
What's InvokeDynamic?
It's a big topic but the short answer is: to generate code in runtime. The Java maintainers chose to
 generate the implementation class in runtime. This is done by calling java.lang.invoke.LambdaMetafactory.metafactory

A lambda works like this:

Generates invokedynamic call site and uses a lambdafactory to return the functional implementation.
Lambda converted to a method to be invoked by invokedynamic.
The method is stored in a class as a private static method.
There are two lambda types. Non-capturing lambdas only use fields inside their bodies, whereas capturing lambdas access fields outside their bodies.


Reference: https://stackoverflow.com/questions/30002380/why-are-java-8-lambdas-invoked-using-invokedynamic