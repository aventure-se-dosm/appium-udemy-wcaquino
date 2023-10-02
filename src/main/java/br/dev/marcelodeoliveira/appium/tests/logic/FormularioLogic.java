package br.dev.marcelodeoliveira.appium.tests.logic;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;

import br.dev.marcelodeoliveira.appium.tests.model.pages.BasePage;
import br.dev.marcelodeoliveira.appium.tests.model.pages.FormularioPage;
import io.appium.java_client.MobileElement;

public class FormularioLogic extends BaseLogic {

	private FormularioPage page;

	public MobileElement getMenuGame(String console) {
		//TODO: stream processings should be better on BaseLogic as proper individual methods!
		return page.getMenuGameConsoles().stream().filter(e -> e.getText().equalsIgnoreCase(console)).findFirst().get();
	}

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
		//TODO: stream processings should be better on BaseLogic as proper individual methods!
		return page.getListAllTextView().stream().map(elem -> elem.getText()).filter(s -> ((String) s).contains(": "))
				.collect(Collectors.toList());
	}

	public String getFormResponseAttribute(String attribute) {
		//TODO: stream processings should be better on BaseLogic as proper individual methods!
		return getAllFormResponse().stream().map(s -> s.toLowerCase())
				.filter(s -> ((String) s).contains(attribute.toLowerCase() + ": ")).findAny().get();
	}

	@Override
	protected void setupPages(BasePage... pages) {
		this.page = new FormularioPage();
	}

}