package com.sh.designpattern.structural.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SayHelloImpl implements ISayHello{

	private static final Logger logger = LoggerFactory.getLogger(SayHelloImpl.class);
	
	@Override
	public void say() {
		logger.info("Hello EveryOne");
	}
}
