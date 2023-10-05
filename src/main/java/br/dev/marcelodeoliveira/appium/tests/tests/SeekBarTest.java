package br.dev.marcelodeoliveira.appium.tests.tests;

import org.junit.Assert;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.logic.FormularioLogic;
import br.dev.marcelodeoliveira.appium.tests.logic.MenuLogic;
import br.dev.marcelodeoliveira.appium.tests.logic.SeekBarLogic;

public class SeekBarTest extends CTAppiumBaseTestVersionable {

	MenuLogic menuLogic;
	SeekBarLogic seekBarLogic;
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
	protected void setupLogic() {
		// TODO Auto-generated method stub
		this.menuLogic = new MenuLogic();
		this.formularioLogic = new FormularioLogic();
		this.seekBarLogic = new SeekBarLogic();
	}

}
