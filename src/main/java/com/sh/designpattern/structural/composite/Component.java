package com.sh.designpattern.structural.composite;

/**
 * 抽象接口，适当情况下提供默认实现
 * @author 孙浩
 * @date 2017年10月18日 上午9:51:45
 */
public abstract class Component {

	private String name;
	
	public Component(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public abstract void add(Component c);
	public abstract void remove(Component c);
	public abstract void display();
}
