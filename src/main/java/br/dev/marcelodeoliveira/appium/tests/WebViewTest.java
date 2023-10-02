package br.dev.marcelodeoliveira.appium.tests;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.addCapability;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setDefaultCapabilities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.core.DriverFactory;
import br.dev.marcelodeoliveira.appium.tests.logic.MenuLogic;
import br.dev.marcelodeoliveira.appium.tests.logic.WebViewLogic;
import io.appium.java_client.remote.MobileCapabilityType;

public class WebViewTest extends BaseTest {

	private MenuLogic menuLogic;
	private WebViewLogic webViewLogic;

	@Before
	public void setupTest() {
		setDefaultCapabilities();
		addCapability(MobileCapabilityType.APP,
				"C:/Users/MarcelodeOliveiraSan/Workspace/APPIUM/CursoAppium/src/main/resources/apks/CTAppium_1_2.apk");

		addCapability("appWaitPackage", "com.google.android.permissioncontroller");
		addCapability("appWaitActivity", "com.android.packageinstaller.permission.ui.ReviewPermissionsActivity");
		DriverFactory.setupDriver();
		this.menuLogic = new MenuLogic();
		this.webViewLogic = new WebViewLogic();

		menuLogic.acessarSeuBarrigaHibrido();
		webViewLogic.switchToWebContext();
	}

	@Test
	public void deveLogarSeuBarriga() {
		webViewLogic.setEmail("automation.mrkolv@gmail.com");
		webViewLogic.setSenha("123!");
		webViewLogic.entrar();
		Assert.assertTrue(webViewLogic.getWelcomeLabel().contains("Bem vindo, "));
	}

}
