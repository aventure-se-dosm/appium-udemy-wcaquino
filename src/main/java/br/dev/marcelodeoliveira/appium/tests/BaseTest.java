package br.dev.marcelodeoliveira.appium.tests;

import static br.dev.marcelodeoliveira.appium.tests.DriverFactory.*;

import org.junit.After;
import org.junit.AfterClass;
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
