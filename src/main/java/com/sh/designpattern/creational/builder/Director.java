package com.sh.designpattern.creational.builder;

public class Director {

	public Person constructPerson(Builder builder) {
		builder.buildHead();
		builder.buildBody();
		builder.buildFoot();
		
		return builder.buildPerson();
	}
}
