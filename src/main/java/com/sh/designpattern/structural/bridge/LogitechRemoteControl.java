package com.sh.designpattern.structural.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Samsung牌子的遥控器
 * @author 孙浩
 * @date 2017年10月17日 下午2:58:03
 */
public class LogitechRemoteControl extends AbstractRemoteControl{

	private static final Logger logger = LoggerFactory.getLogger(LogitechRemoteControl.class);
	
	public LogitechRemoteControl(ITV tv) {
		super(tv);
	}
	
	public void setChannelKeyBoard(int channel) {
		setChannel(channel);
		logger.info("Logitech use keyword to set channel");
	}
}
