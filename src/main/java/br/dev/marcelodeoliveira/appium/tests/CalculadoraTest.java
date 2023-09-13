package br.dev.marcelodeoliveira.appium.tests;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.addCapability;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.getDriver;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setDefaultCapabilities;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setupDriver;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import io.appium.java_client.MobileElement;

public class CalculadoraTest extends BaseTest {
	@Before
	public void setupTest() {
		setDefaultCapabilities();
		addCapability("appPackage", "com.google.android.calculator");
		addCapability("appActivity", "com.android.calculator2.Calculator");
		setupDriver();
	}

	@Test
	public void calculadoraSomaTest() throws MalformedURLException {

		MobileElement el2 = (MobileElement) getDriver().findElementById("com.google.android.calculator:id/digit_2");
		el2.click();

		MobileElement el3 = (MobileElement) getDriver().findElementById("com.google.android.calculator:id/op_add");

		el3.click();
		MobileElement el4 = (MobileElement) getDriver().findElementById("com.google.android.calculator:id/digit_2");

		el4.click();
		MobileElement el5 = (MobileElement) getDriver().findElementById("com.google.android.calculator:id/eq");

		el5.click();
		MobileElement el6 = (MobileElement) getDriver()
				.findElementById("com.google.android.calculator:id/result_final");

		// it fails: their references don't point to the same object;
		// Assert.assertSame(el2, el4);
		Assert.assertEquals(el2, el4);
		Assert.assertEquals(el2.getAttribute("content-desc"), "2", el2.getAttribute("content-desc"));
		Assert.assertEquals(el3.getAttribute("content-desc"), "mais", el3.getAttribute("content-desc"));
		Assert.assertEquals(el4.getAttribute("content-desc"), "2", el4.getAttribute("content-desc"));
		Assert.assertEquals(el5.getAttribute("content-desc"), "igual", el5.getAttribute("content-desc"));
		Assert.assertEquals(el6.getAttribute("content-desc"), "4", el6.getText());

	}

}
