package br.dev.marcelodeoliveira.appium.tests;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.addCapability;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setDefaultCapabilities;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setupDriver;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.model.pages.MenuPage;
import br.dev.marcelodeoliveira.appium.tests.model.pages.TimePickerPage;
import io.appium.java_client.remote.MobileCapabilityType;

public class TimePickerTest extends BaseTest {
	private TimePickerPage timePickerPage;
	private MenuPage menuPage;
	//private final DateTimeFormatter DEFAULT_HOUR_MINUTE_PATTERN = DateTimeFormatter.ofPattern("HH:mm");

	@Before
	public void setupTest() {
		setDefaultCapabilities();
		addCapability(MobileCapabilityType.APP,
				"C:/Users/MarcelodeOliveiraSan/Workspace/APPIUM/CursoAppium/src/main/resources/apks/CTAppium_2_0.apk");
		setupDriver();

		this.menuPage = new MenuPage();
		this.timePickerPage = new TimePickerPage();
	}

	@Test
	public void deveAlterarHoraEMinutoPorClique() {

		final Integer hour = 15;
		final Integer minute = 50;
		Assert.assertTrue(minute%5 == 0);
		menuPage.clicaFormulario();
		timePickerPage.selecionaHoraSimples(hour, minute);
		timePickerPage.clicaOk();
		Assert.assertEquals(LocalTime.of(hour, minute).format(DateTimeFormatter.ofPattern("HH:mm")),
				timePickerPage.getHoraTxt());
	}

	
	@Test
	public void deveAlterarHoraEMinutoPorValorInserido() {

		final Integer hour = 15;
		final Integer minute = 39;

		menuPage.clicaFormulario();
		timePickerPage.selecionaHora(hour, minute);
		timePickerPage.clicaOk();
		Assert.assertEquals(LocalTime.of(hour, minute).format(DateTimeFormatter.ofPattern("HH:mm")),
				timePickerPage.getHoraTxt());
	}
	
}
