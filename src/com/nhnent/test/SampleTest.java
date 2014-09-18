package com.nhnent.test;

import com.nhnent.annotation.SimpleJUnitTest;

public class SampleTest {

	@SimpleJUnitTest
	public void methodTest1() {
		System.out.println("1번 테스트");
	}

	public void methodTest2() {
		System.out.println("2번 테스트");
	}

	@SimpleJUnitTest
	public void methodTest3() {
		System.out.println("3번 테스트");
	}
}
