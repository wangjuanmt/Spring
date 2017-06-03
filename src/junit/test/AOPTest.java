package junit.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.amuos.aop.CGlibProxyFactory;
import com.amuos.aop.JDKProxyFactory;
import com.amuos.service.AOPPersonService;
import com.amuos.service.impl.AOPPersonServiceBean;

public class AOPTest {
	/*
	 * 在目标类有接口存在时，实现AOP
	 */
	@Test
	public void proxyTest() {
		JDKProxyFactory factory = new JDKProxyFactory();
		//注意此时是引用的接口
//		AOPPersonService service = (AOPPersonService) factory.createProxyInstance(new AOPPersonServiceBean("yyy"));
		//使用无参构造函数 user=null,而在代理JDKProxyFactory中user!=null才执行回调，否则结果为空，所以此时控制台打印为空
		AOPPersonService service = (AOPPersonService) factory.createProxyInstance(new AOPPersonServiceBean());
		service.save("888");
	}
	
	/*
	 * 在目标类没有接口时，实现AOP
	 */
	@Test
	public void CGlibProxyTest() {
		CGlibProxyFactory factory = new CGlibProxyFactory();
		//注意此时可以引用具体子类
//		AOPPersonServiceBean service = (AOPPersonServiceBean) factory.createProxyInstance(new AOPPersonServiceBean("yyy"));
		//使用无参构造函数 user=null,而在代理JDKProxyFactory中user!=null才执行回调，否则结果为空，所以此时控制台打印为空
		AOPPersonServiceBean service = (AOPPersonServiceBean) factory.createProxyInstance(new AOPPersonServiceBean());
		service.save("888");
	}	

}
