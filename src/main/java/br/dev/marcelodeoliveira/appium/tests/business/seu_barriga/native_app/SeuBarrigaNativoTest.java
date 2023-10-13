package br.dev.marcelodeoliveira.appium.tests.business.seu_barriga.native_app;

import br.dev.marcelodeoliveira.appium.core.CTAppiumBaseTestVersionable;
import br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.logic.MenuLogic;
import br.dev.marcelodeoliveira.appium.tests.business.seu_barriga.native_app.logic.LoginLogic;

public abstract class SeuBarrigaNativoTest extends CTAppiumBaseTestVersionable {

	private MenuLogic menuLogic;
	private LoginLogic loginLogic;

	protected abstract void setupLogic();

	@Override
	protected void setupBaseLogic() {
		this.loginLogic = new LoginLogic();
		this.menuLogic = new MenuLogic();
		setupLogic();
		menuLogic.clicaSeuBarrigaNativo();
		loginLogic.login();
		loginLogic.defaultTestSetUpReset();

	}

}
