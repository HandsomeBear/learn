package com.sh.designpattern.structural;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sh.designpattern.structural.adapter.Adaptee;
import com.sh.designpattern.structural.adapter.Adapter;
import com.sh.designpattern.structural.adapter.ConcreteTarget;
import com.sh.designpattern.structural.adapter.InterfaceAdapter;
import com.sh.designpattern.structural.adapter.InterfaceAdapterImpl;
import com.sh.designpattern.structural.adapter.ObjectAdapter;
import com.sh.designpattern.structural.adapter.Target;

public class AdapterTest {

	private static final Logger logger = LoggerFactory.getLogger(AdapterTest.class);
	
	/**
	 * 普通功能测试
	 * @author 孙浩
	 * @date 2017年10月17日 下午1:53:26
	 */
	@Test
	public void testAbnormalAdapter() {
		logger.info("test Abnormal");
		
		Target target = new ConcreteTarget();
		target.request();
	}
	
	/**
	 * 类适配器
	 * @author 孙浩
	 * @date 2017年10月17日 下午1:52:19
	 */
	@Test
	public void testClassAdapter() {
		logger.info("test Class Adapter");
		
		Target target = new Adapter();
		target.request();
	}
	
	/**
	 * 对象适配器
	 * @author 孙浩
	 * @date 2017年10月17日 下午1:55:10
	 */
	@Test
	public void testObjectAdapter() {
		logger.info("test Object Adapter");
		
		Target target = new ObjectAdapter(new Adaptee());
		target.request();
	}
	
	/**
	 * 接口适配器
	 * @author 孙浩
	 * @date 2017年10月17日 下午2:08:09
	 * @Description:
	 */
	@Test
	public void testInterfaceAdapter() {
		logger.info("test Interface Adapter");
		
		InterfaceAdapter target = new InterfaceAdapterImpl();
		target.request1();
		target.request();
		target.request2();
	}
}
