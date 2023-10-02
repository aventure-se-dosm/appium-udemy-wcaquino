package br.dev.marcelodeoliveira.appium.tests;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.addCapability;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setDefaultCapabilities;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setupDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.logic.MenuLogic;
import br.dev.marcelodeoliveira.appium.tests.model.pages.AlertPage;
import io.appium.java_client.remote.MobileCapabilityType;;

public class AlertTest extends BaseTest {

	private AlertPage alertPage;
	private MenuLogic menuLogic;

	@Before
	public void setupTest() {
		setDefaultCapabilities();
		addCapability(MobileCapabilityType.APP,
				"C:/Users/MarcelodeOliveiraSan/Workspace/APPIUM/CursoAppium/src/main/resources/apks/CTAppium_2_0.apk");
		setupDriver();

		this.alertPage = new AlertPage();
		this.menuLogic = new MenuLogic();
	}

	@Test
	public void deveTestarAlertaConfirmNegar() {
		menuLogic.clicaAlertas();
		alertPage.clicaAlertConfirm();
		alertPage.clicaAlertNegar();

		Assert.assertEquals("Negado", alertPage.getMsgTxt());
	}

	@Test
	public void deveTestarAlertaConfirm() {
		menuLogic.clicaAlertas();
		String msg = alertPage.clicaAlertConfirm();
		alertPage.clicaConfirmar();

		Assert.assertEquals("Confirmado", alertPage.getMsgTxt());
		Assert.assertEquals("Confirma a operação?", msg);
		alertPage.clicaOk();

	}

	@Test
	public void deveClicarForaDoAlertSimplesEMensagemDesaparecer() {
		menuLogic.clicaAlertas();
		String msg = alertPage.clicaAlertSimples();
		alertPage.clicaOk();
		Assert.assertEquals("Pode clicar no OK ou fora da caixa para sair", msg);
		Assert.assertTrue(alertPage.isAlertInvisibleOrAbsent());
	}
	@Test
	public void deveClicarForaDoAlertRestritivoEMensagemPermanecer() {
		menuLogic.clicaAlertas();
		String msg = alertPage.clicaAlertRestritivo();
		Assert.assertEquals("Não pode clicar fora, apenas no SAIR", msg);
		Assert.assertTrue(alertPage.isAlertPresent());
		alertPage.clicaOk();
	}

}
