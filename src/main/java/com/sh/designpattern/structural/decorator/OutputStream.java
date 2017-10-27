package com.sh.designpattern.structural.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class OutputStream {

	private static final Logger logger = LoggerFactory.getLogger(OutputStream.class);
	
	public void write(int b) {
		logger.info("write byte counts: " + b);
	}
}
