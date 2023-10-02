package br.dev.marcelodeoliveira.appium.tests;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.logic.MenuLogic;
import br.dev.marcelodeoliveira.appium.tests.logic.TimePickerLogic;

public class TimePickerTest extends CTAppiumBaseTest {
	private TimePickerLogic timePickerLogic;
	private MenuLogic menuLogic;

//	@Before
//	public void setupTest() {
//		setDefaultCapabilities();
//		addCapability(MobileCapabilityType.APP,
//				"C:/Users/MarcelodeOliveiraSan/Workspace/APPIUM/CursoAppium/src/main/resources/apks/CTAppium_2_0.apk");
//		setupDriver();
//	}

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

	@Override
	protected void setupLogic() {		
		this.menuLogic = new MenuLogic();
		this.timePickerLogic = new TimePickerLogic();
	}

}
