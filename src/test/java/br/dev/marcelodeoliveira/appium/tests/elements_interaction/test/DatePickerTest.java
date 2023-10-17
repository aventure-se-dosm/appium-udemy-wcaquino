package br.dev.marcelodeoliveira.appium.tests.elements_interaction.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.core.CTAppiumBaseTestVersionable;
import br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.logic.DatePickerLogic;
import br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.logic.MenuLogic;

public class DatePickerTest extends CTAppiumBaseTestVersionable {
	private MenuLogic menuLogic;
	private DatePickerLogic datePickerLogic;

	@Test
	public void deveMudarDataDoDiaParaDiaSelecionado() {
		Integer diaSelecionado = 5;
		LocalDate oldDate;

		menuLogic.clicaFormulario();
		datePickerLogic.atualizaData();
		oldDate = LocalDate.parse(datePickerLogic.getLblDateText(), DateTimeFormatter.ofPattern("d/M/yyyy"));

		datePickerLogic.clicaData();
		datePickerLogic.escolheDia(diaSelecionado);
		datePickerLogic.clicaOk();
		Assert.assertTrue((LocalDate.of(oldDate.getYear(), oldDate.getMonth(), diaSelecionado)
				.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).equals(datePickerLogic.getLblDateText())) ||

				(LocalDate.of(oldDate.getYear(), oldDate.getMonth(), diaSelecionado)
						.format(DateTimeFormatter.ofPattern("d/M/yyyy")).equals(datePickerLogic.getLblDateText()))

		);

	}

	@Override
	protected void setupBaseLogic() {

		this.menuLogic = new MenuLogic();
		this.datePickerLogic = new DatePickerLogic();

	}

}
