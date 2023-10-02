package br.dev.marcelodeoliveira.appium.tests;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.addCapability;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setDefaultCapabilities;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setupDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.logic.AlertLogic;
import br.dev.marcelodeoliveira.appium.tests.logic.MenuLogic;
import io.appium.java_client.remote.MobileCapabilityType;;

public class AlertTest extends BaseTest {

	private AlertLogic alertLogic;
	private MenuLogic menuLogic;

	@Before
	public void setupTest() {
		setDefaultCapabilities();
		addCapability(MobileCapabilityType.APP,
				"C:/Users/MarcelodeOliveiraSan/Workspace/APPIUM/CursoAppium/src/main/resources/apks/CTAppium_2_0.apk");
		setupDriver();

		this.alertLogic = new AlertLogic();
		this.menuLogic = new MenuLogic();
	}

	@Test
	public void deveTestarAlertaConfirmNegar() {
		menuLogic.clicaAlertas();
		alertLogic.clicaAlertConfirm();
		alertLogic.clicaAlertNegar();

		Assert.assertEquals("Negado", alertLogic.getMsgTxt());
	}

	@Test
	public void deveTestarAlertaConfirm() {
		menuLogic.clicaAlertas();
		String msg = alertLogic.clicaAlertConfirm();
		alertLogic.clicaConfirmar();

		Assert.assertEquals("Confirmado", alertLogic.getMsgTxt());
		Assert.assertEquals("Confirma a operação?", msg);
		alertLogic.clicaOk();

	}

	@Test
	public void deveClicarForaDoAlertSimplesEMensagemDesaparecer() {
		menuLogic.clicaAlertas();
		String msg = alertLogic.clicaAlertSimples();
		alertLogic.clicaOk();
		Assert.assertEquals("Pode clicar no OK ou fora da caixa para sair", msg);
		Assert.assertTrue(alertLogic.isAlertInvisibleOrAbsent());
	}
	@Test
	public void deveClicarForaDoAlertRestritivoEMensagemPermanecer() {
		menuLogic.clicaAlertas();
		String msg = alertLogic.clicaAlertRestritivo();
		Assert.assertEquals("Não pode clicar fora, apenas no SAIR", msg);
		Assert.assertTrue(alertLogic.isAlertPresent());
		alertLogic.clicaOk();
	}

}
