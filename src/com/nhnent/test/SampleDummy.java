package com.nhnent.test;

import com.nhnent.annotation.SimpleJUnitTest;

public class SampleDummy {

	@SimpleJUnitTest
	public void method1() {
		System.out.println("com.nhnent.test.Sample.method1() is called.");
	}

	public void method2() {
		System.out.println("com.nhnent.test.Sample.method2() is called.");
	}

	@SimpleJUnitTest
	public void method3() {
		System.out.println("com.nhnent.test.Sample.method3() is called.");
	}
}
