package com.amuos.aop;

import java.lang.reflect.Method;

import com.amuos.service.impl.AOPPersonServiceBean;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGlibProxyFactory implements MethodInterceptor {
	private Object targetObject;
	
	public Object createProxyInstance(Object targetObject){
		this.targetObject = targetObject;
		//使用Enhance创建代理类
		Enhancer enhance = new Enhancer();
		//设置父类。从目标类继承。
		enhance.setSuperclass(this.targetObject.getClass());//非final方法均继承过来
		//当代理对象被执行时，执行回调
		enhance.setCallback(this);
		//返回创建的代理类
		return enhance.create();
	}

	@Override
	public Object intercept(Object proxy, Method method, Object[] args,
			MethodProxy methodProxy) throws Throwable {
		AOPPersonServiceBean bean = (AOPPersonServiceBean)this.targetObject;
		Object result = null;		
		if(bean.getUser() != null){
			result = methodProxy.invoke(targetObject, args);
		}
		return result;
	}
}
