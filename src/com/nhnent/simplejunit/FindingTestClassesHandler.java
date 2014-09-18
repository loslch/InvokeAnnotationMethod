package com.nhnent.simplejunit;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

public class FindingTestClassesHandler {
	private final static char DOT = '.';
	private final static char SLASH = '/';
	private final static String TEST_CLASS_SUFFIX = "Test.class";
	private final static String CLASS_SUFFIX = ".class";

	final static List<Class> find(final String path) throws IOException,
			ClassNotFoundException {
		List<Class> clazzes = new LinkedList<Class>();

		if (path.endsWith(TEST_CLASS_SUFFIX)) {
			String clazz = path.replace(CLASS_SUFFIX, "");
			clazzes.add(Class.forName(clazz));
		} else if (isPackage(path)) {
			File file = getFileFromPath(path);
			for (File nestedFile : file.listFiles()) {
				clazzes.addAll(find(path + DOT + nestedFile.getName()));
			}
		}

		return clazzes;
	}

	private static File getFileFromPath(final String path) throws IOException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		String scannedPath = path.replace(DOT, SLASH);
		Enumeration<URL> resources = classLoader.getResources(scannedPath);

		return new File(resources.nextElement().getFile());
	}

	private static boolean isPackage(final String path) {
		return !path.endsWith(CLASS_SUFFIX);
	}
}
