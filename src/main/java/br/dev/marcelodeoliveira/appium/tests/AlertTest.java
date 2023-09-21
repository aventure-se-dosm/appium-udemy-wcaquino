package br.dev.marcelodeoliveira.appium.tests;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.addCapability;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setDefaultCapabilities;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setupDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.model.pages.AlertPage;
import br.dev.marcelodeoliveira.appium.tests.model.pages.MenuPage;
import io.appium.java_client.remote.MobileCapabilityType;;

public class AlertTest extends BaseTest {

	private AlertPage alertPage;
	private MenuPage menuPage;

	@Before
	public void setupTest() {
		setDefaultCapabilities();
		addCapability(MobileCapabilityType.APP,
				"C:/Users/MarcelodeOliveiraSan/Workspace/APPIUM/CursoAppium/src/main/resources/apks/CTAppium_2_0.apk");
		setupDriver();

		this.alertPage = new AlertPage();
		this.menuPage = new MenuPage();
	}

	@Test
	public void deveTestarAlertaConfirmNegar() {
		menuPage.clicaAlertas();
		alertPage.clicaAlertConfirm();
		alertPage.clicaAlertNegar();

		Assert.assertEquals("Negado", alertPage.getMsgTxt());
	}

	@Test
	public void deveTestarAlertaConfirm() {
		menuPage.clicaAlertas();
		String msg = alertPage.clicaAlertConfirm();
		alertPage.clicaConfirmar();

		Assert.assertEquals("Confirmado", alertPage.getMsgTxt());
		Assert.assertEquals("Confirma a operação?", msg);
	}

}
