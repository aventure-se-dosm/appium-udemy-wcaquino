package br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.core.CTAppiumBaseTestVersionable;
import br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.logic.MenuLogic;
import br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.logic.TimePickerLogic;

public class TimePickerTest extends CTAppiumBaseTestVersionable {
	private TimePickerLogic timePickerLogic;
	private MenuLogic menuLogic;

	@Test
	public void deveAlterarHoraEMinutoPorClique() {

		Integer hour = 15;
		Integer minute = 50;
		Assert.assertTrue(minute % 5 == 0);
		menuLogic.clicaFormulario();
		timePickerLogic.selecionaHoraSimples(hour, minute);
		timePickerLogic.clicaOk();
		Assert.assertEquals(LocalTime.of(hour, minute).format(DateTimeFormatter.ofPattern("HH:mm")),
				timePickerLogic.getHoraTxt());
	}

	@Test
	public void deveAlterarHoraEMinutoPorValorInserido() {

		Integer hour = 15;
		Integer minute = 39;

		menuLogic.clicaFormulario();
		timePickerLogic.selecionaHora(hour, minute);
		timePickerLogic.clicaOk();
		Assert.assertEquals(LocalTime.of(hour, minute).format(DateTimeFormatter.ofPattern("HH:mm")),
				timePickerLogic.getHoraTxt());
	}

	@Override
	protected void setupBaseLogic() {
		this.menuLogic = new MenuLogic();
		this.timePickerLogic = new TimePickerLogic();
	}

}
