package com.sh.designpattern.creational.factorymethod;

public class Client {

	public static void main(String[] args) {
		Factory factory = new BMW320Factoty();
		factory.createBMW();
	}
}
