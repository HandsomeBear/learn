package com.sh.designpattern.creational.abstractfactory;

public class Client {

	public static void main(String[] args) {
		AbstractFactory factory = new FactoryBMW320();
        factory.createEngine();
        factory.createAirCondition();
	}
}
