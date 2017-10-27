package com.sh.designpattern.structural;

import org.junit.Test;

import com.sh.designpattern.structural.decorator.BufferedeOutputStream;
import com.sh.designpattern.structural.decorator.EncryOutputStream;
import com.sh.designpattern.structural.decorator.FileOutputStream;
import com.sh.designpattern.structural.decorator.OutputStream;

public class DecoratorTest {

	@Test
	public void testWrite() {
		OutputStream out = new BufferedeOutputStream(new EncryOutputStream(new FileOutputStream()));
		
		out.write(32);
	}
}
