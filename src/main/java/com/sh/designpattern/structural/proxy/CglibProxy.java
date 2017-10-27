package com.sh.designpattern.structural.proxy;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor{

	private static final Logger logger = LoggerFactory.getLogger(CglibProxy.class);
	
	private Enhancer enhancer = new Enhancer();
	
	@SuppressWarnings("rawtypes")
	public Object getProxy(Class clazz) {
		//设置需要创建的子类
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);
		//通过字节码技术动态创建子类实例
		return enhancer.create();
	}
	
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		logger.info("前置代理");
		//通过代理类调用父类中的方法
		Object result = proxy.invokeSuper(obj, args);
		
		logger.info("后置代理");
		
		return result;
	}

	
}
