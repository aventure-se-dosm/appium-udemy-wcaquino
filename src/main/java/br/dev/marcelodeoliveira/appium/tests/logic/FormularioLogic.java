package br.dev.marcelodeoliveira.appium.tests.logic;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;

import br.dev.marcelodeoliveira.appium.tests.model.pages.BasePage;
import br.dev.marcelodeoliveira.appium.tests.model.pages.FormularioPage;
import io.appium.java_client.MobileElement;

public class FormularioLogic extends BaseLogic {

//	@AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text, 'Nome: ')]")
//	private MobileElement lblName;
//
//	private MobileElement getLblName() {
//		return lblName;
//	}
//
//	@AndroidFindBy(accessibility = "nome")
//	private MobileElement txtName;
//
//	@AndroidFindBy(accessibility = "console")
//	private MobileElement spinner;
//
//	@AndroidFindBy(accessibility = "check")
//	private MobileElement chkDate;
//
//	@AndroidFindBy(accessibility = "switch")
//	private MobileElement switchHour;
//
//	@AndroidFindBy(xpath = "//android.widget.CheckedTextView")
//	private List<MobileElement> menuGameConsoles;
//
//	@AndroidFindBy(accessibility = "save")
//	private MobileElement btnSalvar;
//
//	@AndroidFindBy(xpath = "//*[@text='SALVAR DEMORADO']")
//	private MobileElement btnSalvarDemorado;
//
//	@AndroidFindAll(value = { @AndroidBy(xpath = "//android.widget.TextView") })
//	List<MobileElement> listAllTextView;

	private FormularioPage page;
//
//	private MobileElement getBtnSalvarDemorado() {
//		return btnSalvarDemorado;
//	}
//
//	public MobileElement getTxtName() {
//		return txtName;
//	}
//
//	public MobileElement getSpinner() {
//		return spinner;
//	}
//
//	public MobileElement getChkDate() {
//		return chkDate;
//	}
//
//	public MobileElement getSwitchHour() {
//		return switchHour;
//	}

	public MobileElement getMenuGame(String console) {
		return page.getMenuGameConsoles().stream().filter(e -> e.getText().equalsIgnoreCase(console)).findFirst().get();
	}
//
//	private List<MobileElement> getMenuGameConsoles() {
//
//		return menuGameConsoles;
//	}
//
//	public MobileElement getBtnSalvar() {
//		return btnSalvar;
//	}
//
//	public List<MobileElement> getListAllTextView() {
//		return listAllTextView;
//	}

	public void escreveNome(String txtNameString) {
		writeText(page.getTxtName(), txtNameString);
	}

	public void mudaSwitch(boolean status) {
		changeElementState(page.getSwitchHour(), status);
		Assert.assertEquals(true, isSwitchSelected());

	}

	public void mudaCheckbox(boolean status) {
		changeElementState(page.getChkDate(), status);
	}

	public boolean isCheckboxSelected() {
		return isElementChecked(page.getChkDate());
	}

	public boolean isSwitchSelected() {
		return isElementChecked(page.getSwitchHour());
	}

	public void salvarForm() {

		click(page.getBtnSalvar());
		waitUntilWebElementToBeVisibleAndItsNotNull(page.getLblName());
	}

	public void salvarFormDemorado() {
		click(page.getBtnSalvarDemorado());
		waitUntilWebElementToBeVisibleAndItsNotNull(page.getLblName());

	}

	public void selecionaConsole(String selectedGameConsole) {
		click(page.getSpinner());
		click(page.getMenuGame(selectedGameConsole));
	}

	public List<String> getAllFormResponse() {
		return getListAllTextView().stream().map(elem -> elem.getText()).filter(s -> ((String) s).contains(": "))
				.collect(Collectors.toList());
	}

	private Collection<MobileElement> getListAllTextView() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getFormResponseAttribute(String attribute) {
		return getAllFormResponse().stream().map(s -> s.toLowerCase())
				.filter(s -> ((String) s).contains(attribute.toLowerCase() + ": ")).findAny().get();

	}

	@Override
	protected void setupPages(BasePage... pages) {
		this.page = new FormularioPage();
	}

}