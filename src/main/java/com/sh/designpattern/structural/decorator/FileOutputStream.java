package com.sh.designpattern.structural.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileOutputStream extends OutputStream{

	private static final Logger logger = LoggerFactory.getLogger(FileOutputStream.class);
	
	public void write(int b) {
		logger.info("File write.......");
	}
}
