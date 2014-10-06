package com.iliev.peter.guice;

import main.java.RandomTestSetProdiver;

import com.google.inject.AbstractModule;
import com.iliev.peter.kata.utils.ITestSetProvider;

public class GuiceModule extends AbstractModule {

	@Override
	protected void configure()
	{
		// bind(ITestSetProvider.class).to(TestSetProvider.class);
		bind(ITestSetProvider.class).to(RandomTestSetProdiver.class);
	}
}
