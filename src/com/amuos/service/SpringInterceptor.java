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
 * 使用注解@Aspect来声明该类是个切面类
 */
@Aspect
public class SpringInterceptor {
/*定义切入点
 * 第一个*表示返回值类型（*代表返回值为任意类型）
 * com.amuos.service表示要拦截的包名
 * ..表示对包下的子包也要拦截
 * 第二个*表示拦截哪个类（*代表所有类）
 * 第三个*表示拦截哪个方法（*代表所有方法）
 * (..)表示这个方法的参数可任意，有无均可
 * 定义完成之后注意要交给spring管理。可以使用xml配置文件，或者使用注解方式。
 * 这里使用xml配置
 */
//@Pointcut("execution(* com.amuos.service..*.*(..))") 
//对类SpringAOPPersonServiceBean中的所有方法拦截
	@Pointcut("execution(* com.amuos.service.impl.SpringAOPPersonServiceBean.*(..))")
	//给这个切入点定义一个名称（以方法命名）
	private void anyMethod(){}
	//定义前置通知，括号里填写要拦截的方法。先执行Before语句，然后再执行被拦截的方法。注意参数的处理。
	@Before("anyMethod() && args(userName)")
	public void doAccessCheck(String userName){
//	@Before("anyMethod()")
//	public void doAccessCheck(){
		System.out.println("前置通知：" + userName);
	}
	@AfterReturning(pointcut="anyMethod()",returning="result")
	public void doAfterReturning(String result){
		System.out.println("后置通知 : " + result);
	}
	
	@After("anyMethod()")
	public void doAfter(){
		System.out.println("最终通知");
	}
	
	@AfterThrowing(pointcut="anyMethod()",throwing="e")
	public void doAfterThrowing(Exception e){
		System.out.println("例外通知: " + e);
	}
	//在环绕通知里最容易来做权限判断
	@Around("anyMethod() && args(userName)")
	public Object doBasicProfiling(ProceedingJoinPoint pjp, String userName) throws Throwable{
		Object result = null;
		if(userName == "xxx"){
			System.out.println("进入方法");
			result = pjp.proceed();
			System.out.println("退出方法");
		}
		return result;
	}
}
