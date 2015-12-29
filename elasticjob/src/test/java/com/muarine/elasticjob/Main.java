/* 
 * RT MAP, Home of Professional MAP 
 * Copyright 2015 Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.muarine.elasticjob;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Main.
 * 
 * @author muarine
 * @since 2.1.6
 */
public class Main {
		
	
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		context.start();
		
		
	}

}
