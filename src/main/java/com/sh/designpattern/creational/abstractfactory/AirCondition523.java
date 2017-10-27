package com.sh.designpattern.creational.abstractfactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AirCondition523 extends AirCondition{

	private static final Logger logger = LoggerFactory.getLogger(AirCondition523.class);
	
	public AirCondition523 () {
		logger.info("制造-->AirCondition523");
	}
}
