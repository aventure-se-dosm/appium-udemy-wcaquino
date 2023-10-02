
package br.dev.marcelodeoliveira.appium.tests;

import java.net.MalformedURLException;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.logic.FormularioLogic;
import br.dev.marcelodeoliveira.appium.tests.logic.MenuLogic;

public class FormularioTest extends CTAppiumBaseTest {

	MenuLogic menuLogic;
	FormularioLogic formularioLogic;



	@Test
	public void devePreencherCampoTeste() throws MalformedURLException {

		String txtName = "Wagner";
		formularioLogic.escreveNome(txtName);
	}

	@Test
	public void deveIteragirSwitchEScheckbox() throws MalformedURLException {

		formularioLogic.mudaSwitch(true);
		formularioLogic.mudaCheckbox(true);
		Assert.assertTrue(formularioLogic.isCheckboxSelected());
		Assert.assertEquals(true, formularioLogic.isSwitchSelected());
	}

	@Test
	public void deveCadastrarNomeDemorado() throws MalformedURLException {

		final String TXT_USER_NAME = "Wagnão";

		formularioLogic.escreveNome(TXT_USER_NAME);
		formularioLogic.salvarFormDemorado();

		Assert.assertTrue(formularioLogic.getAllFormResponse().containsAll(
				Arrays.asList("Nome: ".concat(TXT_USER_NAME), "Slider: 25", "Data: 01/01/2000", "Hora: 12:00")));
	}

	@Test
	public void deveResolverDesafio() {

		final String TXT_USER_NAME = "Wagnão";
		final String TXT_SELECTED_GAME_CONSOLE = "Nintendo Switch";
		final Boolean statusSwitchHourSelected = true;
		final Boolean statusChkDaterSeleced = false;

		formularioLogic.escreveNome(TXT_USER_NAME);
		formularioLogic.selecionaConsole(TXT_SELECTED_GAME_CONSOLE);
		formularioLogic.mudaSwitch(statusSwitchHourSelected);
		formularioLogic.mudaCheckbox(statusChkDaterSeleced);
		formularioLogic.salvarForm();

		Assert.assertTrue(formularioLogic.getAllFormResponse()
				.containsAll(Arrays.asList("Nome: ".concat(TXT_USER_NAME), "Console: switch", "Slider: 25",
						"Switch: On", "Checkbox: Desabilitado", "Data: 01/01/2000", "Hora: 12:00")));
	}

	@Override
	protected void setupLogic() {
		// TODO Auto-generated method stub

		this.formularioLogic = new FormularioLogic();
		this.menuLogic = new MenuLogic();
		menuLogic.clicaFormulario();
		
	}
}
