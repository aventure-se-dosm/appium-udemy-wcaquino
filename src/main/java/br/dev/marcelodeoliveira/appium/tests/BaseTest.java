package br.dev.marcelodeoliveira.appium.tests;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.killDriver;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setDefaultCapabilities;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setupDriver;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

import br.dev.marcelodeoliveira.appium.core.DriverFactory;

public abstract class BaseTest {

	@Rule
	public TestName testName = new TestName();

	@Before
	public void setupTest() {
		setDefaultCapabilities();
		setupDriver();
	}

	@After
	public void resetApp() {
		DriverFactory.tearDown();
	}

	@AfterClass
	public static void finishTest() {
		killDriver();
	}

}
