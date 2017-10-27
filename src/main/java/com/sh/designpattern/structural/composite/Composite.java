package com.sh.designpattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Composite extends Component {

	private static final Logger logger = LoggerFactory.getLogger(Composite.class);
	
	private List<Component> coms;
	
	public Composite(String name) {
		super(name);
		coms = new ArrayList<Component>();
	}
	
	public void add(Component c) {
		logger.info("Composite." + getName() + " add " + c.getName());
		
		coms.add(c);
	}
	
	public void remove(Component c) {
		logger.info("Composite." + getName() + " remove " + c.getName());
		
		coms.remove(c);
	}
	
	public void display() {
		logger.info("Composite." + getName() + "->diaplay");
		
		for(Component c : coms) {
			logger.info(c.getName());
		}
	}
}
