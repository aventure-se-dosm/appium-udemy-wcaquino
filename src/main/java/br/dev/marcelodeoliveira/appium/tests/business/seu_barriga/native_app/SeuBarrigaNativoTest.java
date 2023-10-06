package br.dev.marcelodeoliveira.appium.tests.business.seu_barriga.native_app;

import org.junit.Test;

import br.dev.marcelodeoliveira.appium.core.CTAppiumBaseTestVersionable;
import br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.menu.MenuLogic;

public class SeuBarrigaNativoTest extends CTAppiumBaseTestVersionable {

	private SeuBarrigaNativoLogic sbLogic;
	private MenuLogic menuLogic;

	@Test
	public void deveCadastrarContaComSucesso() {

	}

	@Override
	protected void setupLogic() {
		this.sbLogic = new SeuBarrigaNativoLogic();
		this.menuLogic = new MenuLogic();
		menuLogic.clicaSeuBarrigaNativo();
		sbLogic.login();
		sbLogic.defaultTestSetUpReset();

	}

}
