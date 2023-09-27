package br.dev.marcelodeoliveira.appium.tests.model.pages;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.addCapability;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setDefaultCapabilities;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setupDriver;

import org.junit.Assert;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.BaseTest;
import io.appium.java_client.remote.MobileCapabilityType;

public class ScrollTest extends BaseTest {

	private MenuPage menuPage;

	@Override
	public void setupTest() {
		setDefaultCapabilities();
		addCapability(MobileCapabilityType.APP,
				"C:/Users/MarcelodeOliveiraSan/Workspace/APPIUM/CursoAppium/src/main/resources/apks/CTAppium_2_0.apk");
		setupDriver();
		this.menuPage = new MenuPage();
	}

	@Test
	public void deveEncontrarOpcaoEscondidaNoMenuPorScroll() {
		menuPage.clicaOpcaoEscondida();
		Assert.assertEquals("Sucesso", menuPage.getAlertTitleTxt());
		Assert.assertEquals("Você achou essa opção", menuPage.getAlertMessageTxt());
		menuPage.clicaAlertOk();
	}
}
