
package br.dev.marcelodeoliveira.appium.tests.elements_interaction.test;

import java.net.MalformedURLException;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.core.CTAppiumBaseTestVersionable;
import br.dev.marcelodeoliveira.appium.core.enums.GameConsole;
import br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.logic.FormularioLogic;
import br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.logic.MenuLogic;
import br.dev.marcelodeoliveira.appium.tests.model.dto.FormularioModel;

public class FormularioTest extends CTAppiumBaseTestVersionable {

	private MenuLogic menuLogic;
	private FormularioLogic formularioLogic;

	private FormularioModel formDto1;
	private FormularioModel formDto_desafio;
	private FormularioModel formDto2;

	@Test
	public void devePreencherCampoTeste() {

		String txtName = "Wagner";
		formularioLogic.escreveNome(txtName);
		Assert.assertEquals(formularioLogic.writtenName(), txtName);
	}

	@Test
	public void deveIteragirSwitchEScheckbox() throws MalformedURLException {

		formularioLogic.setModel(formDto2);

		formularioLogic.mudaSwitch(true);
		formularioLogic.mudaCheckbox(true);
				
		Assert.assertTrue(formularioLogic.isCheckboxSelected());
		Assert.assertEquals(true, formularioLogic.isSwitchSelected());
	}

	@Test
	public void deveCadastrarNomeDemorado() throws MalformedURLException {
		formularioLogic.setModel(formDto1);

		formularioLogic.escreveNome();
		formularioLogic.salvarFormDemorado();

		Assert.assertTrue(isValuePresentOnRequest("Nome: ".concat(formDto1.getNome())));
	}

	@Test
	public void deveResolverDesafio() {

		formularioLogic.setModel(formDto_desafio);
		formularioLogic.escreveNome();
		formularioLogic.selecionaConsole();
		formularioLogic.mudaSwitch();
		formularioLogic.mudaCheckbox();
		formularioLogic.salvarForm();

		Assert.assertTrue(IsNameConsoleSwitchAndCheckboxValueSetCorrect());
	}

	private boolean isValuePresentOnRequest(String... values) {
		return formularioLogic.getAllFormResponse().containsAll(Arrays.asList(values));
	}

	public boolean IsNameConsoleSwitchAndCheckboxValueSetCorrect() {
		return formularioLogic.getAllFormResponse().containsAll(
				Arrays.asList("Nome: ".concat(formDto_desafio.getNome()),
						"Console: ".concat(formularioLogic.getFormModel().getConsoleRequestStr()),
						"Switch: ".concat(formularioLogic.getFormModel().switchStatus()),
						"Checkbox: ".concat(formularioLogic.getFormModel().checkBoxStatus())));
	}

	@Override
	protected void setupBaseLogic() {

		this.formularioLogic = new FormularioLogic();
		this.menuLogic = new MenuLogic();

		formDto1 = new FormularioModel("Wagnão", GameConsole.NINTENDO_SWITCH, true, false);
		formDto2 = new FormularioModel("Aquino", GameConsole.XBOX_ONE, true, true);
		formDto_desafio = new FormularioModel("Gharbo", GameConsole.PS4, false, true);

		menuLogic.clicaFormulario();

	}
}
