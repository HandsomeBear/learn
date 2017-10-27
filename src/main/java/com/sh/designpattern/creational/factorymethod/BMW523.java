package com.sh.designpattern.creational.factorymethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BMW523 extends BMW{

	private static final Logger logger = LoggerFactory.getLogger(BMW523.class);
	
	public BMW523() {
		logger.info("制造-->BMW523");
	}
}
