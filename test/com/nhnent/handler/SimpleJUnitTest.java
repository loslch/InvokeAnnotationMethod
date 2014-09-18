package com.nhnent.handler;

import org.junit.Test;

import com.nhnent.simplejunit.SimpleJUnit;

public class SimpleJUnitTest {
	
	@Test
	public void SimpleJunitTest() throws ClassNotFoundException {
		SimpleJUnit.start("com.nhnent.test");
	}
}
