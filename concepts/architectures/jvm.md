# JVM Memory Model: 

![image](https://cdn.journaldev.com/wp-content/uploads/2014/05/Java-Memory-Model-450x186.png)


JVM Heap memory is physically divided into two parts – **Young Generation** and **Old Generation**

## Young Generation

+ Young generation is the place where all the new objects are created.
+ When young generation is filled, garbage collection is performed. This garbage collection is called **Minor GC**. 

Young Generation is divided into three parts – **Eden Memory** and two **Survivor Memory** spaces.


#### Important Points about Young Generation Spaces:

+ Most of the newly created objects are located in the Eden memory space.
+ When Eden space is filled with objects, Minor GC is performed and all the survivor objects are moved to one of the survivor spaces.
+ Minor GC also **checks the survivor objects** and **move them** to the other **survivor space**. So at a time, one of the survivor space is always empty. **Objects that are survived after many cycles** of GC, are **moved to the Old** generation memory space.
+ Usually it’s done by setting a threshold for the age of the young generation objects before they **become eligible to promote to Old generation.**


## Old Generation
Old Generation memory contains the objects that are **long lived** and survived after many rounds of Minor GC. 
+ **GC is performed in Old Generation memory when it’s full**.
+ Old Generation Garbage Collection is called **Major GC** and usually takes longer time.

## Method Area
+ Method Area is **part of space in the Perm Gen**
+ used to store class structure (runtime constants and static variables) and code for methods and constructors.

## Memory Pool

+ Memory Pools are created by JVM memory managers to create a pool of immutable objects, if implementation supports it. String Pool is a good example of this kind of memory pool. Memory Pool can **belong to Heap or Perm Gen**, depending on the JVM memory manager implementation.


## Runtime Constant Pool
+ Runtime constant pool is per-class runtime representation of constant pool in a class. 
+ It contains class runtime constants and static methods. 
+ Runtime constant pool is the part of method area.


## Java Stack Memory
Java Stack memory is used for **execution of a thread**. They contain method specific values that are short-lived and references to other objects in the heap that are getting referred from the method

#### Java Heap Space
+ Java Heap space is used by java runtime to allocate memory to Objects and JRE classes.
+ Whenever we create any object, it’s always created in the Heap space.
+ Garbage Collection runs on the heap memory to free the memory used by objects that doesn’t have any reference. Any object created in the heap space has global access and can be referenced from anywhere of the application.

#### Java Stack Memory
+ Java Stack memory is used for execution of a thread. 
+ They contain method specific values that are short-lived and references to other objects in the heap that are getting referred from the method.


## Memory Management in Java – Java Heap Memory Switches
Java provides a lot of memory switches that we can use to set the memory sizes and their ratios. Some of the commonly used memory switches are:

#### VM SWITCH
+ -Xms	 : For setting the initial heap size when JVM starts
+ -Xmx	 : For setting the maximum heap size.
+ -Xmn	 : For setting the size of the Young Generation, rest of the space goes for Old Generation.
+ -XX:PermGen	: For setting the initial size of the Permanent Generation memory
+ -XX:MaxPermGen	: For setting the maximum size of Perm Gen
+ -XX:SurvivorRatio:	For providing ratio of Eden space and Survivor Space, for example if Young Generation size is 10m and VM switch is -
+ -XX:SurvivorRatio=2 then 5m will be reserved for Eden Space and 2.5m each for both the Survivor spaces. The default value is 8.
+ XX:NewRatio: 	For providing ratio of old/new generation sizes. The default value is 2.





Refernce:
https://www.journaldev.com/2856/java-jvm-memory-model-memory-management-in-java

