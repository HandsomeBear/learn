package com.sh.designpattern.structural;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

import org.junit.Test;

import com.sh.designpattern.structural.proxy.CglibProxy;
import com.sh.designpattern.structural.proxy.CglibSayHello;
import com.sh.designpattern.structural.proxy.ISayHello;
import com.sh.designpattern.structural.proxy.ProxyHandler;
import com.sh.designpattern.structural.proxy.SayHelloImpl;

public class ProxyTest {

	@Test
	public void testCGlib() {
		CglibProxy proxy = new CglibProxy();
		CglibSayHello proxyImpl = (CglibSayHello) proxy.getProxy(CglibSayHello.class);
		proxyImpl.say();
	}

	@Test
	public void testDynamicProxy() {
//		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

		ISayHello proxy = (ISayHello)Proxy.newProxyInstance(ISayHello.class.getClassLoader(), new Class[] { ISayHello.class },
				new ProxyHandler(new SayHelloImpl()));
		
		proxy.say();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testDynamicProxy2() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

		//1.获取动态代理类
        Class proxyClazz = Proxy.getProxyClass(ISayHello.class.getClassLoader(),ISayHello.class);
        //2.获得代理类的构造函数，并传入参数类型InvocationHandler.class
        Constructor constructor = proxyClazz.getConstructor(InvocationHandler.class);
        //3.通过构造函数来创建动态代理对象，将自定义的InvocationHandler实例传入
        ISayHello iHello = (ISayHello) constructor.newInstance(new ProxyHandler(new SayHelloImpl()));
        //4.通过代理对象调用目标方法
        iHello.say();
	}
}
