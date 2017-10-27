package com.sh.designpattern.structural;

import org.junit.Test;

import com.sh.designpattern.structural.bridge.ITV;
import com.sh.designpattern.structural.bridge.LogitechRemoteControl;
import com.sh.designpattern.structural.bridge.SonyTVImpl;

public class BridgeTest {

	@Test
	public void testBridge() {
		ITV tv = new SonyTVImpl();
		LogitechRemoteControl logitech = new LogitechRemoteControl(tv);
		
		logitech.setChannelKeyBoard(30);
	}
}
