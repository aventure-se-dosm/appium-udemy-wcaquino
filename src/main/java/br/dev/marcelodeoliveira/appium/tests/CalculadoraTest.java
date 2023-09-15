package br.dev.marcelodeoliveira.appium.tests;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.addCapability;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setDefaultCapabilities;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setupDriver;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.model.pages.CalculadoraPage;

public class CalculadoraTest extends BaseTest {

	CalculadoraPage page;
	private final String APP_NEGATIVE_SIGN_CHAR = "−";

	private String negative(String number) {
		return APP_NEGATIVE_SIGN_CHAR.concat(number);
	}

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
		Assert.assertEquals(page.getResult(), "4");
	}

	@Test
	public void calculadoraMenosTest() throws MalformedURLException {
		page.simpleSub(6, 9);
		Assert.assertEquals(page.getResult(), negative("3"));
	}

	@Test
	public void calculadoraVezesTest() throws MalformedURLException {
		page.simpleMult(5, -7);
		Assert.assertEquals(negative("35"), page.getResult());
	}

	@Test
	public void calculadoraDivisaoTest() throws MalformedURLException {
		page.simpleDiv(6, 9);
		Assert.assertTrue(page.getResult().equals("0,6666666666666") || page.getResult().equals("0.6666666666666"));
	}

	@Test
	public void calculadoraRaizQuadradaTest() throws MalformedURLException {
		page.simpleSqrt(7);
		Assert.assertEquals("2,6457513110645", page.getResult());
	}

}
