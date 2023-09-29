package br.dev.marcelodeoliveira.appium.tests;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.addCapability;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setDefaultCapabilities;

import org.junit.Before;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.core.DriverFactory;
import br.dev.marcelodeoliveira.appium.tests.model.pages.MenuPage;
import br.dev.marcelodeoliveira.appium.tests.model.pages.WebViewPage;
import io.appium.java_client.remote.MobileCapabilityType;

public class WebViewTest  {

	private MenuPage menuPage;
	private WebViewPage webViewPage;

	//@Override
	@Before
	public void setupTest() {
		setDefaultCapabilities();
		addCapability(MobileCapabilityType.APP,
				"C:/Users/MarcelodeOliveiraSan/Workspace/APPIUM/CursoAppium/src/main/resources/apks/CTAppium_1_2.apk");
		addCapability("fullReset", true);
		addCapability("noReset", false);
		DriverFactory.setupDriver();
		//DriverFactory.setupWebDriver();

		this.menuPage = new MenuPage();
		this.webViewPage = new WebViewPage();

		menuPage.acessarSeuBarrigaHibrido();
		webViewPage.setEmail();
 
	}

	
	@Test
	public void deveLogarSeuBarriga() {
		webViewPage.setEmail();
	}

}
