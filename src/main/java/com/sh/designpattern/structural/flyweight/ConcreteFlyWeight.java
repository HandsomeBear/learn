package com.sh.designpattern.structural.flyweight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConcreteFlyWeight implements FlyWeight {

	private static final Logger logger = LoggerFactory.getLogger(ConcreteFlyWeight.class);
	
	private String name;//内部状态
	
	public ConcreteFlyWeight(String name) {
		this.name = name;
	}
	
	@Override
	public void action(String externalState) {
		logger.info(name+"--->"+externalState);
	}

}
