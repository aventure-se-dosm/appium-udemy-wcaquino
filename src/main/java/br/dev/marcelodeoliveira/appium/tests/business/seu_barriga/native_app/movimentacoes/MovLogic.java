package br.dev.marcelodeoliveira.appium.tests.business.seu_barriga.native_app.movimentacoes;

import br.dev.marcelodeoliveira.appium.core.BaseLogic;
import br.dev.marcelodeoliveira.appium.core.BasePage;
import br.dev.marcelodeoliveira.appium.tests.business.seu_barriga.native_app.home.HomePage;
import br.dev.marcelodeoliveira.appium.tests.business.seu_barriga.native_app.menu.MenuPage;
import br.dev.marcelodeoliveira.appium.tests.business.seu_barriga.native_app.resumo.ResumoPage;

public class MovLogic extends BaseLogic {

	private HomePage homePage;
	private MovPage movPage;
	private MenuPage menuPage;
	private ResumoPage resumoPage;

	public void salvar() {
		click(movPage.getBtnSalvar());

	}

	@Override
	protected void setupPages(BasePage... pages) {

		this.homePage = new HomePage();
		this.movPage = new MovPage();
		this.menuPage = new MenuPage();
		this.resumoPage = new ResumoPage();

	}

	public void selecionaTipoMov(String tipoDespesa) {
		longClick(getElementCenter(movPage.getMovComboSpinner()));
		click(getElementByText(tipoDespesa));

	}

	public String getLblAlertMsg() {
		return getText(movPage.getLblAlertMessage());
	}
	public String getrResumoLblAlertMsg() {
		return getText(movPage.getLblResumoAlertMessage());
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

	public String obterSaldoConta3Txt() {
		return getText(homePage.getLblTargetAccountBalance());
	}

	public void clicaResumo() {
		click(menuPage.getBtnResumo());
	}

	public void excluiTransacaoChave() {
		click(menuPage.getBtnResumo());
		swipeLeft(waitUntilElementToBePresent(resumoPage.getTestTransactionToExclude()));
		click(resumoPage.getDelButton());
		waitUntilWebElementToBeVisibleAndNotNull(resumoPage.getLblAlert());
	}

	public void clicaContas() {
		click(menuPage.getBtnConta());
		scrollDown();
	}

	public void atualizaSaldo() {
		click(menuPage.getBtnHome());
		scrollUp(0.98f, 0.10f);
	}

	public Object getSaldoContaTarget() {
		return getText(homePage.getNovoSaldoContaTarget());
	}

}
