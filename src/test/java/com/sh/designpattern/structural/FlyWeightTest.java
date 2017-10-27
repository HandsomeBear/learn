package com.sh.designpattern.structural;

import org.junit.Test;

import com.sh.designpattern.structural.flyweight.FlyWeight;
import com.sh.designpattern.structural.flyweight.FlyWeightFactory;

public class FlyWeightTest {

	@Test
	public void testGetFlyWeight(){
		FlyWeight flyWeight = FlyWeightFactory.getFlyWeight("test");
		flyWeight.action("123");
		
		FlyWeight flyWeight1 = FlyWeightFactory.getFlyWeight("test");
		flyWeight1.action("456");
	}
}
