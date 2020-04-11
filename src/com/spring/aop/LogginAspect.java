/**
 * Gagandeep
 * 12:30:28 am
 * 12-Apr-2020
 */
package com.spring.aop;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Enable loggin on;y in controller, dao and service class
 *
 */
@Aspect
@Component
public class LogginAspect {
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	/**
	 * Pointcut pattern to refer to controller package
	 * @return void
	 */
	@Pointcut("execution(* com.spring.controller.*.*(..))")
	public void forControllerPackage() {}
	/**
	 * Pointcut pattern to refer to dao package
	 * @return void
	 */
	@Pointcut("execution(* com.spring.dao.*.*(..))")
	public void forDaoPackage() {}
	/**
	 * Pointcut pattern to refer to servoice package
	 * @return void
	 */
	@Pointcut("execution(* com.spring.service.*.*(..))")
	public void forServicePackage() {}
	/**
	 * Pointcut method to join all 3 pointcutss
	 * @return void
	 */
	@Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
	public void forAppFlow() {}
	/**
	 * Refering to a point cut from @Before
	 * Display logs for method being entered amd the parameters being passed
	 * @return void
	 */
	@Before("forAppFlow()")
	public void logBefore(JoinPoint point) {
		// Show method name
		System.out.println("@Before: Entering method => " + point.getSignature().toShortString());
		// Show method arguments
		Object args[] = point.getArgs();
		for (Object object : args) {
			System.out.println("Method args =>" + object);
		}
	}
	
	/**
	 * Display logs for the method from which it is returning alogwith return value
	 * @return void
	 */
	@AfterReturning(pointcut = "forAppFlow()", returning = "result")
	public void logAfterReturning(JoinPoint point, Object result) {
		// Show method name
		System.out.println("@AfterReturning: Entering method => " + point.getSignature().toShortString());
		System.out.println("Return value=> " + result);
		
	}

}
