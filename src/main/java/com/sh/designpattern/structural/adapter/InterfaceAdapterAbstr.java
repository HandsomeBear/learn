package com.sh.designpattern.structural.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 接口适配器
 * @author 孙浩
 * @date 2017年10月17日 下午2:02:36
 */
public abstract class InterfaceAdapterAbstr implements InterfaceAdapter{

	private static final Logger logger = LoggerFactory.getLogger(InterfaceAdapterAbstr.class);
	
	@Override
	public void request(){}
	
	@Override
	public void request1(){
		logger.info("request1 default impl");
	}
	
	@Override
	public void request2(){
		logger.info("request2 default impl");
	}
}
