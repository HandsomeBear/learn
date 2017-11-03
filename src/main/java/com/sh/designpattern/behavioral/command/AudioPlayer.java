package com.sh.designpattern.behavioral.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Receiver--具体执行命令的对象
public class AudioPlayer {

	private static final Logger logger = LoggerFactory.getLogger(AudioPlayer.class);
	
	public void play() {
		logger.info("Audio Play...");
	}
	
	public void rewind() {
		logger.info("Audio Rewind...");
	}
	
	public void stop() {
		logger.info("Audio Stop...");
	}
}
