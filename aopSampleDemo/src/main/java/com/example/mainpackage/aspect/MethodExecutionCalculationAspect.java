package com.example.mainpackage.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MethodExecutionCalculationAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//execution(* PACKAGE.*.*(..))
	@Around( //check the declaration to see what possible values to get! //@AfterReturning happens after a successful call
			value="execution(* com.example.mainpackage.business.*.*(..))"
			) 
	public void around(ProceedingJoinPoint joinPoint) throws Throwable { 
		long startTime = System.currentTimeMillis(); //before the execution of the business package, this is done.
		logger.info("beginning execution...");
		joinPoint.proceed();
		logger.info("after execution...");
		long timeTaken = System.currentTimeMillis() - startTime; //after the execution of the business package, this is done.
		//startTime = x
		//allow execution of method
		//end Time = y
		
		logger.info(" Time Taken by {} is {}", joinPoint, timeTaken);
	}
}
