package br.dev.marcelodeoliveira.appium.tests;

import org.junit.Assert;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.logic.MenuLogic;

public class ScrollTest extends CTAppiumBaseTest {

	private MenuLogic menuLogic;



	@Test
	public void deveEncontrarOpcaoEscondidaNoMenuPorScroll() {
		menuLogic.clicaOpcaoEscondida();
		Assert.assertEquals("Sucesso", menuLogic.getAlertTitleTxt());
		Assert.assertEquals("Você achou essa opção", menuLogic.getAlertMessageTxt());
		menuLogic.clicaAlertOk();
	}

	@Override
	protected void setupLogic() {
		// TODO Auto-generated method stub
		this.menuLogic = new MenuLogic();
	}
}
