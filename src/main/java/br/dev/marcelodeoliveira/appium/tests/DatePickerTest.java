package br.dev.marcelodeoliveira.appium.tests;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.addCapability;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setDefaultCapabilities;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setupDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.logic.DatePickerLogic;
import br.dev.marcelodeoliveira.appium.tests.logic.MenuLogic;
import io.appium.java_client.remote.MobileCapabilityType;

public class DatePickerTest extends BaseTest {
	MenuLogic menuLogic;
	DatePickerLogic datePickerLogic;

	@Before
	public void setupTest() {
		setDefaultCapabilities();
		addCapability(MobileCapabilityType.APP,
				"C:/Users/MarcelodeOliveiraSan/Workspace/APPIUM/CursoAppium/src/main/resources/apks/CTAppium_2_0.apk");
		setupDriver();

		this.menuLogic = new MenuLogic();
		this.datePickerLogic = new DatePickerLogic();

	}
	
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
		
}
