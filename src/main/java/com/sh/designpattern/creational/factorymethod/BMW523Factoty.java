package com.sh.designpattern.creational.factorymethod;

public class BMW523Factoty implements Factory{

	@Override
	public BMW createBMW() {
		return new BMW523();
	}

}
