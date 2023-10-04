package br.dev.marcelodeoliveira.appium.tests;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.killDriver;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setAppAndAllowAppPermissionCapabilities;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setDefaultCapabilities;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

public abstract class CTAppiumBaseTestVersionable {

	@Rule
	public TestName testName = new TestName();

	@Before
	public void setupTest() {

		setDefaultCapabilities();
		setupCTAppProperCapabilities();
		setupLogic();
	};

	private void setupCTAppProperCapabilities() {
		setAppAndAllowAppPermissionCapabilities("2.0");
	}

	protected abstract void setupLogic();

	@After
	public void finishTest() {
		killDriver();
	}

}
