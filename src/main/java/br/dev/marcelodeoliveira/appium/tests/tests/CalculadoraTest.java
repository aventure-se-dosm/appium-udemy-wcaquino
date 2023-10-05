package br.dev.marcelodeoliveira.appium.tests.tests;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setDefaultCapabilitiesCalc;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setupDriver;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.logic.CalculadoraLogic;

public class CalculadoraTest extends BaseTest {

	private CalculadoraLogic calculadoraLogic;
	private final String APP_NEGATIVE_SIGN_CHAR = "−";

	private String negative(String number) {
		return APP_NEGATIVE_SIGN_CHAR.concat(number);
	}

	@Before
	@Override
	public void setupTest() {
		setDefaultCapabilitiesCalc();

		setupDriver();
		this.calculadoraLogic = new CalculadoraLogic();

	}

	@Test
	public void calculadoraSomaTest() throws MalformedURLException {
		calculadoraLogic.getWindowDimension();

		calculadoraLogic.simpleSum(2, 2);
		Assert.assertEquals(calculadoraLogic.getResult(), "4");
	}

	@Test
	public void calculadoraMenosTest() throws MalformedURLException {
		calculadoraLogic.simpleSub(6, 9);
		Assert.assertEquals(calculadoraLogic.getResult(), negative("3"));
	}

	@Test
	public void calculadoraVezesTest() throws MalformedURLException {
		calculadoraLogic.simpleMult(5, -7);
		Assert.assertEquals(negative("35"), calculadoraLogic.getResult());
	}

	@Test
	public void calculadoraDivisaoTest() throws MalformedURLException {
		calculadoraLogic.simpleDiv(6, 9);
		Assert.assertTrue(calculadoraLogic.getResult().replace('.', ',').equals("0,6666666666666"));
	}

	@Test
	public void calculadoraRaizQuadradaTest() throws MalformedURLException {
		calculadoraLogic.simpleSqrt(7);
		Assert.assertEquals("2,6457513110645", calculadoraLogic.getResult());
	}

}
