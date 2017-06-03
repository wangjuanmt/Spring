package junit.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.amuos.service.PersonService;

public class SpringTest {

	/*
	 * 3 methods for Instantiation, mostly using method 1
	 */
	@Test
	public void instanceSpring() {
//		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		//method 1: Instantiation using a constructor
//		PersonService personService = (PersonService) context.getBean("personService");
		//method 2: Instantiation using a static factory method
//		PersonService personService = (PersonService) context.getBean("personService2");
		//method 3: Instantiation using an instance factory method
//		PersonService personService = (PersonService) context.getBean("personService3");
		
		//bean未加scope="prototype"时，打印为true;加了scope="prototype"时,打印为false，每次实例都是不一样的。
//		PersonService personService1 = (PersonService) context.getBean("personService");
//		PersonService personService2 = (PersonService) context.getBean("personService");
//		System.out.println(personService1==personService2);
		
		//to verify when to call construction 
		//bean未加scope="prototype"时，调用了构造函数，实例化成功，实例化是在spring容器实例化时，bean也同样做了实例化;
		//加了scope="prototype"时,未调用构造函数，未实例化。实例化不成功。
//		PersonService personService = (PersonService) context.getBean("personService");
		
		//use AbstractApplicationContext, to call close() method
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		context.close();
	}
	
	/*
	 * 测试通过属性的setter方法注入
	 * 20150914 wangjuan
	 */
	
	@Test
	//属性注入的测试
	public void injectPropertiesTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		PersonService personService = (PersonService) context.getBean("personService");
		personService.save();
		//遍历，取集合 Set
		System.out.println("==================Set==================");
		for(String person: personService.getSets()){
			System.out.println(person);
		}
		//遍历，取集合 List
		System.out.println("==================List==================");
		for(String person: personService.getLists()){
			System.out.println(person);
		}
		//遍历，取集合 Properties
		System.out.println("==================Properties==================");
		for(Object key: personService.getProperties().keySet()){
			System.out.println(key + "=" + personService.getProperties().getProperty((String) key));
		}
		//遍历，取集合 Map
		System.out.println("==================Map==================");
		for(Object key: personService.getMaps().keySet()){
			System.out.println(key + "=" + personService.getMaps().get(key));
		}		
		
	}

}
