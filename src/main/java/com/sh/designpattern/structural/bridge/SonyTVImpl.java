package com.sh.designpattern.structural.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 * 索尼电视
 * @author 孙浩
 * @date 2017年10月17日 下午2:42:25
 */
public class SonyTVImpl implements ITV {

	private static final Logger logger = LoggerFactory.getLogger(SonyTVImpl.class);
	
	@Override
	public void on() {
		logger.info("SonyTV ON");
	}

	@Override
	public void off() {
		logger.info("SonyTV OFF");
	}

	@Override
	public void switchChannel(int channel) {
		logger.info("Sony Channel:"+channel);
	}

}
