package br.dev.marcelodeoliveira.appium.tests;

import org.junit.Assert;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.logic.MenuLogic;
import br.dev.marcelodeoliveira.appium.tests.logic.WebViewLogic;

public class WebViewTest extends CTAppiumBaseTest {

	private MenuLogic menuLogic;
	private WebViewLogic webViewLogic;

//	@Before
//	public void setupTest() {
//		setDefaultCapabilities();
//		addCapability(MobileCapabilityType.APP,
//				"C:/Users/MarcelodeOliveiraSan/Workspace/APPIUM/CursoAppium/src/main/resources/apks/CTAppium_1_2.apk");
//
//		addCapability("appWaitPackage", "com.google.android.permissioncontroller");
//		addCapability("appWaitActivity", "com.android.packageinstaller.permission.ui.ReviewPermissionsActivity");
//		DriverFactory.setupDriver();
//	}

	@Test
	public void deveLogarSeuBarriga() {
		webViewLogic.setEmail("automation.mrkolv@gmail.com");
		webViewLogic.setSenha("123!");
		webViewLogic.entrar();
		Assert.assertTrue(webViewLogic.getWelcomeLabel().contains("Bem vindo, "));
	}

	@Override
	protected void setupLogic() {

		this.menuLogic = new MenuLogic();
		this.webViewLogic = new WebViewLogic();

		menuLogic.acessarSeuBarrigaHibrido();
		webViewLogic.switchToWebContext();

	}

}
