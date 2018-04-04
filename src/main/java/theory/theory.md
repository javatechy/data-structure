# Different Types of Bean Injection in Spring

##Overview:
Dependency Injection (DI) or "Inversion of Control(IOC)" is the core feature of  spring. Let's learn about the dependency injection and its types and how we can use it in spring

Overview:
Dependency Injection (DI) or "Inversion of Control(IOC)" is the core feature of spring. Let's learn about the dependency injection and its types and how we can use it in spring.

## What's DI?

In simple words, its injection of dependencies.

A Dependency is just an object that a class needs to function. and injection is the process of providing those dependencies.
 
example: Suppose you have a service class that fetches data from a Database object, then we can say that Service class has a dependency on the Database object
 
Dependency Injection means dependency is provided to the class from outside means you don't need to instantiate a dependency from inside the class. Instead, you can take it as a constructor parameter or from the setter. DI is based on dependency inversion principle:
 
##### Dependency Inversion principle:
It states that a code should be dependent on abstraction(Interfaces). By depending on interfaces we are decoupling the implementations.By using it we decouple our code from the lower level implementations making our code cleaner, easier to modify and easier to reuse.
 

Dependency Injection (DI) is a design pattern that implements inversion of control to resolve dependencies.It is the process of providing external dependency to a software component.

It's a way in which we decouple the conventional dependency relationships between objects.

The container then injects those dependencies, and it creates the bean. This process is named Inversion of Control (IoC) (the bean itself controls the instantiation or location of its dependencies by using direct construction classes or a Service Locator).

Being object-oriented programmers, we tend to create more loosely coupled and reusable beans that make them dependent on each other.
 Spring framework made the availability of those dependencies easy, by inverting the flow of control. We just need to define bean dependencies using different types of bean dependency injections.

To decouple Java components from other Java components the dependency to a certain other class should get injected into them rather than the class itself creates/finds this object. Class A has a dependency to class B if the class uses class B as a variable.

If dependency injection is used then class B is given to class A via

the constructor of class A - this is then called construction injection

a setter - this is then called setter injection


Types of Bean Injection in Spring
-----

Spring supports two types of dependency injection:

Constructor-based dependency injection: 


It is accomplished when the container invokes a class constructor with a number of arguments, each representing a dependency on other class.

 Spring offers two different ways to define bean dependency injections.

Constructor based injection lets you define bean dependencies via constructor as one or more constructor arguments, which are injected by the container at the time of bean creation. Now let's define a constructor based injection by annotation first:

```java
private EmployeeService employeeService;

@Autowired
public EmployeeController (EmployeeService employeeService){
   this.employeeService = employeeService;

}
```

Here, the @Autowired annotation marked the constructor to be auto-wired, all the arguments are injected by Spring using AutowiredAnnotationBeanPostProcessor.

It is important to note that only one constructor can be marked as auto-wired for any given bean although it doesn’t need to be public.

The @Autowired annotation has one attribute ‘required’, that is by default set to true. If there are multiple arguments in the constructor, all will be required and auto-wired by the container.




* ** Setter-based dependency injection **: It is accomplished by the container calling setter methods on your beans after invoking a no-argument constructor or no-argument static factory method to instantiate your bean.

The other way to define bean dependencies is through property or setter method:

```java
public class Employee {
   //standard setters and getters

   
   ﻿@Autowired
   @Qualifier("officeAddress")
   private Address address;
﻿
}

//or add a setter and mark it autowired
 

 @Autowired
﻿ public void setAddress(Address address) {
    this.address = address;
 }

```

Let's understand this with an example:
Here, we used another annotation @Qualifier, it injects the bean with the given bean name but remains optional. By default, the @Autowired annotation injects the bean dependency by type.


Constructor based injection is recommended to get all the dependencies of a given bean at the time of creation, but mostly constructor based injection is used for the mandatory dependencies and setter-based injection for the optional ones.


@Autowired will tell Spring to search for a Spring bean which implements the required interface and place it automatically into the setter.
