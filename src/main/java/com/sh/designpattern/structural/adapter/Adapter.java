package com.sh.designpattern.structural.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 适配器
 * @author 孙浩
 * @date 2017年10月17日 下午1:38:57
 * @Description <b>用于需要使用某个现成的类，但是又不符合我们自己的接口</b>
 */
public class Adapter extends Adaptee implements Target {

	private static final Logger logger = LoggerFactory.getLogger(Adapter.class);
	
	@Override
	public void request() {
		logger.info("重用的适配功能");
		specificRequest();
	}
}
