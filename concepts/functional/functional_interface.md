# Functional Interface


#### Types of interface :

1. Normal : more than one method
2. Single abstract Method  :  exactly one method - FunctionalInterface - use in   lambda (adopted in scala) 
3. Marker Interface :  No method eg. serializable.


**Note:** function interface can have multiple default methods and static methods(eg. Static MethodDemo.java).


#### Default Method in interface: 

In abstract class -  we can define and declare a method.
in interface -  we can only declare a method - java 7
in interface -  we can define and declare a method. - java 8

We are not alloweed to update the interaface  or add a method.

Default method can also be overridden.


# Multiple Inhertience issue with interfaces:

If a class  is implementing 2 interfaces having same default methods it leads to a Multiple Inhertience issue.
In this case class has to give the implementation of common method. example =  MultipleInhertienceProblemDemo.java


What if you want to choose one of the implementation
use something like this  INterfaceName.super.commmon_method()


### Static  method in interface 

eg. Static MethodDemo.java).
```
Demo1.show();
```

### variables in Interface:

 Must intialize the variables.
 Final by default check Static MethodDemo.java

## Refernce:

- https://www.youtube.com/watch?v=lhSx1HWaMDw&list=PLsyeobzWxl7pFZoGT1NbZJpywedeyzyaf&index=40
- https://www.youtube.com/watch?v=Swzy7cirX2U&index=41&list=PLsyeobzWxl7pFZoGT1NbZJpywedeyzyaf
-https://www.youtube.com/watch?v=REA5X7uVhHk&list=PLsyeobzWxl7pFZoGT1NbZJpywedeyzyaf&index=43
