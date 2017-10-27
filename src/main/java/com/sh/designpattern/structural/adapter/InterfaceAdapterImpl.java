package com.sh.designpattern.structural.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InterfaceAdapterImpl extends InterfaceAdapterAbstr{

	private static final Logger logger = LoggerFactory.getLogger(InterfaceAdapterImpl.class);
	
	@Override
	public void request(){
		logger.info("request()");
	}
}
