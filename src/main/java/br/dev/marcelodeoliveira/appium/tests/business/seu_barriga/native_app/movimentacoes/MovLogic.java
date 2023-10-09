package br.dev.marcelodeoliveira.appium.tests.business.seu_barriga.native_app.movimentacoes;

import br.dev.marcelodeoliveira.appium.core.BaseLogic;
import br.dev.marcelodeoliveira.appium.core.BasePage;
import br.dev.marcelodeoliveira.appium.tests.business.seu_barriga.native_app.menu.MenuPage;

public class MovLogic extends BaseLogic {

	private MovPage movPage;
	private MenuPage menuPage;

	public void salvar() {
		click(movPage.getBtnSalvar());

	}

	@Override
	protected void setupPages(BasePage... pages) {

		this.movPage = new MovPage();
		this.menuPage = new MenuPage();

	}

	public void selecionaTipoMov(String tipoDespesa) {
		longClick(getElementCenter(movPage.getMovComboSpinner()));
		click(getElementByText(tipoDespesa));

	}

	public String getLblAlertMsg() {
		return getText(movPage.getLblAlertMessage());
	}

	public String getLblAlertMsgSuccess() {

		return getText(getElementByText("Movimentação cadastrada com sucesso"));
	}

	public void insereDescricao(String descricao) {

		clickAndWriteText(movPage.getTxtDescricao(), descricao);
	}

	public void insereInteressado(String interessado) {
		writeText(movPage.getTxtInteressado(), interessado);
	}

	public void insereValor(String valor) {
		writeText(movPage.getTxtValor(), valor);
	}

	public void selecionaTipoConta(String nomeConta) {
		longClick(getElementCenter(movPage.getMovComboContas()));
		click(getElementByText(nomeConta));
	}

	public void clicaMov() {
		click(menuPage.getBtnMov());

	}



}
