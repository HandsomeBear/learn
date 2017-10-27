package com.sh.designpattern.structural.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CglibSayHello {

	private static final Logger logger = LoggerFactory.getLogger(CglibSayHello.class);
	
	public void say() {
		logger.info("hello everyone");
	}
}
