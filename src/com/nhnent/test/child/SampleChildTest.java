package com.nhnent.test.child;

import com.nhnent.annotation.SimpleJUnitTest;

public class SampleChildTest {

	@SimpleJUnitTest
	public void method1() {
		System.out.println("com.nhnent.test.SampleChildTest.method1() is called.");
	}

	@SimpleJUnitTest
	public void method2() {
		System.out.println("com.nhnent.test.SampleChildTest.method2() is called.");
	}

	public void method3() {
		System.out.println("com.nhnent.test.SampleChildTest.method3() is called.");
	}
}
