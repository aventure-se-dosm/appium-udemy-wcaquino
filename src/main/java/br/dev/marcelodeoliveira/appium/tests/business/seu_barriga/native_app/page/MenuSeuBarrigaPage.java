package br.dev.marcelodeoliveira.appium.tests.business.seu_barriga.native_app.page;

import br.dev.marcelodeoliveira.appium.core.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MenuSeuBarrigaPage extends BasePage {
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Contas']/../*")
	private MobileElement btnConta;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Mov...']/../*")
	private MobileElement btnMov;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Resumo']/../*")
	private MobileElement btnResumo;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Home']/../*")
	private MobileElement  btnHome;

	public MobileElement getBtnConta() {
		return btnConta;
	}

	public MobileElement getBtnMov() {
		return btnMov;
	}

	public MobileElement getBtnHome() {
		return btnHome;
	}

	public MobileElement getBtnResumo() {
		return btnResumo;
	}
}
