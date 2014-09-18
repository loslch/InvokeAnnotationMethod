package com.nhnent.simplejunit;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import com.nhnent.annotation.SimpleJUnitTest;

public class SimpleJUnit {
	private static Class testClazz = SimpleJUnitTest.class;
	
	public static void start(String packageName) throws ClassNotFoundException, IOException {
		findTestClass(FindingTestClassesHandler.find(packageName));
	}
	

	private static void findTestClass(List<Class> clazzList) {
		for (Class clazz : clazzList) {
			findAndRunTestMethods(clazz.getMethods());
		}
	}

	private static void findAndRunTestMethods(Method[] methods) {
		for (Method method : methods) {
			if(method.getAnnotation(SimpleJUnitTest.class) != null){
				try {
					method.invoke(method.getDeclaringClass().newInstance());
				} catch (Throwable e) {
					//TODO: Exception
					e.printStackTrace();
				}
			}
		}
	}
	
}
