package br.dev.marcelodeoliveira.appium.tests.business.seu_barriga.native_app.contas;

import java.time.LocalDate;

import br.dev.marcelodeoliveira.appium.core.BasePage;
import br.dev.marcelodeoliveira.appium.tests.business.seu_barriga.native_app.SeuBarrigaNativoLogic;

public class ContaLogic extends SeuBarrigaNativoLogic {

	private ContaPage page;
	private final String ACCOUNT_NAME_PREFFIX = "Conta";
	private final String ACCOUNT_DUPLICATE_NAME = "Conta mesmo nome";

	public void clickContas() {
		click(page.getBtnConta());

	}

	private String getUniqueAccountName() {
		return String.join("_", ACCOUNT_NAME_PREFFIX, LocalDate.now().toString());
	}

	private void cadastraConta(String nomeConta) {
		writeText(page.getTxtNomeConta(), nomeConta);
		click(page.getBtnSalvar());
	}

	public void cadastraContaComSucesso() {
		cadastraConta(getUniqueAccountName());
	}

	public void cadastraContaComMesmoNome() {
		cadastraConta(ACCOUNT_DUPLICATE_NAME);
	}

	public String getAlertMessageSuccess() {
		return getText(page.getLblAlertSuccessMessage());
	}

	public String getAlertMessageFail() {
		return getText(page.getLblAlertFailMessage());
	}

	@Override
	protected void setupPages(BasePage... pages) {
		this.page = new ContaPage();
	}

}
