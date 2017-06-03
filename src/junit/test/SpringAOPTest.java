package junit.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.amuos.aop.CGlibProxyFactory;
import com.amuos.service.SpringAOPPersonService;
import com.amuos.service.impl.AOPPersonServiceBean;

public class SpringAOPTest {
/*
 * wangjuan 20150922
 * 使用spring内置的AOP切面处理方式
 * xml配置见springaop.xml 使用注解方式
 * 需要定义切面处理类，见SpringInterceptor
 * 异常： error at ::0 can't find referenced pointcut anyMethod
 * 解决：aspectjrt.jar和aspectjweaver换成1.7.4的jar包，查资料是因为jdk1.7以上与aspectj版本不匹配的问题。
 * 输出大概顺序：前置通知、 进入方法、this is save method、最终通知、后置通知、退出方法（可能会略有出入。）
 */
	
	@Test
	public void interceptorTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext("springaop.xml");
		SpringAOPPersonService personService = (SpringAOPPersonService) context.getBean("personService");
		personService.save("yyy");
		personService.save("xxx");
//		personService.getPersonName(null);
	}	
	
/*
 * wangjuan 20150923
 * 使用spring内置的AOP切面处理方式
 * xml配置见springxmlaop.xml 使用xml配置方式
 * 报错：Error creating bean with name 'personService2' defined in class path resource [springxmlaop.xml]
 * 解决办法：将SpringInterceptorXML方法的参数改为无参,或者修改xml配置，在需要参数的切面方法中加入参数arg-names="pjp"，并且在aop:pointcut切点expression加and args(pjp)
 * 参数必须要声明！！！
 */
	@Test
	public void interceptorTest2() {
		ApplicationContext context = new ClassPathXmlApplicationContext("springxmlaop.xml");
		SpringAOPPersonService personService = (SpringAOPPersonService) context.getBean("personService2");
		personService.save("yyy");
		personService.save("xxx");
//		personService.getPersonName(null);
	}	
}
