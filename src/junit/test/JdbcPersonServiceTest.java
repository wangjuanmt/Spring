package junit.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.amuos.bean.Person;
import com.amuos.service.JdbcPersonService;
import com.amuos.service.PersonService;

public class JdbcPersonServiceTest {
	private static JdbcPersonService personService;

	@BeforeClass
	public static void setUpBeforeClass(){
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("springjdbc.xml");
			personService = (JdbcPersonService) context.getBean("personService");
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void get(){
		
	}
	
	@Test
	public void save() {
		personService.save(new Person("wangjuan4"));
	}
	
	@Test 
	public void getPerson(){
		Person person = personService.getPerson(1);
		System.out.println(person.getName());
	}
	
	@Test public void update(){
		Person person = personService.getPerson(1);
		person.setName("张xx");
		personService.update(person);
	}
	
	@Test public void delete(){
		personService.delete(4);
	}
	
	@Test public void getBeans(){
		for(Person person : personService.getPersons()){
			System.out.println(person.getName());
		}
	}

}
