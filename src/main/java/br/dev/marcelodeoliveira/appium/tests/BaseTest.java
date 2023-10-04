package br.dev.marcelodeoliveira.appium.tests;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

public abstract class BaseTest {

	@Rule
	public TestName testName = new TestName();

	@Before 
	protected abstract void setupTest();

	@After
	public  void finishTest() {
		killDriver();
	}

}
