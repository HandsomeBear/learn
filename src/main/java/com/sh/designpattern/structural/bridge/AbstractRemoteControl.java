package com.sh.designpattern.structural.bridge;

/**
 * 遥控器
 * @author 孙浩
 * @date 2017年10月17日 下午2:54:46
 */
public abstract class AbstractRemoteControl {

	private ITV tv;
	
	public AbstractRemoteControl(ITV tv) {
		this.tv = tv;
	}
	
	public void turnOn() {
		tv.on();
	}
	
	public void turnOff() {
		tv.off();
	}
	
	public void setChannel(int channel) {
		tv.switchChannel(channel);
	}
}
