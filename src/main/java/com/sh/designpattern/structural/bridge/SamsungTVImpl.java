package com.sh.designpattern.structural.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Samsung电视
 * @author 孙浩
 * @date 2017年10月17日 下午2:32:06
 */
public class SamsungTVImpl implements ITV {

	private static final Logger logger = LoggerFactory.getLogger(SamsungTVImpl.class);
	
	@Override
	public void on() {
		logger.info("SamsungTV ON");
	}

	@Override
	public void off() {
		logger.info("SamsungTV OFF");
	}

	@Override
	public void switchChannel(int channel) {
		logger.info("Samsung Channel:"+channel);
	}

}
