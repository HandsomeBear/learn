package com.sh.designpattern.creational.builder;

public interface Builder {

	void buildHead();
	void buildBody();
	void buildFoot();
	Person buildPerson();
}
