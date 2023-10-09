package br.dev.marcelodeoliveira.appium.tests.business.seu_barriga.native_app.contas;

import br.dev.marcelodeoliveira.appium.core.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ContaPage extends BasePage {

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Conta']")
	private MobileElement txtNomeConta;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Conta adicionada com sucesso']")
	private MobileElement alertSuccessMessage;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Problemas de comunicação']")
	private MobileElement alertFailMessage;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SALVAR']/ancestor::android.widget.Button")
	private MobileElement btnSalvar;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='EXCLUIR']/ancestor::android.widget.Button")
	private MobileElement btnExcluir;

//	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Contas']")
//	private MobileElement btnConta;
//
//	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Mov...']")
//	private MobileElement btnMov;
//
//	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Resumo']")
//	private MobileElement btnHome;
//
//	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Home']")
//	private MobileElement btnResumo;

	public MobileElement getAlertMessage() {
		return alertSuccessMessage;
	}

	public MobileElement getBtnSalvar() {
		return btnSalvar;
	}

	public MobileElement getBtnExcluir() {
		return btnExcluir;
	}

	public MobileElement getTxtNomeConta() {
		return txtNomeConta;
	}

	public MobileElement getLblAlertSuccessMessage() {
		return alertSuccessMessage;
	}

	public MobileElement getLblAlertFailMessage() {
		return alertFailMessage;
	}

	public MobileElement getAlertSuccessMessage() {
		return alertSuccessMessage;
	}

	public MobileElement getAlertFailMessage() {
		return alertFailMessage;
	}

}
