package com.sh.designpattern.structural.adapter;

/**
 * 对象适配器
 * @author 孙浩
 * @date 2017年10月17日 下午1:56:34
 */
public class ObjectAdapter implements Target{

	private Adaptee adaptee;
	
	public ObjectAdapter(Adaptee adaptee) {
		this.adaptee = adaptee;
	}
	
	@Override
	public void request() {
		adaptee.specificRequest();
	}

}
