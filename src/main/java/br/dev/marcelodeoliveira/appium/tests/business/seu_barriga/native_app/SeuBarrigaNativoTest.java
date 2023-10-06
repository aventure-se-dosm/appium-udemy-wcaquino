package br.dev.marcelodeoliveira.appium.tests.business.seu_barriga.native_app;

import org.junit.Test;

import br.dev.marcelodeoliveira.appium.core.CTAppiumBaseTestVersionable;
import br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.menu.MenuLogic;

public class SeuBarrigaNativoTest extends CTAppiumBaseTestVersionable {

	// Login is mandatory for every package underlying test!
	// It have to be done right here!

	private SeuBarrigaNativoLogic sbLogic;
	private MenuLogic menuLogic;

	// @Ignore
	@Test
	public void deveCadastrarContaComSucesso() {
		;
	}

//	@Override
//	protected void setupTest() {
//		this.sbLogic = new SeuBarrigaNativoLogic();
//		
//		sbLogic.login();
//
//	}

//	@Override
//	public void setupTest() {
//		setupLogic();
//	}

@Override
protected void setupLogic() {
	this.sbLogic = new SeuBarrigaNativoLogic();
	this.menuLogic = new MenuLogic();
	// TODO Auto-generated method stub
	menuLogic.clicaSeuBarrigaNativo();
	sbLogic.login();
	
}

}
