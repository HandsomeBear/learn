package com.sh.designpattern.creational.abstractfactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Engine320 extends Engine{

	private static final Logger logger = LoggerFactory.getLogger(Engine320.class);
	
	public Engine320 () {
		logger.info("制造-->引擎320");
	}
}
