package br.dev.marcelodeoliveira.appium.tests.business.saucelabs;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.killDriver;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setTestDriverCapabilities;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setupTestDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.core.BaseTest;

public class SauceLabsTest extends BaseTest {

//	@Rule
//	public TestName testName = new TestName();
	private SauceLabsLogic logic;

	@Before
	public void setupTest() {
		setTestDriverCapabilities();
		setupTestDriver();
		setupLogic();
	};

	@Test
	public void deveFazerLoginTest() {
		logic.setEmail("automation.mrkolv@gmail.com");
		logic.setSenha("123!");
		logic.entrar();
		Assert.assertTrue(logic.getWelcomeLabel().contains("Bem vindo, "));
	}

	@After
	public void tearDown() {
		//logic.sairContextoWeb();
		killDriver();
	}

	public void setupLogic() {
		this.logic = new SauceLabsLogic();
	}

//	@After
//	public void finishTest() {
//	}

}
