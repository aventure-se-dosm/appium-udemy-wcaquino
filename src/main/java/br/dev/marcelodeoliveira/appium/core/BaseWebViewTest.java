package br.dev.marcelodeoliveira.appium.core;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BaseWebViewTest {

	@BeforeClass
	public static void setupAll() {
		WebDriverManager.chromedriver().setup();
		DriverFactory.setupDriver(new ChromeDriver().getClass());
	}

	@Before
	public abstract void setupTest();

	@After
	public void teardown() {
		DriverFactory.killDriver();
	}

}
