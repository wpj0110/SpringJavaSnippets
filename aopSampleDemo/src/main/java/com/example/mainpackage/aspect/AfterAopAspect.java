package com.example.mainpackage.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterAopAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//execution(* PACKAGE.*.*(..))
	@AfterReturning( //check the declaration to see what possible values to get! //@AfterReturning happens after a successful call
			
			value="execution(* com.example.mainpackage.business.*.*(..))", //define which methods to intercept
			returning="result" //result is mapped to "Object result" in the "afterReturning" method
			) 
	public void afterReturning(JoinPoint joinPoint, Object result) { //add in details with JoinPoint
		logger.info(" Check for user access ");
		logger.info(" {} returned with value {}", joinPoint, result);
	}
	
	@AfterThrowing( //if there is an error
			value="execution(* com.example.mainpackage.business.*.*(..))", //define which methods to intercept
			throwing="exception" //result is mapped to "Object result" in the "afterReturning" method
			) 
	public void afterThrowing(JoinPoint joinPoint, Exception exception) { //add in details with JoinPoint
		logger.info(" {} throw exception {}", joinPoint, exception);
	}
	
	@After( //if there is an error //this comes after everything....
			value="execution(* com.example.mainpackage.business.*.*(..))" //define which methods to intercept
			) 
	public void afterThrowing(JoinPoint joinPoint) { //add in details with JoinPoint
		logger.info(" after execution of {}", joinPoint);
	}

}
