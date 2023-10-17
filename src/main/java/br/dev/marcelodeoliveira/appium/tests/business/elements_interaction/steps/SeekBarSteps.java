package br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.steps;

import org.junit.Assert;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.core.CTAppiumBaseTestVersionable;
import br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.logic.FormularioLogic;
import br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.logic.MenuLogic;
import br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.logic.SeekBarLogic;

public class SeekBarSteps extends CTAppiumBaseTestVersionable {

	private MenuLogic menuLogic;
	private SeekBarLogic seekBarLogic;
	private FormularioLogic formularioLogic;

	@Test
	public void moveSeekBar() {
		Float porcentagem = 0.76f;
		menuLogic.clicaFormulario();
		seekBarLogic.moveSeekBarParaPorcentagemEscolhida(porcentagem);
		formularioLogic.salvarForm();
		String resp = formularioLogic.getFormResponseAttribute("Slider");
		Assert.assertTrue(resp, resp.contains(Integer.toString((int) (porcentagem * 100f))));
	}

	@Override
	protected void setupBaseLogic() {

		this.menuLogic = new MenuLogic();
		this.formularioLogic = new FormularioLogic();
		this.seekBarLogic = new SeekBarLogic();
	}

}
