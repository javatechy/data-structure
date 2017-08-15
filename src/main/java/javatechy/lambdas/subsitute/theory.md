Lambdas - An option to abstract classes
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
