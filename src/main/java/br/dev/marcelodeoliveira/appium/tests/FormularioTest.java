
package br.dev.marcelodeoliveira.appium.tests;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.addCapability;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setDefaultCapabilities;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setupDriver;

import java.net.MalformedURLException;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.model.pages.FormularioPage;
import br.dev.marcelodeoliveira.appium.tests.model.pages.MenuPage;
import io.appium.java_client.remote.MobileCapabilityType;

public class FormularioTest extends BaseTest {

	MenuPage menuPage;
	FormularioPage formularioPage;

	@Before
	public void setupTest() {

		setDefaultCapabilities();
		addCapability(MobileCapabilityType.APP,
				"C:/Users/MarcelodeOliveiraSan/Workspace/APPIUM/CursoAppium/src/main/resources/apks/CTAppium_2_0.apk");
		setupDriver();

		this.formularioPage = new FormularioPage();
		this.menuPage = new MenuPage();
		menuPage.clicaFormulario();
	}

	@Test
	public void devePreencherCampoTeste() throws MalformedURLException {

		String txtName = "Wagner";
		formularioPage.escreveNome(txtName);
	}

	@Test
	public void deveIteragirSwitchEScheckbox() throws MalformedURLException {

		formularioPage.mudaSwitch(true);
		formularioPage.mudaCheckbox(true);
		Assert.assertTrue(formularioPage.isCheckboxSelected());
		Assert.assertEquals(true, formularioPage.isSwitchSelected());
	}

	@Test
	public void deveCadastrarNomeDemorado() throws MalformedURLException {

		final String TXT_USER_NAME = "Wagnão";

		formularioPage.escreveNome(TXT_USER_NAME);
		formularioPage.salvarFormDemorado();

		Assert.assertTrue(formularioPage.getAllFormResponse().containsAll(
				Arrays.asList("Nome: ".concat(TXT_USER_NAME), "Slider: 25", "Data: 01/01/2000", "Hora: 12:00")));
	}

	@Test
	public void deveResolverDesafio() {

		final String TXT_USER_NAME = "Wagnão";
		final String TXT_SELECTED_GAME_CONSOLE = "Nintendo Switch";
		final Boolean statusSwitchHourSelected = true;
		final Boolean statusChkDaterSeleced = false;

		formularioPage.escreveNome(TXT_USER_NAME);
		formularioPage.selecionaConsole(TXT_SELECTED_GAME_CONSOLE);
		formularioPage.mudaSwitch(statusSwitchHourSelected);
		formularioPage.mudaCheckbox(statusChkDaterSeleced);
		formularioPage.salvarForm();

		Assert.assertTrue(formularioPage.getAllFormResponse()
				.containsAll(Arrays.asList("Nome: ".concat(TXT_USER_NAME), "Console: switch", "Slider: 25",
						"Switch: On", "Checkbox: Desabilitado", "Data: 01/01/2000", "Hora: 12:00")));
	}
}
