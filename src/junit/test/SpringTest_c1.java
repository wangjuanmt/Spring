package junit.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.amuos.service.PersonService;
import com.amuos.service.PersonService_c1;

public class SpringTest_c1 {

	/*
	 * created by wangjuan 20150915
	 */
	@Test
	public void instanceSpring() {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans_c1.xml");
		PersonService personService = (PersonService) context.getBean("personService_c1");
		personService.save();
	}
	
	/*
	 * 测试通过构造器的方法注入
	 * 20150915 wangjuan
	 */
	
	@Test
	public void injectPropertiesTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans_c1.xml");
		PersonService_c1 personService_c1 = (PersonService_c1) context.getBean("personService_c1");
		personService_c1.save();		
		
	}
	
	/*
	 * 测试通过注解@Resource的方法注入
	 * 20150921 wangjuan
	 */
	
	@Test
	public void injectPropertiesTest2(){
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans_c1.xml");
		PersonService_c1 personService_c1 = (PersonService_c1) context.getBean("personService_c1");
		personService_c1.save();		
		
	}

}
