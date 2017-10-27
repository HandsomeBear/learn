package com.sh.designpattern.creational.factorymethod;

public class BMW320Factoty implements Factory{

	@Override
	public BMW createBMW() {
		return new BMW320();
	}

}
