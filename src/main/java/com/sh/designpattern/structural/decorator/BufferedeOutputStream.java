package com.sh.designpattern.structural.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BufferedeOutputStream extends OutputStream {

	private static final Logger logger = LoggerFactory.getLogger(BufferedeOutputStream.class);
	
	private OutputStream out;
	
	public BufferedeOutputStream(OutputStream out) {
		this.out = out;
	}
	
	public void write(int b) {
		logger.info("start buffered");
		
		out.write(b);
	}
}
