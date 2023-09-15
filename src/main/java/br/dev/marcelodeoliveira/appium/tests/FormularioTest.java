
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
import io.appium.java_client.remote.MobileCapabilityType;

public class FormularioTest extends BaseTest {

	FormularioPage page;

	@Before
	public void setupTest() {
		setDefaultCapabilities();
		addCapability(MobileCapabilityType.APP,
				"C:/Users/MarcelodeOliveiraSan/Workspace/APPIUM/CursoAppium/src/main/resources/apks/CTAppium_2_0.apk");
		setupDriver();
		this.page = new FormularioPage();

	}

	@Test
	public void devePreencherCampoTeste() throws MalformedURLException {

		String txtName = "Wagner";
		page.clicaFormulario();
		page.escreveNome(txtName);
		
	}

	@Test
	public void deveIteragirSwitchEScheckbox() throws MalformedURLException {

		page.clicaFormulario();
		page.mudaSwitch(true);
		page.mudaCheckbox(true);
		Assert.assertTrue(page.isCheckboxSelected());
		Assert.assertEquals(true, page.isSwitchSelected());
	}
	
	@Test
	public void deveCadastrarNomeDemorado() throws MalformedURLException {

		final String TXT_USER_NAME = "Wagnão";
		page.clicaFormulario();
		page.escreveNome(TXT_USER_NAME);
		page.salvarFormDemorado();
		
		Assert.assertTrue(
				page.getAllFormResponse().containsAll(Arrays.asList(
						"Nome: ".concat(TXT_USER_NAME),
						//"Console: switch",
						"Slider: 25", 
						//"Switch: On",
						//"Checkbox: Desabilitado",
						"Data: 01/01/2000", "Hora: 12:00")));
		
		
	}

	@Test
	public void deveResolverDesafio() {

		final String TXT_USER_NAME = "Wagnão";
		final String TXT_SELECTED_GAME_CONSOLE = "Nintendo Switch";
		final Boolean statusSwitchHourSelected = true;
		final Boolean statusChkDaterSeleced = false;

		page.clicaFormulario();
		page.escreveNome(TXT_USER_NAME);
		page.selecionaConsole(TXT_SELECTED_GAME_CONSOLE);
		page.mudaSwitch(statusSwitchHourSelected);
		page.mudaCheckbox(statusChkDaterSeleced);
		page.salvarForm();

		Assert.assertTrue(
				page.getAllFormResponse().containsAll(Arrays.asList("Nome: ".concat(TXT_USER_NAME), "Console: switch",
						"Slider: 25", "Switch: On", "Checkbox: Desabilitado", "Data: 01/01/2000", "Hora: 12:00")));

	}
}
