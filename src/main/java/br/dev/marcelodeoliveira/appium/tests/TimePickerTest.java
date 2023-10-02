package br.dev.marcelodeoliveira.appium.tests;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.addCapability;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setDefaultCapabilities;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setupDriver;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.logic.MenuLogic;
import br.dev.marcelodeoliveira.appium.tests.logic.TimePickerLogic;
import io.appium.java_client.remote.MobileCapabilityType;

public class TimePickerTest extends BaseTest {
	private TimePickerLogic timePickerLogic;
	private MenuLogic menuLogic;

	@Before
	public void setupTest() {
		setDefaultCapabilities();
		addCapability(MobileCapabilityType.APP,
				"C:/Users/MarcelodeOliveiraSan/Workspace/APPIUM/CursoAppium/src/main/resources/apks/CTAppium_2_0.apk");
		setupDriver();

		this.menuLogic = new MenuLogic();
		this.timePickerLogic = new TimePickerLogic();
	}

	@Test
	public void deveAlterarHoraEMinutoPorClique() {

		final Integer hour = 15;
		final Integer minute = 50;
		Assert.assertTrue(minute % 5 == 0);
		menuLogic.clicaFormulario();
		timePickerLogic.selecionaHoraSimples(hour, minute);
		timePickerLogic.clicaOk();
		Assert.assertEquals(LocalTime.of(hour, minute).format(DateTimeFormatter.ofPattern("HH:mm")),
				timePickerLogic.getHoraTxt());
	}

	@Test
	public void deveAlterarHoraEMinutoPorValorInserido() {

		final Integer hour = 15;
		final Integer minute = 39;

		menuLogic.clicaFormulario();
		timePickerLogic.selecionaHora(hour, minute);
		timePickerLogic.clicaOk();
		Assert.assertEquals(LocalTime.of(hour, minute).format(DateTimeFormatter.ofPattern("HH:mm")),
				timePickerLogic.getHoraTxt());
	}

}
