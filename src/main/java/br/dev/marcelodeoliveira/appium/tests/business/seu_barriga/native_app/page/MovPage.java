package br.dev.marcelodeoliveira.appium.tests.business.seu_barriga.native_app.page;

import br.dev.marcelodeoliveira.appium.core.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MovPage extends BasePage {

	public MobileElement getMovComboSpinner() {
		return MovComboSpinner;
	}

	public MobileElement getMovConta() {
		return MovComboSpinner;
	}

	public MobileElement getComboDespesa() {
		return comboDespesa;
	}

	@AndroidFindBy(xpath = "//android.widget.Spinner[1]")
	private MobileElement MovComboSpinner;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SALVAR']/../../android.widget.Spinner[2]")
	private MobileElement MovComboContas;

	@AndroidFindBy(xpath = "//com.ctappium:id/select_dialog_listview/*[@text='Receita']")
	private MobileElement comboReceita;

	@AndroidFindBy(xpath = "//com.ctappium:id/select_dialog_listview/*[@text='comboDespesa']")
	private MobileElement comboDespesa;

	@AndroidFindBy(className = "android.widget.Switch")
	private MobileElement switchElem;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SALVAR']/..")
	private MobileElement btnSalvar;

	@AndroidFindBy(xpath = "//android.widget.TextView/following-sibling[@text='Salvar']")
	private MobileElement btnDataMovimentacao;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Descrição']")
	private MobileElement txtDescricao;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Interessado']")
	private MobileElement txtInteressado;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Valor']")
	private MobileElement txtValor;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SALVAR']/../following-sibling::*")
	private MobileElement lblAlertMessage;

	public MobileElement getLblResumoAlertMessage() {
		return lblResumoAlertMessage;
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ATUALIZAR']/../following-sibling::*")
	private MobileElement lblResumoAlertMessage;

	public MobileElement getComboSpinner() {
		return MovComboSpinner;
	}

	public MobileElement getComboReceita() {
		return comboReceita;
	}

	public MobileElement getDespesa() {
		return comboDespesa;
	}

	public MobileElement getSwitchElem() {
		return switchElem;
	}
	
	public MobileElement getMovComboContas() {
		return MovComboContas;
	}

	public MobileElement getBtnSalvar() {
		return btnSalvar;
	}

	public MobileElement getBtnDataMovimentacao() {
		return btnDataMovimentacao;
	}

	public MobileElement getTxtDescricao() {
		return txtDescricao;
	}

	public MobileElement getTxtInteressado() {
		return txtInteressado;
	}

	public MobileElement getTxtValor() {
		return txtValor;
	}

	public MobileElement getLblAlertMessage() {
		return lblAlertMessage;
	}

}
