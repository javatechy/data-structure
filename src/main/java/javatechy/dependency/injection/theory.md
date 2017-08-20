Different Types of Bean Injection in Spring
-----
Overview:
-----
Dependency Injection (DI) or "Inversion of Control(IOC)" is the core feature of  spring. Let's learn about the dependency injection and its types and how we can use it in spring

What's DI?
-----

In simple words, its injection of dependencies.

What's dependecy?
 A Dependencuy is just another object that your class needs to function. and injection is the process of providing those dependencies.
 
 example: Suppose you have a service class that fetches data from Database object , then we can say that Service class has a dependency on Database object
 
 DI means dependency is provided to the class from outside means you dont need to instantiate a dependency from inside the class. Instead you can take it as contructor paramenter or from setter.
 
 Why Do we need it?
 
 It decouples your classes contruction  from the construction of its dependencies.
 
 Depenceny Inversion principle:
 Its states that a code should depened on abstraction(Interfaces). By depending on interfaces we are depcoupling  the implementions.
 By usinfg it  we decouple our code from the lower level implementaions making our code cleaner , easier to modify and easier to reuse.
 
   

Dependency Injection (DI) is a design pattern that implements inversion of control to resolve dependencies.It is the process of providing external dependency to a software component.

DI is a process whereby objects define their dependencies. 


Its a way in which we decouple the conventional dependency relationships between objects.

The container then injects those dependencies, and it creates the bean. This process is named Inversion of Control (IoC) (the bean itself controls the instantiation or location of its dependencies by using direct construction classes or a Service Locator).

Being object-oriented programmers, we tend to create more loosely coupled and reusable beans that make them dependent on each other.
 Spring framework made the availability of those dependencies easy, by inverting the flow of control. We just need to define bean dependencies using different types of bean dependency injections.



Types of Bean Injection in Spring
-----

Spring supports two types of dependency injection:

1) Constructor-based dependency injection: It is accomplished when the container invokes a class constructor with a number of arguments, each representing a dependency on other class.

2) Setter-based dependency injection: It is accomplished by the container calling setter methods on your beans after invoking a no-argument constructor or no-argument static factory method to instantiate your bean.



Let's understand this with an example:

Consider an interface with one method notifyMe():

```java
interface Notifier {
	void notifyMe();
}
```

There are 3 ways of providing the implementation:
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

Only one class DifferenceFinder$1.class is generated for case 2 but no inner class is generated for lambda expression because lambdas are implemented differenly in Java 8
than anaonymouse class. Lambda implementation is based on InvokeDynamic instruction, introduced in Java 7.

* What's **InvokeDynamic**?
It's a big topic but so short answer is: to generate code at runtime. The Java developers chose to
 generate the implementation class at runtime. This is done by calling java.lang.invoke.LambdaMetafactory.metafactory

I won't go  in details lets focus on lambdas only.


Muliple Arguements in Lambdas
-----------------------------
We just saw how you can convert a simple am