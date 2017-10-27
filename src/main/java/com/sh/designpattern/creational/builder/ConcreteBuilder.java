package com.sh.designpattern.creational.builder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConcreteBuilder implements Builder {

	private static final Logger logger = LoggerFactory.getLogger(ConcreteBuilder.class);
	
	Person person;
	
	public ConcreteBuilder() {
		person = new Person();
	}
	
	@Override
	public void buildHead() {
		logger.info("开始构建Head");
	}

	@Override
	public void buildBody() {
		logger.info("开始构建Body");
	}

	@Override
	public void buildFoot() {
		logger.info("开始构建Foot");
	}

	@Override
	public Person buildPerson() {
		return person;
	}

}
