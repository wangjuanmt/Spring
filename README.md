# Spring

Spring is a framework for Inversion of Control (IoC) and Aspect Oriented Programming (AOP).
In this project, we use spring-framework-2.5.6.

### Dependencies
For base use:
 - dist/spring.jar
 - lib/jakarta-commons-logging.jar
 
For additional AOP use:
 - lib/aspectj/aspectjweaver.jar
 - lib/aspectj/aspectjrt.jar
 
For annotation use:
 - lig/j2ee/common-annotations.jar
 
### Basic Steps
1. Import dependencies ( will use maven later).
2. Define spring configuration files, like beans.xml. Under src directory.
In the configuration files, we inject beans. We inject in ways of constructor, setter method or property. And there are three ways of instantiation a bean. Will explain later.
3. Initialize spring container. 
Sample code:
`ApplicationContext context = new ClassPathXmlApplicationContext( new String[] {"beans.xml"});`
After initializing context, we can get bean as
`PersonService personService = (PersonService) context.getBean("personService");`

### Three ways of instantiating a bean in spring configuration files
 - Using a constructor
 - Using a static factory method
 - Using an instance factory method
 
Sample codes:
```xml
<!-- Setting for Instantiation using a constructor -->
    <bean id="personService" class="com.amuos.service.impl.PersonServiceBean" init-method="init" destroy-method="destroy"></bean>
    <!-- scope="prototype" means every time get instance from spring is a new one -->
    <bean id="personService" class="com.amuos.service.impl.PersonServiceBean" scope="prototype"></bean>
<!-- Setting for Instantiation using a static factory method -->
    <bean id="personService2" class="com.amuos.service.impl.PersonServiceBeanFactory" factory-method="createPersonServiceBean"/>
<!-- Setting for Instantiation using an instance factory method -->
    <!-- step1: the factory bean, which contains a method called createInstance() -->
	<bean id="PersonServiceFactory" class="com.amuos.service.impl.PersonServiceBeanFactory"></bean>
	<!-- inject any dependencies required by this locator bean -->
	<!-- step2: the bean to be created via the factory bean -->
	<bean id="personService3" factory-bean="PersonServiceFactory"  factory-method="createPersonServiceBean2" />
```

