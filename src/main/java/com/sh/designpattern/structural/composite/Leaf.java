package com.sh.designpattern.structural.composite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 叶子结点
 * @author 孙浩
 * @date 2017年10月18日 上午9:54:41
 */
public class Leaf extends Component {
	
	private static final Logger logger = LoggerFactory.getLogger(Component.class);

	public Leaf(String name) {
		super(name);
	}
	
	public void add(Component c){}
	
	public void remove(Component c){}
	
	public void display() {
		logger.info("Leaf." + getName() + "->" + getName());
	}
}
