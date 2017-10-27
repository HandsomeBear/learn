package com.sh.designpattern.structural.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EncryOutputStream extends OutputStream {

	private static final Logger logger = LoggerFactory.getLogger(EncryOutputStream.class);
	
	private OutputStream out;
	
	public EncryOutputStream(OutputStream out) {
		this.out = out;
	}
	
	public void write(int b) {
		logger.info("start encry");
		
		out.write(b);
	}
}
