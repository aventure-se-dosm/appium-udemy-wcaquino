package br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.logic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import br.dev.marcelodeoliveira.appium.core.BaseLogic;
import br.dev.marcelodeoliveira.appium.core.BasePage;
import br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.page.FormularioPage;
import br.dev.marcelodeoliveira.appium.tests.model.dto.FormularioModel;
import io.appium.java_client.MobileElement;

public class FormularioLogic extends BaseLogic {

	private FormularioPage page;
	private FormularioModel formModel;

	public FormularioModel getFormModel() {
		return formModel;
	}

	public MobileElement getMenuGame(String console) {
		return page.getMenuGameConsoles().stream().filter(e -> e.getText().equalsIgnoreCase(console)).findFirst().get();
	}

	public void escreveNome(String txtNameString) {
		writeText(page.getTxtName(), txtNameString);
	}

	public void escreveNome() {
		escreveNome(formModel.getNome());
	}

	public boolean getResponseTuplesIfPresent(String... values) {
		return getAllFormResponse().containsAll(Arrays.asList(values));
	}

	public void mudaSwitch(boolean status) {
		changeElementState(page.getSwitchHour(), status);
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
		waitUntilWebElementToBeVisibleAndNotNull(page.getLblName());
	}

	public void salvarFormDemorado() {
		click(page.getBtnSalvarDemorado());
		waitUntilWebElementToBeVisibleAndNotNull(page.getLblName());

	}

	public void selecionaConsole(String console) {
		click(page.getSpinner());
		click(page.getMenuGame(console));
	}

	public List<String> getAllFormResponse() {
		return page.getListAllTextView().stream().map(elem -> elem.getText()).filter(s -> ((String) s).contains(": "))
				.collect(Collectors.toList());
	}

	public String getFormResponseAttribute(String attribute) {
		return getAllFormResponse().stream().map(s -> s.toLowerCase())
				.filter(s -> ((String) s).contains(attribute.toLowerCase() + ": ")).findAny().get();
	}

	@Override
	protected void setupPages(BasePage... pages) {
		this.page = new FormularioPage();
	}

	public String writtenName() {
		return getText(page.getTxtName());
	}

	public String getLblHourStr() {
		return getText(page.getLblHourAndMinutes());
	}

	public void setModel(FormularioModel formModel) {
		if (isNull(getFormModel()))
			this.formModel = formModel;

	}

	public void selecionaConsole() {
		selecionaConsole(formModel.getConsoleComboStr());
	}

	public void mudaSwitch() {
		mudaSwitch(formModel.isSwitchSelected());

	}

	public void mudaCheckbox() {
		mudaCheckbox(formModel.isCheckBoxSelected());
	}

	public String getLblDateStr() {
		return getText(page.getLblDate());
	}

}