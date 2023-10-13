package br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.logic;

import org.junit.Assert;

import br.dev.marcelodeoliveira.appium.core.BaseLogic;
import br.dev.marcelodeoliveira.appium.core.BasePage;
import br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.page.TimePickerPage;

public class TimePickerLogic extends BaseLogic {

	private TimePickerPage page;

	public Object getHoraTxt(Integer hora) {
		return super.getText(page.getHora(hora));
	}

	public Object getMinutoTxt(Integer minuto) {
		return super.getText(page.getMinuto(minuto));
	}

	public void selecionaHora(Integer hour, Integer minute) {
		click(page.getLblTime());
		click(page.getBtnKeyboardInput());
		writeText(page.getTxtHour(), hour.toString());
		writeText(page.getTxtMinute(), minute.toString());

	}

	public void selecionaHoraSimples(Integer hour, Integer minute) {
		int roundMinute = roundBy5(minute);
		System.out.println(minute);
		Assert.assertTrue(super.getAssertionMessage(50, roundMinute), 50 == roundMinute);
		click(page.getLblTime());
		click(page.getHora(hour));
		click(page.getMinuto(minute));

	}

	private Integer roundBy5(Integer integer) {
		if (integer % 5 != 0) {
			integer = integer + (integer % 5 < 3 ? -integer % 5 : 5 - integer % 5);
		}
		return integer;
	}

	public String getHoraTxt() {
		return getText(page.getLblTime());
	}

	public void clicaOk() {
		click(page.getBtnOk());
	}

	@Override
	protected void setupPages(BasePage... pages) {
		this.page = new TimePickerPage();
	}

}
