package com.sh.designpattern.structural.bridge;

/**
 * 电视机接口
 * @author 孙浩
 * @date 2017年10月17日 下午2:24:14
 */
public interface ITV {

	/**
	 * 开
	 * @author 孙浩
	 * @date 2017年10月17日 下午2:24:52
	 */
	void on();

	/**
	 * 关
	 * @author 孙浩
	 * @date 2017年10月17日 下午2:25:02
	 */
	void off();

	/**
	 * 换台
	 * @author 孙浩
	 * @date 2017年10月17日 下午2:35:39
	 * @param channel
	 */
	void switchChannel(int channel);
}
