package com.nhnent.simplejunit;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

public class FindingTestClassesHandler {
	private final static char DOT = '.';
	private final static char SLASH = '/';
	private final static String TEST_CLASS_SUFFIX = "Test.class";
	private final static String CLASS_SUFFIX = ".class";

	final static List<Class> find(final String scannedPackage)
			throws IOException, ClassNotFoundException {
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();

		String scannedPath = scannedPackage.replace(DOT, SLASH);
		Enumeration<URL> resources = classLoader.getResources(scannedPath);

		List<Class> classes = new LinkedList<Class>();
		File file = new File(resources.nextElement().getFile());
	
		for (File nestedFile : file.listFiles()) {
			classes.addAll(find(nestedFile, scannedPackage));
		}
		return classes;
	}

	private final static List<Class> find(final File file,
			final String scannedPackage) throws ClassNotFoundException {
		List<Class> classes = new LinkedList<Class>();
		String resource = scannedPackage + DOT + file.getName();

		if (file.isDirectory()) {
			for (File nestedFile : file.listFiles()) {
				classes.addAll(find(nestedFile, resource));
			}

		} else if (resource.endsWith(TEST_CLASS_SUFFIX)) {
			int beginIndex = 0;	
			int endIndex = resource.length() - CLASS_SUFFIX.length();
			String className = resource.substring(beginIndex, endIndex);
			classes.add(Class.forName(className));
		}
		return classes;
	}

}
