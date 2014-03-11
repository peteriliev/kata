package com.iliev.peter.guice;

import org.junit.runners.model.InitializationError;

/**
 * JUnit4 runner customized for our Guice module.
 */
public class GuiceIntegration extends GuiceTestRunner {
	/**
	 * Creates a new GuiceIntegration.
	 * 
	 * @param classToRun
	 *            the test class to run
	 * @throws InitializationError
	 *             if the test class is malformed
	 */
	public GuiceIntegration(Class<?> classToRun) throws InitializationError {
		super(classToRun, new GuiceModule());
	}
}