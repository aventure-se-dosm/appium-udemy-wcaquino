package br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.steps;

import org.junit.Assert;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.core.CTAppiumBaseTestVersionable;
import br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.logic.MenuLogic;

public class ScrollSteps extends CTAppiumBaseTestVersionable {

	private MenuLogic menuLogic;

	@Test
	public void deveEncontrarOpcaoEscondidaNoMenuPorScroll() {
		menuLogic.clicaOpcaoEscondida();
		Assert.assertEquals("Sucesso", menuLogic.getAlertTitleTxt());
		Assert.assertEquals("Você achou essa opção", menuLogic.getAlertMessageTxt());
		menuLogic.clicaAlertOk();
	}

	@Override
	protected void setupBaseLogic() {
		this.menuLogic = new MenuLogic();
	}
}
