package br.dev.marcelodeoliveira.appium.tests.model.pages;

import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FormularioPage extends BasePage {

	@AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text, 'Nome: ')]")
	private MobileElement lblName;

	@AndroidFindBy(accessibility = "nome")
	private MobileElement txtName;

	@AndroidFindBy(accessibility = "console")
	private MobileElement spinner;

	@AndroidFindBy(accessibility = "check")
	private MobileElement chkDate;

	@AndroidFindBy(accessibility = "switch")
	private MobileElement switchHour;
	
	@AndroidFindBy(id = "android:id/hours")
	private MobileElement lblHours;
	
	@AndroidFindBy(id = "android:id/minutes")
	private MobileElement lblMinutes;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, ':00')]")
	private MobileElement lblHourAndMinutes;

	@AndroidFindBy(xpath = "//android.widget.CheckedTextView")
	private List<MobileElement> menuGameConsoles;

	@AndroidFindBy(accessibility = "save")
	private MobileElement btnSalvar;

	@AndroidFindBy(xpath = "//*[@text='SALVAR DEMORADO']")
	private MobileElement btnSalvarDemorado;

	@AndroidFindAll(value = { @AndroidBy(xpath = "//android.widget.TextView") })
	private List<MobileElement> listAllTextView;

	public MobileElement getBtnSalvarDemorado() {
		return btnSalvarDemorado;
	}

	public MobileElement getLblName() {
		return lblName;
	}

	public MobileElement getTxtName() {
		return txtName;
	}

	public MobileElement getLblHourAndMinutes() {
		return lblHourAndMinutes;
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

	public MobileElement getMenuGame(String console) {
		return getMenuGameConsoles().stream().filter(e -> e.getText().equalsIgnoreCase(console)).findFirst().get();
	}

	public List<MobileElement> getMenuGameConsoles() {

		return menuGameConsoles;
	}

	public MobileElement getBtnSalvar() {
		return btnSalvar;
	}

	public List<MobileElement> getListAllTextView() {
		return listAllTextView;
	}

}