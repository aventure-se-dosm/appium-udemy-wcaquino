package br.dev.marcelodeoliveira.appium.tests;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.killDriver;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setDefaultCapabilities;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setupDriver;

import org.junit.After;
import org.junit.Before;

public class BaseTest {
	
	@Before
	public void setupTest() {
		setDefaultCapabilities();
		setupDriver();
	}
	
	@After
	public  void resetApp() {
		killDriver();
	}

}
