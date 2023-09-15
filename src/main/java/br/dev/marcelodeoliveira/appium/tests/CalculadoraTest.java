package br.dev.marcelodeoliveira.appium.tests;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.addCapability;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.getDriver;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setDefaultCapabilities;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setupDriver;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.model.pages.CalculadoraPage;
import io.appium.java_client.MobileElement;

public class CalculadoraTest extends BaseTest {

	CalculadoraPage page;

	@Before
	public void setupTest() {
		setDefaultCapabilities();
		addCapability("appPackage", "com.google.android.calculator");
		addCapability("appActivity", "com.android.calculator2.Calculator");
		setupDriver();
		this.page = new CalculadoraPage();
	}

	@Test
	public void calculadoraSomaTest() throws MalformedURLException {
		page.simpleSum(2, 2);
		Assert.assertEquals(page.getResult(),"4");
	}

}
