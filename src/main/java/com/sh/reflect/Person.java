package com.sh.reflect;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Person extends Creature implements ISpeakListener,Serializable{

	private static final Logger logger = LoggerFactory.getLogger(Person.class);
	
	private String name;
	private int age;
	public int id;
	public static String weather = "今天天气好晴朗!!";
	
	public Person() {
		logger.info("Person--Person()");
	}
	
	public Person(String name, int age, int id) {
		this.name = name;
		this.age = age;
		this.id = id;
		logger.info("Person--Person(String name, int age, int id)");
	}
	
	private Person(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static void showWeather() {
		logger.info("weather:"+weather);
	}
	
	@Override
	public String toString() {
		return "Persion [name=" + name + ", age=" + age + ", id=" + id +",weather="+weather+ "]---"+super.toString();
	}
	
	@Override
	public void speak(String talk) {
		logger.info("talk:"+talk);
	}
	
	public class InnerClass {
		
	}
	
	private class InnerPriClass {
		
	}
}
