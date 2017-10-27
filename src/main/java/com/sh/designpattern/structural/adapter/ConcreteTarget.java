package com.sh.designpattern.structural.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 具体可供使用的目标，只具有普通功能
 * @author 孙浩
 * @date 2017年10月17日 下午1:45:41
 */
public class ConcreteTarget implements Target{

	private static final Logger logger = LoggerFactory.getLogger(ConcreteTarget.class);
	
	@Override
	public void request() {
		logger.info("普通的目标功能");
	}
}
