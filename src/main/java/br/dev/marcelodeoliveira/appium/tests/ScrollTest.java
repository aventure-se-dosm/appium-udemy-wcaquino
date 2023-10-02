package br.dev.marcelodeoliveira.appium.tests;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.addCapability;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setDefaultCapabilities;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setupDriver;

import org.junit.Assert;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.logic.MenuLogic;
import io.appium.java_client.remote.MobileCapabilityType;

public class ScrollTest extends BaseTest {

	private MenuLogic menuLogic;

	@Override
	public void setupTest() {
		setDefaultCapabilities();
		addCapability(MobileCapabilityType.APP,
				"C:/Users/MarcelodeOliveiraSan/Workspace/APPIUM/CursoAppium/src/main/resources/apks/CTAppium_2_0.apk");
		setupDriver();
		this.menuLogic = new MenuLogic();
	}

	@Test
	public void deveEncontrarOpcaoEscondidaNoMenuPorScroll() {
		menuLogic.clicaOpcaoEscondida();
		Assert.assertEquals("Sucesso", menuLogic.getAlertTitleTxt());
		Assert.assertEquals("Você achou essa opção", menuLogic.getAlertMessageTxt());
		menuLogic.clicaAlertOk();
	}
}
