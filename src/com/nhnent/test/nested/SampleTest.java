package com.nhnent.test.nested;

import com.nhnent.annotation.SimpleJUnitTest;

public class SampleTest {

	@SimpleJUnitTest
	public void method1() {
		System.out.println("com.nhnent.test.nested.SampleTest.method1() is called.");
	}

	public void method2() {
		System.out.println("com.nhnent.test.nested.SampleTest.method2() is called.");
	}

	@SimpleJUnitTest
	public void method3() {
		System.out.println("com.nhnent.test.nested.SampleTest.method3() is called.");
	}
}
