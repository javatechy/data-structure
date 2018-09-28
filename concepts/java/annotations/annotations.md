# Annotions

- Restricts a user to use any metthod like @Deprected
- Doesn't allow to create another method in functional intereface;
 - All annotions you create is always subclass of `java.lang.annotation.Annotation`
 - Always specify targets using @Target over your custom annotaion.
 	- Use ElementType.TYPE for class
 	- Use ElementType.METHOD for methods
 	- Use ElementType.CONSTRUCTOR for constructors
 	- Use ElementType.FIELD for fields
 - Always specify retention policy using @Retention over your custom annotaion.
 	- Use RententoinPolicy.RUNTIME for runntime usage
 	- Use RententoinPolicy.SOURCE for compile time usage
 	- Use RententoinPolicy.CLASS for class level usage
 	- also called as meta annotaions
 - Use @Documented Indicates that annotations with a type are to be documented by javadoc and similar tools by default
 - Use @Inherited : if you want the same annotaiton to be available for child classes.

 
 
 	

### Types of annotaions

- Marker Annotation : with no methods
- Single Value annotations :  When u have a single value annotation
- Multi Value annotations :  When u have a Multiple value annotation

### default keyword 
- You can specefy default field value using `default` keyworkd in custom annotaion.check CustomAnnotation.java

### Using custom annotaions - getting annotion values

-   


## Refernce:

- https://www.youtube.com/watch?v=rWlHQnvrZcw&list=PLsyeobzWxl7rGC3gHSbs26-bzmPqUW-ez&index=2
