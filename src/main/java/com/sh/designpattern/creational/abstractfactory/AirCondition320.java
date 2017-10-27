package com.sh.designpattern.creational.abstractfactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AirCondition320 extends AirCondition{

	private static final Logger logger = LoggerFactory.getLogger(AirCondition320.class);
	
	public AirCondition320 () {
		logger.info("制造-->AirCondition320");
	}
}
