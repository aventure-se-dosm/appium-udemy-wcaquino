package br.dev.marcelodeoliveira.appium.tests.model.pages;

import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FormularioPage extends BasePage{
	

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Formulário']")
	MobileElement formulario;

	@AndroidFindBy(accessibility = "nome")
	MobileElement txtName;

	@AndroidFindBy(accessibility = "console")
	MobileElement spinner;

	@AndroidFindBy(accessibility = "check")
	MobileElement chkDate;

	@AndroidFindBy(accessibility = "switch")
	MobileElement switchHour;

	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Nintendo Switch']")
	MobileElement menuGame;

	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Salvar']")
	MobileElement btnSalvar;

	@AndroidFindAll(value = { @AndroidBy(xpath = "//android.widget.TextView") })
	List<MobileElement> listAllTextView;

	public MobileElement getFormulario() {
		return formulario;
	}

	public MobileElement getTxtName() {
		return txtName;
	}

	public MobileElement getSpinner() {
		return spinner;
	}

	public MobileElement getChkDate() {
		return chkDate;
	}

	public MobileElement getSwitchHour() {
		return switchHour;
	}

	public MobileElement getMenuGame() {
		return menuGame;
	}

	public MobileElement getBtnSalvar() {
		return btnSalvar;
	}

	public List<MobileElement> getListAllTextView() {
		return listAllTextView;
	}

}