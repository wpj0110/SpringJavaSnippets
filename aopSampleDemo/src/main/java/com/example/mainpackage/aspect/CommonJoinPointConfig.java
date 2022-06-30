package com.example.mainpackage.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {
	
	//the purpose of this class is to put all the JoinPoint in one file. Good practice for Spring AOP
	
	@Pointcut("execution(* com.example.mainpackage.data.*.*(..))") //will be referred by 
	public void dataLayerExecution() {
		
	}

}
