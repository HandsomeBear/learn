package com.sh.designpattern.structural.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProxyHandler implements InvocationHandler{

	private static final Logger logger = LoggerFactory.getLogger(ProxyHandler.class);
	
	private ISayHello target;
	
	public ProxyHandler(ISayHello target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		logger.info("前置通知");
		Object result = method.invoke(target, args);
		logger.info("后置通知");
		
		return result;
	}

}
