package br.dev.marcelodeoliveira.appium.tests;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.logic.DatePickerLogic;
import br.dev.marcelodeoliveira.appium.tests.logic.MenuLogic;

public class DatePickerTest extends CTAppiumBaseTest {
	MenuLogic menuLogic;
	DatePickerLogic datePickerLogic;


	
	@Test
	public void deveMudarDataDoDiaParaDiaSelecionado() {
		Integer diaSelecionado = 5;
		LocalDate oldDate;
		
		menuLogic.clicaFormulario();
		oldDate = LocalDate.parse(datePickerLogic.getLblDateText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		datePickerLogic.clicaData();
		datePickerLogic.escolheDia(diaSelecionado);
		datePickerLogic.clicaOk();
		Assert.assertEquals(
				LocalDate.of(oldDate.getYear(), oldDate.getMonth(), diaSelecionado).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
				datePickerLogic.getLblDateText());
	}

	@Override
	protected void setupLogic() {
		// TODO Auto-generated method stub
		this.menuLogic = new MenuLogic();
		this.datePickerLogic = new DatePickerLogic();
		
	}
		
}
