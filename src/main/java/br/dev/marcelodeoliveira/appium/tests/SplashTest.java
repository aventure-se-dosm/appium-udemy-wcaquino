package br.dev.marcelodeoliveira.appium.tests;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.addCapability;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setDefaultCapabilities;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setupDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.logic.MenuLogic;
import br.dev.marcelodeoliveira.appium.tests.logic.SplashLogic;
import io.appium.java_client.remote.MobileCapabilityType;

public class SplashTest extends BaseTest {

	private SplashLogic splashLogic;
	private MenuLogic menuLogic;

	@Before
	public void setupTest() {
		setDefaultCapabilities();
		addCapability(MobileCapabilityType.APP,
				"C:/Users/MarcelodeOliveiraSan/Workspace/APPIUM/CursoAppium/src/main/resources/apks/CTAppium_2_0.apk");
		setupDriver();

		menuLogic = new MenuLogic();
		splashLogic = new SplashLogic();
	}

	@Test
	public void deveAguardarSplashSumir() {
		menuLogic.clicaSplash();
		splashLogic.isSplashExibido();
		Assert.assertEquals("Splash!", splashLogic.getSplashText());

		splashLogic.aguardaSplashSumir();

		Assert.assertTrue(menuLogic.isMenuVisible());

	}
}
