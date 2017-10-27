package com.sh.designpattern.structural.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 源接口，目前提供的可使用的，特定的接口
 * 例如：美国电压只提供110v
 * @author 孙浩
 * @date 2017年10月17日 上午11:58:42
 * @Description 现有的，可被复用的接口
 */
public class Adaptee {

	private static final Logger logger = LoggerFactory.getLogger(Adaptee.class);
	
	public void specificRequest() {
		logger.info("电压提供110v");
	}
}
