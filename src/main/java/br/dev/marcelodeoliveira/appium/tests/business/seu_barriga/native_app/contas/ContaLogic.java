package br.dev.marcelodeoliveira.appium.tests.business.seu_barriga.native_app.contas;

import java.time.LocalDate;

import org.openqa.selenium.By;

import br.dev.marcelodeoliveira.appium.core.BaseLogic;
import br.dev.marcelodeoliveira.appium.core.BasePage;
import br.dev.marcelodeoliveira.appium.tests.business.seu_barriga.native_app.menu.MenuPage;

public class ContaLogic extends BaseLogic {

	private ContasPage page;
	private MenuPage menuPage;
	private final String ACCOUNT_NAME_PREFFIX = "Conta";
	private final String ACCOUNT_DUPLICATE_NAME = "Conta mesmo nome";

	public void clickContas() {
		click(menuPage.getBtnConta());
	}

	private String getUniqueAccountName() {
		return String.join("_", ACCOUNT_NAME_PREFFIX, LocalDate.now().toString());
	}

	void cadastraConta(String nomeConta) {
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
		this.page = new ContasPage();
	}

	public void excluiConta(String nomeConta) {

		longClick(getElementCenter(getElement(
				By.xpath(String.format("//android.view.ViewGroup/android.widget.TextView[@text='%s']", nomeConta)))));
		click(page.getBtnExcluir());
	}

	public String getAlertContaSalva() {

		return getText(getElementByText("Conta excluída com sucesso", "android.widget.TextView"));
	}

	public String getAlertErrorContaEmUso() {

		return getText(getElementByText("Conta em uso nas movimentações", "android.widget.TextView"));
	}

}
