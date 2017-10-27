package com.sh.designpattern.creational.simplefactory;

public class Client {

	public static void main(String[] args) {
		Factory factory = new Factory();
		BMW bmw320 = factory.createBMW(320);
		System.out.println(bmw320.toString());
	}
}
