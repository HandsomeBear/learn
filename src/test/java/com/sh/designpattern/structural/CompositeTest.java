package com.sh.designpattern.structural;

import org.junit.Test;

import com.sh.designpattern.structural.composite.Component;
import com.sh.designpattern.structural.composite.Composite;
import com.sh.designpattern.structural.composite.Leaf;

public class CompositeTest {

	@Test
	public void testDisplay() {
		Component root = new Composite("总公司");
		Component subA = new Composite("子公司A");
		Component subB = new Composite("子公司B");
		
		Component subA1 = new Composite("子公司A1");
		Component subB1 = new Composite("子公司B1");
		
		Component people = new Leaf("总公司people");
		Component peopleA = new Leaf("子公司peopleA");
		Component peopleB = new Leaf("子公司peopleB");
		Component peopleA1 = new Leaf("子公司peopleA1");
		Component peopleB1 = new Leaf("子公司peopleB1");
		
		root.add(subA);
		root.add(subB);
		root.add(people);
		
		subA.add(subA1);
		subA.add(peopleA);
		
		subB.add(subB1);
		subB.add(peopleB);
		
		subA1.add(peopleA1);
		subB1.add(peopleB1);
		
		root.display();
		subA.display();
		subB.display();
		subA1.display();
		subB1.display();
	}
}
