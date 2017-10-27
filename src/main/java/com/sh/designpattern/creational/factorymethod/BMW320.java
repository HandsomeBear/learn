package com.sh.designpattern.creational.factorymethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BMW320 extends BMW{

	private static final Logger logger = LoggerFactory.getLogger(BMW320.class);
	
	public BMW320() {
		logger.info("制造-->BMW320");
	}
}
