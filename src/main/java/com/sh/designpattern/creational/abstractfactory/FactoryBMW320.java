package com.sh.designpattern.creational.abstractfactory;

public class FactoryBMW320 implements AbstractFactory {

	@Override
	public Engine createEngine() {
		return new Engine320();
	}

	@Override
	public AirCondition createAirCondition() {
		return new AirCondition320();
	}

}
