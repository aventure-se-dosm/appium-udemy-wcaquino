package br.dev.marcelodeoliveira.appium.tests.saucelabs;


import static br.dev.marcelodeoliveira.appium.core.DriverFactory.getTestDriver;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.killDriver;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setAppAndAllowAppPermissionCapabilities;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setTestDriverCapabilities;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.By;

public class SauceLabsTest {

	@Rule
	public TestName testName = new TestName();

	@BeforeClass
	public static void setupTest() {

		// setDefaultCapabilities();
		// setupCTAppProperCapabilities();
		setTestDriverCapabilities();
	};

	@Before
	public void setupProperTestCapabilities() {
		setupCTAppProperCapabilities();

		setupLogic();
	}

	private static void setupCTAppProperCapabilities() {

		setAppAndAllowAppPermissionCapabilities("1.2");
		try {
			Thread.sleep(2000l);
			getTestDriver()
					.findElement(By.xpath("//*[@resource-id='com.android.permissioncontroller:id/continue_button']"))
					.click();
			getTestDriver().findElement(By.xpath("//*[@resource-id='android:id/button1']")).click();
		} catch (Exception e) {

			return;
		}
	}

//	protected abstract void setupLogic();
	protected void setupLogic() {
		
	}

	@After
	public void finishTest() {
		killDriver();
	}

}
