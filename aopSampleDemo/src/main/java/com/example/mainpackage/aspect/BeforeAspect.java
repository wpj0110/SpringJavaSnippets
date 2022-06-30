package com.example.mainpackage.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class BeforeAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//execution(* PACKAGE.*.*(..))
	//the example below is executing a method explicitly with the given path
	@Before("com.example.mainpackage.aspect.CommonJoinPointConfig.dataLayerExecution()") //define which methods to intercept. //this refers to CommonJoinPoint class
	public void before(JoinPoint joinPoint) { //add in details with JoinPoint
		logger.info(" Intercepted Method Calls - {}", joinPoint);
	}

}
