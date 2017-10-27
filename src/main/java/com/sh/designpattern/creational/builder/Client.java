package com.sh.designpattern.creational.builder;

public class Client {

	public static void main(String[] args) {
		Director director = new Director();
		director.constructPerson(new ConcreteBuilder());
		
		ConcreteBuilder1 cb = new ConcreteBuilder1();
        cb.buildPerson2();
	}
}
