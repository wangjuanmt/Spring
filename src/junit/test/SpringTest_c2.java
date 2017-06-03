package junit.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.amuos.dao.PersonDao_c2;
import com.amuos.service.PersonService;
import com.amuos.service.PersonService_c1;
import com.amuos.service.PersonService_c2;

public class SpringTest_c2 {

	
	
	/*
	 * 测试通过自动扫描classpath下的组件的方法注入
	 * 见beans_c2.xml
	 * PersonDaoBean_c2加@Repository注解
	 * PersonServiceBean_c2加@Service注解
	 * 20150921 wangjuan
	 */
	
	@Test
	public void injectPropertiesTest2(){
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans_c2.xml");
		//@Service类的名称首字母改小写，即为getBean的参数，即bean名称;也可以在@Service后加括号指定名称
//		PersonService_c2 personService_c2 = (PersonService_c2) context.getBean("personServiceBean_c2");
		PersonService_c2 personService_c2 = (PersonService_c2) context.getBean("personServiceBean");
		PersonDao_c2 personDao_c2 = (PersonDao_c2) context.getBean("personDaoBean_c2");
		System.out.println(personService_c2);
		System.out.println(personDao_c2);
//		personService_c2.save();
		context.close();
	}

}
