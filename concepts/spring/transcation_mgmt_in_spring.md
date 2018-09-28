# Transaction management in spring

![image](https://cdn.journaldev.com/wp-content/uploads/2017/11/spring-framework-architecture.jpg)


## Core 

The Core container from Spring consists of four modules: SpEL , Context, Core, Beans. Description for these elements are as follows:


+ SpEL module :  for powerful expression language for manipulating objects during execution.
+ Context : allows you to access any object that is defined in the settings. 
+ Core : for IoC and DI properties.
+ Bean : responsible for creating and managing Spring Beans – is application context structure unit.

## Spring Framework Web

+ provides functions such as downloading files, creating web application, rest web service etc
+ Web -mVC :  provides MVC functionality
+ Web-Portlet : MVC implementation with portlet environment
+ Web-Socket:  provides support for communication between the client and the server, using Web-Sockets in web applications.

## Spring Framework Data Access
The Data Access/Integration container consists of JDBC, ORM, OXM, JMS and the Transactions module.

+ JDBC:  avoids database config and running overheads.
+ ORM:  provides integration with such popular ORMs as Hibernate,JPA, etc.
+ OXM module:  is responsible for linking the Object / XML – XMLBeans, JAXB, etc.
+ JMS (Java Messaging Service) : module is responsible for creating, sending and receiving messages.
+ **Transactions** : supports transaction management for classes that implement certain methods and POJOs.

## Others:

+ AOP : for AOP capbilites
+ Aspects: The Aspects module provides integration with AspectJ, which is also a powerful AOP framework.
+ Instrumentation : for supporting class instrumentation and class loader, which are used in server applications.
+ Messaging module : provides STOMP support.
+ Test module : provides testing using TestNG or the JUnit Framework.


REfs:
+ https://www.journaldev.com/16922/spring-framework
