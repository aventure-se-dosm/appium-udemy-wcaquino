package br.dev.marcelodeoliveira.appium.tests;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setAppAndAllowAppPermissionCapabilities;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.getDriver;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.killDriver;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setDefaultCapabilities;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.By;

public abstract class CTAppiumBaseTestVersionable {

	@Rule
	public TestName testName = new TestName();

	@Before
	public void setupTest() {

		setDefaultCapabilities();
		setupCTAppProperCapabilities();
		;
		setupLogic();
	};

	private void setupCTAppProperCapabilities() {

		setAppAndAllowAppPermissionCapabilities("1.2");
		try {
			Thread.sleep(3000);

			getDriver().findElement(By.xpath("//*[@resource-id='com.android.permissioncontroller:id/continue_button']"))
					.click();
			getDriver().findElement(By.xpath("//*[@resource-id='android:id/button1']")).click();
		} catch (Exception e) {
			getDriver().manage().timeouts().implicitlyWait(15l, TimeUnit.SECONDS);
			return;
		}
	}

	protected abstract void setupLogic();

	@After
	public void finishTest() {
		killDriver();
	}

}
