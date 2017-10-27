package com.sh.designpattern.structural.flyweight;

import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlyWeightFactory {

	private static final Logger logger = LoggerFactory.getLogger(FlyWeightFactory.class);
	
	private static ConcurrentHashMap<String, FlyWeight> allFlyWeight = new ConcurrentHashMap<String, FlyWeight>();
	
	public static FlyWeight getFlyWeight(String name) {
		if(allFlyWeight.get(name) == null){
			synchronized(allFlyWeight){
				logger.info("Start create FlyWeight--->"+name);
				if(allFlyWeight.get(name) == null){
					FlyWeight flyWeight = new ConcreteFlyWeight(name);
					allFlyWeight.put(name, flyWeight);
				}
			}
		}
		return allFlyWeight.get(name);
	}
}
