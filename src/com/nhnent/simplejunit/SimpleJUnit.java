package com.nhnent.simplejunit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import com.nhnent.annotation.SimpleJUnitTest;

public class SimpleJUnit {
	private static Class testClass = SimpleJUnitTest.class;
	public static void start(String packageName) throws ClassNotFoundException {
		findTestClass(FindingTestClassesHandler.getClassesForPackage(packageName));
	}
	

	private static void findTestClass(List<Class> clazzList) {
		for (Class clazz : clazzList) {
			findTestMethods(clazz.getMethods());
		}
	}

	private static void findTestMethods(Method[] methods) {
		for (Method method : methods) {
			if(method.getAnnotation(SimpleJUnitTest.class) != null){
				try {
					method.invoke(method.getDeclaringClass().newInstance());
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
