package br.dev.marcelodeoliveira.appium.tests;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.addCapability;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setDefaultCapabilities;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.core.DriverFactory;
import br.dev.marcelodeoliveira.appium.tests.model.pages.MenuPage;
import br.dev.marcelodeoliveira.appium.tests.model.pages.WebViewPage;
import io.appium.java_client.remote.MobileCapabilityType;

public class WebViewTest extends BaseTest {

	private MenuPage menuPage;
	private WebViewPage webViewPage;

	@Before
	public void setupTest() {
		setDefaultCapabilities();
		addCapability(MobileCapabilityType.APP,
				"C:/Users/MarcelodeOliveiraSan/Workspace/APPIUM/CursoAppium/src/main/resources/apks/CTAppium_1_2.apk");
	
		addCapability("appWaitPackage", "com.google.android.permissioncontroller");
		addCapability("appWaitActivity", "com.android.packageinstaller.permission.ui.ReviewPermissionsActivity");
		DriverFactory.setupDriver();
		this.menuPage = new MenuPage();
		this.webViewPage = new WebViewPage();

		menuPage.acessarSeuBarrigaHibrido();
		webViewPage.switchToWebContext();
	}

	@Test
	public void deveLogarSeuBarriga() {
		webViewPage.setEmail("automation.mrkolv@gmail.com");
		webViewPage.setSenha("123!");
		webViewPage.entrar();
		Assert.assertTrue(webViewPage.getWelcomeLabel().contains("Bem vindo, "));
	}

}
