package org.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class RetryAllTests implements IAnnotationTransformer{

	public void tranformer( ITestAnnotation annotation,
			                                Class testClass, 
			                                Constructor testConstructor, 
			                                 Method testMethod) {
		annotation.setRetryAnalyzer(org.listeners.RetryTests.class);

	}
}
