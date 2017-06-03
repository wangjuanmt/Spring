package com.amuos.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.amuos.service.impl.AOPPersonServiceBean;
import com.amuos.service.impl.SpringAOPPersonServiceBean;
/*
 * 使用xml配置来声明切面。不需要加注释。该类需要交给spring管理
 */

public class SpringInterceptorXML {

//	private void anyMethod(){}

	public void doAccessCheck(){
		System.out.println("前置通知");
	}
	
	public void doAfterReturning(){
		System.out.println("后置通知 ");
	}
	
	public void doAfter(){
		System.out.println("最终通知");
	}
	
	public void doAfterThrowing(){
		System.out.println("例外通知");
	}

	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable{
		Object result = null;
			System.out.println("进入方法");
			result = pjp.proceed();
			System.out.println("退出方法");
		return result;
	}
}
