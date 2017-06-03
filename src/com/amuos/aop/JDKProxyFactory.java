package com.amuos.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.amuos.service.impl.AOPPersonServiceBean;

public class JDKProxyFactory implements InvocationHandler {
	private Object targetObject;
	
	public Object createProxyInstance(Object targetObject){
		this.targetObject = targetObject;		
		return Proxy.newProxyInstance(this.targetObject.getClass().getClassLoader(), 
									  this.targetObject.getClass().getInterfaces(), this);
	}

	//回调方法：代理拦截住目标对象之后，执行回调。
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		AOPPersonServiceBean bean = (AOPPersonServiceBean)this.targetObject;
		Object result = null;
		//条件目前是按照user是否为空来判断,可在具体应用中的权限设置
		if(bean.getUser() != null){
			result = method.invoke(targetObject, args);
		}
		return result;
	}

}
