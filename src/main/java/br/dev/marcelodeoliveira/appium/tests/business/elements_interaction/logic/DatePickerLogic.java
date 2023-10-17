package br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.logic;

import br.dev.marcelodeoliveira.appium.core.BaseLogic;
import br.dev.marcelodeoliveira.appium.core.BasePage;
import br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.page.DatePickerPage;

public class DatePickerLogic extends BaseLogic {

	private DatePickerPage page;

	public String getLblDateText() {
		return getText(page.getBtnDate());
	}

	public void clicaData() {
		click(page.getBtnDate());
	}

	public void atualizaData() {
		clicaData();
		clicaOk();
	}

	public void clicaOk() {
		click(page.getBtnOk());
	}

	public void escolheDia(Integer dia) {
		click(page.getListBtnDias().stream().filter(day -> day.getText().contains(dia.toString())).findFirst().get());
	}

	@Override
	protected void setupPages(BasePage... pages) {
		this.page = new DatePickerPage();
	}

}