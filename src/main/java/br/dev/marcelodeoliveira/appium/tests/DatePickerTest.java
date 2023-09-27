package br.dev.marcelodeoliveira.appium.tests;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.addCapability;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setDefaultCapabilities;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setupDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.model.pages.DatePickerPage;
import br.dev.marcelodeoliveira.appium.tests.model.pages.MenuPage;
import io.appium.java_client.remote.MobileCapabilityType;

public class DatePickerTest extends BaseTest {
	MenuPage menuPage;
	DatePickerPage datePickerPage;

	@Before
	public void setupTest() {
		setDefaultCapabilities();
		addCapability(MobileCapabilityType.APP,
				"C:/Users/MarcelodeOliveiraSan/Workspace/APPIUM/CursoAppium/src/main/resources/apks/CTAppium_2_0.apk");
		setupDriver();

		this.menuPage = new MenuPage();
		this.datePickerPage = new DatePickerPage();

	}
	
	@Test
	public void deveMudarDataDoDiaParaDiaSelecionado() {
		Integer diaSelecionado = 5;
		LocalDate oldDate;
		
		menuPage.clicaFormulario();
		oldDate = LocalDate.parse(datePickerPage.getLblDateText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		datePickerPage.clicaData();
		datePickerPage.escolheDia(diaSelecionado);
		datePickerPage.clicaOk();
		Assert.assertEquals(
				LocalDate.of(oldDate.getYear(), oldDate.getMonth(), diaSelecionado).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
				datePickerPage.getLblDateText());
	}
		
}
