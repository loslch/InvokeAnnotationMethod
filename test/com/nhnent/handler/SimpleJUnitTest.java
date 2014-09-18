package com.nhnent.handler;

import java.io.IOException;

import org.junit.Test;

import com.nhnent.simplejunit.SimpleJUnit;

public class SimpleJUnitTest {
	
	@Test
	public void SimpleJunitTest() throws ClassNotFoundException, IOException {
		SimpleJUnit.start("com.nhnent.test");
	}
}
