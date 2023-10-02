package br.dev.marcelodeoliveira.appium.tests.model.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FormularioPage extends BasePage {


	@AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text, 'Nome: ')]")
	private MobileElement lblName;

	public MobileElement getLblName() {
		return lblName;
	}

	@AndroidFindBy(accessibility = "nome")
	private MobileElement txtName;

	@AndroidFindBy(accessibility = "console")
	private MobileElement spinner;

	@AndroidFindBy(accessibility = "check")
	private MobileElement chkDate;

	@AndroidFindBy(accessibility = "switch")
	private MobileElement switchHour;

	@AndroidFindBy(xpath = "//android.widget.CheckedTextView")
	private List<MobileElement> menuGameConsoles;

	@AndroidFindBy(accessibility = "save")
	private MobileElement btnSalvar;

	@AndroidFindBy(xpath = "//*[@text='SALVAR DEMORADO']")
	private MobileElement btnSalvarDemorado;

	@AndroidFindAll(value = { @AndroidBy(xpath = "//android.widget.TextView") })
	List<MobileElement> listAllTextView;

	public MobileElement getBtnSalvarDemorado() {
		return btnSalvarDemorado;
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


	public void escreveNome(String txtNameString) {
		writeText(getTxtName(), txtNameString);
	}

	public void mudaSwitch(boolean status) {
		changeElementState(getSwitchHour(), status);
		Assert.assertEquals(true, isSwitchSelected());

	}

	public void mudaCheckbox(boolean status) {
		changeElementState(getChkDate(), status);
	}

	public boolean isCheckboxSelected() {
		return isElementChecked(getChkDate());
	}

	public boolean isSwitchSelected() {
		return isElementChecked(getSwitchHour());
	}

	public void salvarForm() {

		click(getBtnSalvar());
		waitUntilWebElementToBeVisibleAndItsNotNull(getLblName());
	}

	public void salvarFormDemorado() {
		click(getBtnSalvarDemorado());
		waitUntilWebElementToBeVisibleAndItsNotNull(getLblName());

	}

	public void selecionaConsole(String selectedGameConsole) {
		click(getSpinner());
		click(getMenuGame(selectedGameConsole));
	}

	public List<String> getAllFormResponse() {
		return getListAllTextView().stream().map(elem -> elem.getText()).filter(s -> ((String) s).contains(": "))
				.collect(Collectors.toList());
	}
	public String getFormResponseAttribute(String attribute) {
		return getAllFormResponse() .stream().map(s -> s.toLowerCase()).filter(s -> ((String) s).contains(attribute.toLowerCase()+": "))
				.findAny().get();
				
	}

}