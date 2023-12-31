package br.dev.marcelodeoliveira.appium.tests;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.addCapability;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setDefaultCapabilities;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setupDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.model.pages.MenuPage;
import br.dev.marcelodeoliveira.appium.tests.model.pages.SplashPage;
import io.appium.java_client.remote.MobileCapabilityType;

public class SplashTest extends BaseTest {

	private SplashPage splashPage;
	private MenuPage menuPage;

	@Before
	public void setupTest() {
		setDefaultCapabilities();
		addCapability(MobileCapabilityType.APP,
				"C:/Users/MarcelodeOliveiraSan/Workspace/APPIUM/CursoAppium/src/main/resources/apks/CTAppium_2_0.apk");
		setupDriver();

		menuPage = new MenuPage();
		splashPage = new SplashPage();
	}

	@Test
	public void deveAguardarSplashSumir() {
		menuPage.clicaSplash();
		splashPage.isSplashExibido();
		Assert.assertEquals("Splash!", splashPage.getSplashText());

		splashPage.aguardaSplashSumir();

		Assert.assertTrue(menuPage.isMenuVisible());

	}
}
